package ca.scooter.talkufy.firebase

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.IconCompat
import ca.scooter.talkufy.R
import ca.scooter.talkufy.activities.HomeActivity
import ca.scooter.talkufy.activities.MessageActivity
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.Pref
import ca.scooter.talkufy.utils.utils
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.io.File

class MessagingService: FirebaseMessagingService() {

    private val KEY_UNREAD = "unreadCount"
    private val KEY_SENDER = "senderUID"
    private val KEY_RECEIVER = "receiverUID"
    private val KEY_MSG_IDs = "messageIDs"
    private val KEY_SENDER_PHONE = "senderPhoneNumber"
    private val KEY_SENDER_PIC_URL = "senderPhotoURL"
    private val KEY_MESSAGES = "messages"
    private val KEY_IS_MUTED = "isMuted"
    private val KEY_GROUP_NAME = "groupNameIfAny"

    private val MESSAGE_SEPERATOR = "<--MESSAGE_SEPERATOR-->"


    val channelIDSingle =  "talkufy-single"
    val channelIDMerged = "talkufy-merged"
    val channelNameIndividual = "Individual"
    val channelNameMerged = "Merged"


    object NotificationDetail {
        val SINGLE_ID = 123456
        val MUlTIPLE_ID = 654321
    }



    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        Log.d("MessagingService", "onMessageReceived: ${p0.data}")
        val data: MutableMap<String, String>? = p0.data

        val sender = data!![KEY_SENDER]!!
        val receiver = data[KEY_RECEIVER]!!

        if(FirebaseUtils.getUid() != receiver)
            return


        setAllMessageFromUserAsDelivered(receiver, sender, data[KEY_MSG_IDs]!!)

        if(!data.containsKey(KEY_MESSAGES)){
            Log.d("MessagingService", "onMessageReceived: a silent notification has been generated")
            return
        }


        if(Pref.getCurrentTargetUID(this) == sender) {
            Log.d("MessagingService", "onMessageReceived: currently chatting with -> $sender")
            return
        }



                    if( utils.isAppIsInBackground(this@MessagingService)
                        || Pref.getCurrentTargetUID(this@MessagingService) != sender){
                        //app is in background show notification
                        showNotification(p0)
                    }
                    else {

                        if(Pref.Notification.hasVibrationEnabled(this@MessagingService))
                            utils.vibrate(this@MessagingService)
                    }





    }


    private fun showNotification(remoteMessage: RemoteMessage){
        val data = remoteMessage.data

        val totalMessage = data[KEY_UNREAD]
        val sender = data[KEY_SENDER]
        val senderPhone = data[KEY_SENDER_PHONE]


        var name = utils.getNameFromNumber(this@MessagingService, senderPhone!!)

        if(utils.isGroupID(sender!!))
            name = data[KEY_GROUP_NAME]!!

        val intent = Intent(this@MessagingService, MessageActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra(FirebaseUtils.KEY_UID, sender)
            putExtra(utils.constants.KEY_IS_ONCE, true)
        }
        if(utils.isGroupID(sender)) {
            intent.putExtra(utils.constants.KEY_TARGET_TYPE, FirebaseUtils.KEY_CONVERSATION_GROUP)
            intent.putExtra(utils.constants.KEY_NAME_OR_NUMBER, data[KEY_GROUP_NAME]!!)
        }else  {
            intent.putExtra(utils.constants.KEY_NAME_OR_NUMBER, senderPhone)
            intent.putExtra(utils.constants.KEY_TARGET_TYPE, FirebaseUtils.KEY_CONVERSATION_SINGLE)
        }


        notify(name, intent, remoteMessage)

        Log.d("MessagingService", "showNotification: sender = $sender")

       utils.printIntentKeyValues(intent)


    }


    @SuppressLint("UnspecifiedImmutableFlag")
    private fun notify(title:String, intent: Intent, remoteMessage: RemoteMessage){
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this@MessagingService,
            NotificationDetail.SINGLE_ID, intent,
            PendingIntent.FLAG_UPDATE_CURRENT)

        val data = remoteMessage.data


        val notification = NotificationCompat.Builder(this@MessagingService, channelIDSingle)
            .setContentTitle(title)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText("Tap to read")
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContentIntent(pendingIntent)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setColor(ContextCompat.getColor(this@MessagingService, R.color.colorPrimary))
            .setLargeIcon((BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)))
            .setPriority(android.app.Notification.PRIORITY_MAX)
            .setAutoCancel(true)

        val isSoundEnabled = Pref.Notification.hasSoundEnabled(this)
        val isVibrationEnabled = Pref.Notification.hasVibrationEnabled(this)


        Log.d("MessagingService", "notify: sound = $isSoundEnabled , vibration = $isVibrationEnabled")


        if(isSoundEnabled && isVibrationEnabled){
            notification.setDefaults(Notification.DEFAULT_ALL)
        }

        else if(isSoundEnabled && !isVibrationEnabled){
            notification.setDefaults(Notification.DEFAULT_SOUND)
        }

        else if(!isSoundEnabled && isVibrationEnabled){
            notification.setDefaults(Notification.DEFAULT_VIBRATE)
        }
        else{
            notification.setDefaults(Notification.DEFAULT_LIGHTS)
        }

        // for single message
        updateNotificationWithBigText(remoteMessage, notification)

        getAllUnreadMessages(notification)

    }


    private fun getAllUnreadMessages(notificationCompatBuilder: NotificationCompat.Builder){
        var unreadCount = 0
        var unreadConversation = 0


        Log.d("MessagingService", "getAllUnreadMessages: check if more than one conversation has unread messages")



        FirebaseUtils.ref.allMessageStatusRootRef()
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    //iterate through every node to check for unread messages

                    val totalConversation = p0.childrenCount
                    for((index,snapshot) in p0.children.withIndex()){
                        snapshot.ref.orderByChild("read")
                            .equalTo(false)
                            .addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onCancelled(p0: DatabaseError) {
                                }

                                override fun onDataChange(p1: DataSnapshot) {


                                    Log.d("MessagingService", "onDataChange: unread messages = ${p1.value}")
//                                    Log.d("MessagingService", "onDataChange: ref = ${p1.ref}")

                                    if (p1.exists()) {
                                        unreadCount += p1.childrenCount.toInt()
                                        unreadConversation++
                                    }

                                    Log.d("MessagingService", "onDataChange: index = $index")

                                    if (index == totalConversation.toInt() - 1) {

                                        Log.d("MessagingService", "onDataChange: last index")

                                        if(index == 0)
                                            return



                                        if(unreadConversation<=1) {
                                            //updateNotificationWithBigText(remoteMessage, notificationCompatBuilder)
                                            return
                                        }


                                        val title = "$unreadCount messages from $unreadConversation conversations"
                                        Log.d("MessagingService", "onDataChange: $title")


                                        val intent = Intent(this@MessagingService, HomeActivity::class.java).apply {
                                            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        }

                                        notificationCompatBuilder.setStyle(NotificationCompat.BigTextStyle()
                                            .setBigContentTitle(title)
                                            .bigText("Tap to Read"))
                                            .setDefaults(Notification.DEFAULT_LIGHTS)
                                            .setSmallIcon(R.mipmap.ic_launcher)
                                            .setColor(ContextCompat.getColor(this@MessagingService, R.color.colorPrimary))
                                            .setLargeIcon((BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)))
                                            .setContentIntent(PendingIntent.getActivity(this@MessagingService,
                                                NotificationDetail.MUlTIPLE_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT))
                                            .setContentTitle(title)
                                            .setChannelId(channelIDMerged)

                                        getNotificationManager(notificationCompatBuilder, channelNameMerged, channelIDMerged).notify(
                                            NotificationDetail.MUlTIPLE_ID, notificationCompatBuilder.build())

                                    }
                                }
                            })
                    }

                }
            })
    }


    private fun updateNotificationWithBigText(
        remoteMessage: RemoteMessage,
        notificationCompatBuilder: NotificationCompat.Builder
    ){

        notificationCompatBuilder.setChannelId(channelIDSingle)

        val profilePicFile = File(utils.getProfilePicPath(this)+remoteMessage.data[KEY_SENDER]!!+".jpg")

        val messages = getMessages(remoteMessage.data[KEY_MESSAGES]!!)


        var name = utils.getNameFromNumber(this@MessagingService, remoteMessage.data[KEY_SENDER_PHONE]!!)
        val sender = remoteMessage.data[KEY_SENDER]!!

        if(utils.isGroupID(sender))
            name = remoteMessage.data[KEY_GROUP_NAME]!!

        var conversationName = name
        if(conversationName.isEmpty()){
            conversationName = "New Group Messages"
        }

        val conversation = Person.Builder().setName(conversationName)

           if(utils.hasStoragePermission(this)) {
               if(profilePicFile.exists()) {
                   conversation.setIcon(IconCompat.createWithBitmap(utils.getCircleBitmap(BitmapFactory.decodeFile(profilePicFile.path))))
                   notificationCompatBuilder.setLargeIcon(utils.getCircleBitmap(BitmapFactory.decodeFile(profilePicFile.path)))
               }
               else{
                   Log.d("MessagingService", "updateNotificationWithBigText: profile doesn't exists")
               }
           }

        val style = NotificationCompat.MessagingStyle(conversation.build())
//        style.conversationTitle = conversationName

        val personName = utils.getNameFromNumber(this@MessagingService, remoteMessage.data[KEY_SENDER_PHONE]!!)
        val person = Person.Builder().setName(personName).build()

        messages.forEach {
            Log.d("MessagingService", "updateNotificationWithBigText: messages = $it")
            if(it.trim().isNotEmpty() && messages.size<=4)
            style.addMessage(
                it.replace(MESSAGE_SEPERATOR,"").trim(), System.currentTimeMillis(), conversation.build()
            )
        }


        notificationCompatBuilder.setStyle(style)

        notificationCompatBuilder.setNumber(messages.size)



        getNotificationManager(notificationCompatBuilder, channelNameIndividual, channelIDSingle).notify(
            NotificationDetail.SINGLE_ID, notificationCompatBuilder.build())




    }


    private fun getNotificationManager(notificationCompatBuilder: NotificationCompat.Builder, channelName:String, channelID:String): NotificationManager{
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val descriptionText = "Talkufy notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelID, channelName, importance).apply {
                description = descriptionText
            }

            channel.enableLights(true)
            channel.lightColor = Color.GREEN
            channel.setShowBadge(true)
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

            // Register the channel with the system
            notificationManager.createNotificationChannel(channel)
            notificationCompatBuilder.setChannelId(channelID)
        }

        return notificationManager
    }


    private fun setAllMessageFromUserAsDelivered(uid:String, targetUID:String, msgIDs:String){

        val ids = getIDs(msgIDs)

        ids.forEach {
            FirebaseUtils.ref.messageStatus(uid, targetUID, it)
                .child("delivered")
                .setValue(true)
        }
    }

    fun getIDs(msgIDsString: String): List<String> =
        msgIDsString.replace(",", " ").trim().split(" ")

    fun getMessages(messageString: String): List<String> =
        messageString.split(MESSAGE_SEPERATOR)
    //should remove message seperator on last value

    override fun onNewToken(p0: String) {

        val token = p0


        Pref.storeToken(this, token)
        FirebaseUtils.updateFCMToken()


        super.onNewToken(p0)
    }


}