package ca.scooter.talkufy.activities

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import kotlinx.android.synthetic.main.activity_forward.*
import kotlinx.android.synthetic.main.item__forward_contact_list.view.*
import kotlinx.android.synthetic.main.item_contact_layout.view.*
import me.shaohui.advancedluban.Luban
import me.shaohui.advancedluban.OnCompressListener
import org.jetbrains.anko.collections.forEachWithIndex
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.longToast
import org.jetbrains.anko.onComplete
import org.jetbrains.anko.uiThread
import java.io.File
import java.util.concurrent.Future

class ForwardActivity : AppCompatActivity() {

    val selectedUIDs:MutableList<String> = ArrayList()
    val selectedTitles:MutableList<String> = ArrayList()
    val selectedNumbers:MutableList<String> = ArrayList()

    val allFrequentUIDs:MutableList<String> = ArrayList()

    var isImageFromIntent = false
    var isVideoFromIntent = false
    var isTextFromIntent = false

    val allFrequentConverstation:MutableList<Models.LastMessageDetail> = ArrayList()

    //number list has 10 digit formatted number
    var numberList:MutableList<Models.Contact> = mutableListOf()
    var registeredAvailableUser:MutableList<Models.Contact> = mutableListOf()

    var nameOfRecipient :String = ""

    private var allContactAdapter: RecyclerView.Adapter<ViewHolder>? = null

    val context = this@ForwardActivity
    private var myUID: String = ""

    var fwd_snackbar: Snackbar? = null

    var messageModels: MutableList<Models.MessageModel>? = ArrayList()

    var progressDialog:ProgressDialog? = null

    var currentMessageID = ""
    private var asyncLoader: Future<Unit>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forward)

        setSupportActionBar(toolbar)


        if(supportActionBar!=null)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if(!FirebaseUtils.isLoggedIn()){
            startActivity(packageManager.getLaunchIntentForPackage(packageName))
            finish()
            return
        }


        fwd_snackbar = Snackbar.make(sendBtn, "", Snackbar.LENGTH_INDEFINITE)

        caption_layout.visibility = View.GONE

        recyclerLayout.visibility = View.GONE
        asyncLoader = doAsyncResult {
            uiThread { setFrequentAdapter() }
            onComplete { uiThread { recyclerLayout.visibility = View.VISIBLE } }

        }

        myUID = FirebaseUtils.getUid()

        try {
            messageModels = intent.getSerializableExtra(utils.constants.KEY_MSG_MODEL) as MutableList<Models.MessageModel>
        }
        catch (e:Exception){ messageModels = ArrayList()}

        if(messageModels.isNullOrEmpty())
            handleIncomingIntents(intent)


        sendBtn?.setOnClickListener {



                if (isImageFromIntent) {
                    //image is sent via intent

                    if(bitmap!=null){
                        val messageID = "MSG${System.currentTimeMillis()}"
                        val currentFile = utils.saveBitmapToSent(context, bitmap!!, messageID)
                        Luban.compress(context, File(currentFile))
                            .putGear(Luban.THIRD_GEAR)
                            .launch(object : OnCompressListener{
                                override fun onSuccess(file: File?) {
                                    uploadAndForward(messageID, file!!, File(currentFile),
                                        utils.constants.FILE_TYPE_IMAGE)
                                }

                                override fun onError(e: Throwable?) {
                                    uploadAndForward(messageID, File(currentFile), File(currentFile),
                                        utils.constants.FILE_TYPE_IMAGE)
                                    Log.d(
                                        "ForwardActivity",
                                        "onError: failed to compress original image, uploading original image"
                                    )
                                }

                                override fun onStart() {
                                    progressDialog?.setMessage("Please wait...")
                                    progressDialog?.show()
                                }

                            })

                    }
                    else{
                        utils.toast(context, "Image might be corrupted")
                        finish()
                    }

                }

                else if(isVideoFromIntent){

                    if(currentVideoFile!=null){
                        val messageID = "MSG${System.currentTimeMillis()}"
                        progressDialog?.setMessage("Please wait...")
                        progressDialog?.show()
                        uploadAndForward(messageID, currentVideoFile!!, currentVideoFile!!,
                            utils.constants.FILE_TYPE_VIDEO)
                    }

                }

                else{
                    onForwardToSelectedUIDs()
                }


        }
    }


    private fun onForwardToSelectedUIDs() {


        selectedUIDs.forEachWithIndex { i, it->

            var messageID = "MSG${System.currentTimeMillis()}"

            if(currentMessageID.isNotEmpty())
                messageID = currentMessageID

            val targetUID = it

            val positionInMainList = allFrequentUIDs.indexOf(it)


        for (model in messageModels!!) {
            model.from = myUID
            model.timeInMillis = System.currentTimeMillis()
            model.reverseTimeStamp = model.timeInMillis * -1
            model.to = targetUID
            model.caption = ""

            if(caption_layout.visibility == View.VISIBLE && captionEditText.text.isNotEmpty())
                model.caption = captionEditText.text.toString()

            val currentModel = model
            var nameOrNumber: String
            var type: String

            if(positionInMainList > -1) {
                 nameOrNumber = allFrequentConverstation[positionInMainList].nameOrNumber
                 type = allFrequentConverstation[positionInMainList].type
            }
            else{
                nameOrNumber = registeredAvailableUser.filter { it.uid == targetUID }[0].number
                type = FirebaseUtils.KEY_CONVERSATION_SINGLE
            }


            if(nameOrNumber.isEmpty()){
                nameOrNumber = if(utils.isGroupID(targetUID) || utils.isChannelID(targetUID)) selectedTitles[i]
                else selectedNumbers[i]
            }

            //send to my node
            FirebaseUtils.ref.getChatRef(myUID, targetUID)
                .child(messageID)
                .setValue(currentModel)
                .addOnSuccessListener {
                    FirebaseUtils.setMessageStatusToDB(messageID, myUID, targetUID, true, isRead = true,
                        groupOrChannelNameIf = nameOrNumber)

                    FirebaseUtils.ref.lastMessage(myUID)
                        .child(targetUID)
                        .setValue(
                            Models.LastMessageDetail(nameOrNumber =  nameOrNumber ,
                            type = type))

                }

            currentModel.file_local_path = ""


            if(utils.isGroupID(targetUID)){
                //send to group members
                Log.d("ForwardActivity", "onForwardToSelectedUIDs: group id = $targetUID")
                addMessageToGroupMembers(messageID, currentModel, targetUID, nameOrNumber)
            }
            else  if(utils.isChannelID(targetUID)){
                //send to channel members
                Log.d("ForwardActivity", "onForwardToSelectedUIDs: channel id = $targetUID")
                addMessageToChannelMembers(messageID, currentModel, targetUID, nameOrNumber)
            }
            else {
                //send to target node
                FirebaseUtils.ref.getChatRef(targetUID, FirebaseUtils.getUid())
                    .child(messageID)
                    .setValue(currentModel)
                    .addOnSuccessListener {
                        FirebaseUtils.setMessageStatusToDB(messageID, targetUID, myUID, false, isRead = false,groupOrChannelNameIf = "")

                        FirebaseUtils.ref.lastMessage(targetUID)
                            .child(myUID)
                            .setValue(Models.LastMessageDetail(nameOrNumber = FirebaseUtils.getPhoneNumber(), type = type))
                    }
            }
        }
    }

//        if(selectedUIDs.size == 1)
//            startActivities(arrayOf(
//                Intent(context, HomeActivity::class.java)
//                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP),
//                Intent(context, MessageActivity::class.java).apply {
//                    putExtra(FirebaseUtils.KEY_UID, selectedUIDs[0])
//                    putExtra(utils.constants.KEY_NAME_OR_NUMBER , allFrequentConverstation[0].nameOrNumber)
//                )
//                }
//                )
//            )
//        else

            startActivity(Intent(context, HomeActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

        finish()
    }


    var bitmap:Bitmap? = null
    var currentVideoFile:File? = null

    private fun handleIncomingIntents(intent: Intent){

        progressDialog = ProgressDialog(this)
        progressDialog?.setCancelable(false)

        caption_layout.visibility = View.VISIBLE

        if(intent.action == Intent.ACTION_SEND){
            when {
                intent.type == "text/plain" -> {
                    val text = intent.getStringExtra(Intent.EXTRA_TEXT)
                    text?.let { Models.MessageModel(it) }?.let { messageModels!!.add(it) }
                    isTextFromIntent = true
                    caption_layout.visibility = View.GONE
                }
                intent.type?.startsWith( "image/")?:false -> {

                    if(!utils.hasStoragePermission(this)) {
                        utils.toast(this, "App does not have storage permission")
                        finish()
                        return
                    }
                    val imageURI = intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as Uri
                    bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageURI)
                    isImageFromIntent = true
                    caption_layout.visibility = View.VISIBLE

                    preview.setImageBitmap(bitmap)

                }
                intent.type?.startsWith("video/")?:false -> {
                    if(!utils.hasStoragePermission(this)){
                        utils.toast(this, "App does not have storage permission")
                        finish()
                        return
                    }

                    play_icon.visibility = View.VISIBLE
                    videoLength.visibility = View.VISIBLE

                    try{
                         val videoUri = intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as Uri
                    Log.d("ForwardActivity", "handleIncomingIntents: initial video path = ${videoUri.path}")
                    val videoFile =  File(utils.getRealPathFromURI(this, videoUri))
                    Log.d("ForwardActivity", "handleIncomingIntents: real video path = ${videoFile.path}")


                    if(!videoFile.exists()){
                        utils.toast(context, "Something went wrong in video file")
                        finish()
                    }

                        videoLength.text = utils.getVideoLength(context, videoFile.path)

                     utils.setVideoThumbnailFromWebAsync(context, videoFile.path, preview)

                    if(videoFile.length() > (16 * 1024 * 1024)){
                        utils.toast(context, "Please choose a file smaller than 16 MB")
                        finish()
                    }

                    currentVideoFile = videoFile
                    isVideoFromIntent = true

                    }
                    catch (e:Exception){
                        longToast("Failed to load video")
                        finish()
                    }
                    caption_layout.visibility = View.VISIBLE

                }
            }
        }
    }


    private fun uploadAndForward(
        messageID:String,
        file: File,
        originalFile: File,
        fileType: String
    ){


        currentMessageID = messageID


       val ref = FirebaseStorage.getInstance().reference
           .child(fileType)
            .child(messageID)

           val uploadTask = ref.putFile(utils.getUriFromFile(context, file))

               uploadTask
                   .addOnProgressListener {
                       val percentage:Double = (100.0 * it.bytesTransferred) / it.totalByteCount
                       val percent = String.format("%.2f",percentage)
                       progressDialog!!.setMessage("Uploading media $percent%")

                   }
                   .continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                   if (!task.isSuccessful) {
                       task.exception?.let {
                           throw it
                       }
//                       FirebaseUtils.storeFileMetaData(messageID, task.result!!.metadata!!)

                   }
                   return@Continuation ref.downloadUrl
               })

               .addOnCompleteListener { task->
                progressDialog!!.dismiss()

                val model = (Models.MessageModel(task.result.toString(), isFile = true, file_local_path = originalFile.path, file_size_in_bytes = file.length(), messageType = fileType))
                   messageModels!!.add(model)


                   FirebaseUtils.storeFileMetaData(
                       Models.File(messageID,
                           model.timeInMillis, fileType = fileType,
                           fileSizeInBytes = file.length(),
                           bucket_path = ref.bucket,
                           file_url = task.result.toString(),
                        file_extension = utils.getFileExtension(file)
                       ))

                onForwardToSelectedUIDs()
            }



    }

    var adapter: FirebaseRecyclerAdapter<Models.LastMessageDetail, ViewHolder>? = null

    private fun setFrequentAdapter(){

        val lastMsgQuery = FirebaseUtils.ref.lastMessage(FirebaseUtils.getUid())
                .orderByChild(FirebaseUtils.KEY_REVERSE_TIMESTAMP)

        val options = FirebaseRecyclerOptions.Builder<Models.LastMessageDetail>()
            .setQuery(lastMsgQuery, Models.LastMessageDetail::class.java)
            .build()

        adapter = object : FirebaseRecyclerAdapter<Models.LastMessageDetail, ViewHolder>(options){
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
                ViewHolder(
                    layoutInflater.inflate(
                        R.layout.item__forward_contact_list,
                        p0,
                        false
                    )
                )

            override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Models.LastMessageDetail) {

                val uid = super.getRef(position).key.toString()

                val type = model.type

                bindHolder(holder, uid,model.nameOrNumber, type)

            }

        }

        frequentRecyclerView.adapter = adapter

        adapter?.startListening()

        lastMsgQuery.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){

                    for (item in p0.children) {
                        if (!allFrequentUIDs.contains(item.key)) {
                            allFrequentUIDs.add(item.key!!)
                            allFrequentConverstation.add(item.getValue(Models.LastMessageDetail::class.java)!!)
                        }
                    }
                }

                loadRegisteredUsers()
            }

        })

    }



    private fun setAllContactAdapter(){

        Log.d("ForwardActivity", "setAllContactAdapter: $registeredAvailableUser")

        allContactAdapter = object : RecyclerView.Adapter<ViewHolder>(){
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
                ViewHolder(
                    layoutInflater.inflate(
                        R.layout.item__forward_contact_list,
                        p0,
                        false
                    )
                )


            override fun getItemCount(): Int = registeredAvailableUser.size

            override fun onBindViewHolder(holder: ViewHolder, p1: Int) {

                val uid = registeredAvailableUser[p1].uid

                bindHolder(holder, uid, registeredAvailableUser[p1].number , FirebaseUtils.KEY_CONVERSATION_SINGLE)

            }

        }
        allContactRecyclerView.adapter = allContactAdapter



    }


    @SuppressLint("RestrictedApi")
    private fun bindHolder(holder: ViewHolder, uid:String, phone:String, type:String){

        val isGroup = type == FirebaseUtils.KEY_CONVERSATION_GROUP
        val isChannel = type == FirebaseUtils.KEY_CONVERSATION_CHANNEL

        if(forward_progressbar.visibility == View.VISIBLE)
            forward_progressbar.visibility = View.GONE

        holder.title.text = phone



        if(isGroup) {
            FirebaseUtils.loadGroupPicThumbnail(context, uid, holder.pic)
            if(phone.isEmpty())
                FirebaseUtils.setGroupName(uid, holder.title)
        }
        else if(isChannel) {
            FirebaseUtils.loadChannelPicThumbnail(context, uid, holder.pic)
            if(phone.isEmpty())
                FirebaseUtils.setChannelName(uid, holder.title)
        }
        else {
            FirebaseUtils.loadProfileThumbnail(context, uid, holder.pic)
            if(phone.isNotEmpty()){
                holder.title.text = utils.getNameFromNumber(context, phone)
            }
            else{
                FirebaseUtils.setUserDetailFromUID(context, holder.title, uid, true)
            }
        }

        holder.title.setTextColor(Color.BLACK)

        if(isGroup) {
            //check if not in group
            checkIfInGroup(uid, holder)
        }
        else if(isChannel) {
            //check if not in channel
            checkIfInChannel(uid, holder)
        }
        else{
            //check if user is blocked
            checkIfBlocked(uid, holder)
        }



        holder.itemView.setOnClickListener {
            holder.checkBox.isChecked = !holder.checkBox.isChecked


            if(holder.checkBox.isChecked) {
                selectedUIDs.add(uid)
                selectedTitles.add(holder.title.text.toString())
                selectedNumbers.add(phone)
            }
            else {
                selectedUIDs.remove(uid)
                selectedTitles.remove(holder.title.text.toString())
                selectedNumbers.remove(phone)
            }

            nameOfRecipient  = selectedTitles.joinToString(", ")

             fwd_snackbar?.setText(">  ${nameOfRecipient.trim()}")

            sendBtn.visibility = if(selectedUIDs.isEmpty()) View.GONE else View.VISIBLE

            if(selectedUIDs.isEmpty()) {fwd_snackbar!!.dismiss()
            nameOfRecipient = ""
            }
            else { if(!fwd_snackbar!!.isShown) fwd_snackbar!!.show() }

        }
    }

    private fun loadRegisteredUsers(){

        numberList = utils.getContactList(this)

        FirebaseUtils.ref.allUser()
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(p0: DataSnapshot) {

                    if(!p0.exists()) {
                      //  utils.toast(context, "No registered users")
                        return
                    }

                    registeredAvailableUser.clear()

                    for (post in p0.children){
                        val userModel = post.getValue(Models.User ::class.java)

                        val number = utils.getFormattedTenDigitNumber(userModel!!.phone)
                        val uid = userModel.uid

                        if(uid == FirebaseUtils.getUid())
                            continue

                        for((index, item) in numberList.withIndex()) {
                            if (item.number == number || item.number.contains(number)) {
                                numberList[index].uid = uid
                                if(!allFrequentUIDs.any { it == uid } && !registeredAvailableUser.any{ it == numberList[index] }
                                    && !registeredAvailableUser.any { it.number == number }
                                )
                                registeredAvailableUser.add(numberList[index])
                            }

                        }

                    }

                    setAllContactAdapter()


                }

                override fun onCancelled(p0: DatabaseError) {
                }

            })
    }


    //for group members
    private fun addMessageToGroupMembers(messageID: String, messageModel: Models.MessageModel, groupId:String
                                         , groupName:String) {

        FirebaseUtils.ref.groupMembers(groupId)
            .orderByChild("removed").equalTo(false)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    val groupMembers:MutableList<Models.GroupMember> = ArrayList()
                    for(post in p0.children){
                        groupMembers.add(post.getValue(Models.GroupMember::class.java)!!)

                        groupMembers.forEach {
                            val memberID = it.uid

                            //setting  message to target
                            if(memberID != myUID) {

                                Log.d("MessageActivity", "addMessageToGroupMembers: targets -> $memberID")

                                FirebaseUtils.ref.getChatRef(memberID, groupId)  // must be (participant, groupID)
                                    .child(messageID)
                                    .setValue(messageModel)
                                    .addOnSuccessListener {

                                        FirebaseUtils.setMessageStatusToDB(messageID, memberID, groupId, false, false,
                                            groupName)

                                        FirebaseUtils.ref.lastMessage(memberID)
                                            .child(groupId)
                                            .setValue(
                                                Models.LastMessageDetail(type = FirebaseUtils.KEY_CONVERSATION_GROUP
                                                    , nameOrNumber = groupName
                                                ))

                                    }
                            }
                        }
                    }
                }
            })
    }


    //for channel members
    private fun addMessageToChannelMembers(messageID: String, messageModel: Models.MessageModel, channelId:String
                                           , channelName:String) {

        FirebaseUtils.ref.channelMembers(channelId)
            .orderByChild("removed").equalTo(false)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    val channelMembers:MutableList<Models.ChannelMember> = ArrayList()
                    for(post in p0.children){
                        channelMembers.add(post.getValue(Models.ChannelMember::class.java)!!)

                        channelMembers.forEach {
                            val memberID = it.uid

                            //setting  message to target
                            if(memberID != myUID) {

                                Log.d("MessageActivity", "addMessageToChannelMembers: targets -> $memberID")

                                FirebaseUtils.ref.getChatRef(memberID, channelId)  // must be (participant, channelID)
                                    .child(messageID)
                                    .setValue(messageModel)
                                    .addOnSuccessListener {

                                        FirebaseUtils.setMessageStatusToDB(messageID, memberID, channelId, false, false,
                                            channelName)

                                        FirebaseUtils.ref.lastMessage(memberID)
                                            .child(channelId)
                                            .setValue(
                                                Models.LastMessageDetail(type = FirebaseUtils.KEY_CONVERSATION_CHANNEL
                                                    , nameOrNumber = channelName
                                                ))

                                    }
                            }
                        }
                    }
                }
            })
    }



    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
         val title = view.name!!
         val pic = view.pic!!
         val checkBox = view.checkbox!!

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return item?.let { super.onOptionsItemSelected(it) }
    }


    override fun onDestroy() {
        asyncLoader?.cancel(true)
        adapter?.stopListening()
        super.onDestroy()
    }


    private fun checkIfBlocked(uid: String, holder: ViewHolder){
        FirebaseUtils.ref.blockedUser(myUID, uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(p0: DataSnapshot) {
                    holder.itemView.isEnabled = true
                    if (p0.exists()) {
                        holder.itemView.isEnabled = !p0.value.toString().toBoolean()
                    }
                    holder.itemView.isClickable = holder.itemView.isEnabled
                    holder.title.setTextColor(if (holder.itemView.isEnabled) Color.BLACK else Color.LTGRAY)


                }

            })

        FirebaseUtils.ref.blockedUser(uid, myUID)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(p0: DataSnapshot) {
                    holder.itemView.isEnabled = true
                    if (p0.exists()) {
                        holder.itemView.isEnabled = !p0.value.toString().toBoolean()
                    }
                    holder.itemView.isClickable = holder.itemView.isEnabled
                    holder.title.setTextColor(if (holder.itemView.isEnabled) Color.BLACK else Color.LTGRAY)


                }

            })

    }


    private fun checkIfInGroup(selectedGroupID:String, holder: ViewHolder){

        holder.itemView.isEnabled = true
        holder.itemView.isClickable = true
        holder.title.setTextColor(if(holder.itemView.isEnabled) Color.BLACK else Color.LTGRAY)



        FirebaseUtils.ref.groupMembers(selectedGroupID)
            .orderByChild("removed").equalTo(false)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    //only available members will be returned
                    var isMeRemoved = false

                    isMeRemoved = if(!p0.exists())
                        true
                    else
                        !p0.children.any {
                            it.getValue(Models.GroupMember::class.java)?.uid == myUID }

                    Log.d("ForwardActivity", "bindHolder: group name = ${holder.title.text}")
                    Log.d("ForwardActivity", "bindHolder: group id = $selectedGroupID")
                    Log.d("ForwardActivity", "onDataChange: removed = $isMeRemoved")

                    try {

                        holder.itemView.isEnabled = !isMeRemoved
                        holder.itemView.isClickable = holder.itemView.isEnabled
                        holder.title.setTextColor(if(holder.itemView.isEnabled) Color.BLACK else Color.LTGRAY)

                    }
                    catch (e:Exception){}

                }
            })
    }

    private fun checkIfInChannel(selectedChannelID:String, holder: ViewHolder){

        holder.itemView.isEnabled = true
        holder.itemView.isClickable = true
        holder.title.setTextColor(if(holder.itemView.isEnabled) Color.BLACK else Color.LTGRAY)



        FirebaseUtils.ref.channelMembers(selectedChannelID)
            .orderByChild("removed").equalTo(false)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    //only available members will be returned
                    var isMeRemoved: Boolean

                    isMeRemoved = if(!p0.exists())
                        true
                    else
                        !p0.children.any {
                            it.getValue(Models.ChannelMember::class.java)?.uid == myUID }

                    Log.d("ForwardActivity", "bindHolder: channel name = ${holder.title.text}")
                    Log.d("ForwardActivity", "bindHolder: channel id = $selectedChannelID")
                    Log.d("ForwardActivity", "onDataChange: removed = $isMeRemoved")

                    try {
                        FirebaseUtils.ref.channelMember(selectedChannelID,myUID)
                            .addValueEventListener(object : ValueEventListener {
                                override fun onCancelled(p0: DatabaseError) {
                                    isMeRemoved = false
                                    holder.itemView.isEnabled = !isMeRemoved
                                    holder.itemView.isClickable = holder.itemView.isEnabled
                                    holder.title.setTextColor(if(holder.itemView.isEnabled) Color.BLACK else Color.LTGRAY)
                                }

                                override fun onDataChange(p0: DataSnapshot) {

                                    if(p0.exists()){
                                        val member = p0.getValue(Models.ChannelMember::class.java)!!
                                        if(!member.admin){
                                             isMeRemoved = false
                                        }

                                    }else{
                                        isMeRemoved = false
                                    }

                                    holder.itemView.isEnabled = !isMeRemoved
                                    holder.itemView.isClickable = holder.itemView.isEnabled
                                    holder.title.setTextColor(if(holder.itemView.isEnabled) Color.BLACK else Color.LTGRAY)

                                }
                            })


                    }
                    catch (e:Exception){}

                }
            })
    }

}
