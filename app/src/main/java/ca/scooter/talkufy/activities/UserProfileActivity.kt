package ca.scooter.talkufy.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import com.vincent.filepicker.DividerGridItemDecoration
import com.yarolegovich.lovelydialog.LovelyTextInputDialog
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.content_user_profile.*
import kotlinx.android.synthetic.main.item_group_member_layout.view.*
import kotlinx.android.synthetic.main.item_image.view.*
import kotlinx.android.synthetic.main.item_video.view.*
import me.shaohui.advancedluban.Luban
import me.shaohui.advancedluban.OnCompressListener
import org.jetbrains.anko.*
import org.jetbrains.anko.collections.forEachWithIndex
import java.io.File
import java.util.concurrent.Future

class UserProfileActivity : AppCompatActivity() {

    val messageModels: MutableList<Models.MessageModel> = ArrayList<Models.MessageModel>()
    var myUID = ""
    var targetUID = ""
    var isBlockedByMe = false
    var isPhoneLoaded = false
    var name = ""
    var isGroup = false
    var isChannel = false
    var amIAdmin = false
    var channel_is_Public = false

    private var asyncLoader: Future<Boolean>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeButtonEnabled(true)
        }


        FirebaseUtils.setonDisconnectListener()

        contentView?.setBackgroundColor(Color.TRANSPARENT)

        myUID = FirebaseUtils.getUid()

        targetUID = intent.getStringExtra(FirebaseUtils.KEY_UID).toString()
        name = intent.getStringExtra(FirebaseUtils.KEY_NAME).toString()

        isGroup = intent.getBooleanExtra(utils.constants.KEY_IS_GROUP, false)
        isChannel = intent.getBooleanExtra(utils.constants.KEY_IS_CHANNEL, false)

        title = if (isGroup || isChannel) name else utils.getNameFromNumber(this, name)

        utils.printIntentKeyValues(intent)
        add_group_member_btn.visibility = View.GONE

        if (isGroup) {
            phone_textview.visibility = View.GONE
            loadGroupMembers()

        } else if (isChannel) {
            phone_textview.visibility = View.GONE
            loadChannelMembers()

        } else {
            phone_textview.text = name
            isPhoneLoaded = true
        }

        if (phone_textview.text.isEmpty() && !isGroup && !isChannel) {
            // if phone number is not available
            FirebaseUtils.ref.allUser()
                .child(targetUID)
                .child(FirebaseUtils.KEY_PHONE)
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        phone_textview.text = p0.getValue(String::class.java)
                        isPhoneLoaded = true
                        invalidateOptionsMenu()
                    }

                })

        }

        val layoutManager = GridLayoutManager(this, 4)
        mediaRecyclerView.addItemDecoration(DividerGridItemDecoration(this))
        mediaRecyclerView.isNestedScrollingEnabled = true

        mediaRecyclerView.layoutManager = layoutManager



        asyncLoader = doAsyncResult {

            uiThread {

                if (isGroup)
                    FirebaseUtils.loadGroupPic(context, targetUID, user_profile_imageview)
                else if (isChannel)
                    FirebaseUtils.loadChannelPic(context, targetUID, user_profile_imageview)
                else
                    FirebaseUtils.loadProfilePic(
                        this@UserProfileActivity,
                        targetUID,
                        user_profile_imageview
                    )

                //loading media recyclerview
                FirebaseUtils.ref.getChatRef(myUID, targetUID)
                    .orderByChild(FirebaseUtils.KEY_REVERSE_TIMESTAMP)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                        }

                        @SuppressLint("NotifyDataSetChanged")
                        override fun onDataChange(p0: DataSnapshot) {


                            messageModels.clear()

                            if (!p0.exists())
                                return

                            p0.children.forEach {
                                val model = it.getValue(Models.MessageModel::class.java)

                                if (model!!.file_local_path.isNotEmpty() && File(model.file_local_path).exists())
                                    messageModels.add(it.getValue(Models.MessageModel::class.java)!!)
                            }


                            if (messageModels.isEmpty())
                                return

                            if (mediaRecyclerView.adapter != null)
                                mediaRecyclerView.adapter!!.notifyDataSetChanged()
                            else {

                                mediaRecyclerView.adapter =
                                    object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
                                        override fun onCreateViewHolder(
                                            p0: ViewGroup,
                                            p1: Int
                                        ): RecyclerView.ViewHolder {
                                            //0 for image
                                            //1 for video right now

                                            return if (p1 == 0) imageHolder(
                                                layoutInflater.inflate(
                                                    R.layout.item_image,
                                                    p0,
                                                    false
                                                )
                                            )
                                            else videoHolder(
                                                layoutInflater.inflate(
                                                    R.layout.item_video,
                                                    p0,
                                                    false
                                                )
                                            )


                                        }

                                        override fun getItemCount(): Int = messageModels.size

                                        override fun getItemViewType(position: Int): Int {
                                            return if (messageModels[position].messageType == utils.constants.FILE_TYPE_IMAGE) 0 else 1
                                        }

                                        override fun onBindViewHolder(
                                            holder: RecyclerView.ViewHolder,
                                            p1: Int
                                        ) {

                                            if (holder is imageHolder) {
                                                Picasso.get()
                                                    .load(File(messageModels[p1].file_local_path))
                                                    .fit()
                                                    .centerCrop()
                                                    .into(holder.imageView)
                                                //  holder.imageView.setImageBitmap(BitmapFactory.decodeFile(messageModels[p1].file_local_path))

                                                holder.imageView.setOnClickListener {
                                                    startActivity(
                                                        Intent(
                                                            this@UserProfileActivity,
                                                            ImagePreviewActivity::class.java
                                                        )
                                                            .putExtra(
                                                                utils.constants.KEY_LOCAL_PATH,
                                                                messageModels[p1].file_local_path
                                                            )
                                                    )
                                                }
                                            } else if (holder is videoHolder) {

                                                utils.loadVideoThumbnailFromLocalAsync(
                                                    this@UserProfileActivity,
                                                    holder.imageView,
                                                    messageModels[p1].file_local_path
                                                )
                                                holder.length.text = utils.getVideoLength(
                                                    this@UserProfileActivity,
                                                    messageModels[p1].file_local_path
                                                )

                                                holder.imageView.setOnClickListener {
                                                    utils.startVideoIntent(
                                                        this@UserProfileActivity,
                                                        messageModels[p1].file_local_path
                                                    )
                                                }
                                            }
                                        }

                                    }

                            }
                        }

                    })

            }

        }

        phone_textview.setOnClickListener {
            if (isPhoneLoaded && phone_textview.text.isNotEmpty())
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("tel:${phone_textview.text}")))
        }


        block_user.setOnClickListener {

            if (isGroup) {

                alert {
                    message =
                        "Exit from this group? You will no longer be a part of this conversation."
                    positiveButton("Yes, Go on!") {

                        FirebaseUtils.ref.groupMember(targetUID, myUID)
                            .child("removed").setValue(true).addOnSuccessListener {
                                this.ctx.toast("Group left")
                                groupMembers.forEach {
                                    // only to notify others
                                    FirebaseUtils.removeMember(
                                        it.uid, targetUID,
                                        FirebaseUtils.getPhoneNumber(), name, false
                                    )
                                }

                                // notify myself
                                FirebaseUtils.removeMember(
                                    FirebaseUtils.getUid(),
                                    targetUID, FirebaseUtils.getPhoneNumber(),
                                    name, false
                                )


                                if (!groupMembers.any { it.admin }) {
                                    if (groupMembers.isNotEmpty()) {
                                        FirebaseUtils.ref.groupMember(
                                            targetUID,
                                            groupMembers[0].uid
                                        )
                                            .child("admin")
                                            .setValue(true)
                                    }
                                }

                                finish()
                            }


                    }
                    negativeButton("No, Don't") {

                    }
                }.show()

                return@setOnClickListener
            }

            AlertDialog.Builder(this@UserProfileActivity)
                .setMessage("${if (isBlockedByMe) "Unblock" else "Block"} this user")
                .setPositiveButton("Yes") { _, _ ->
                    FirebaseUtils.ref.blockedUser(myUID, targetUID)
                        .setValue(!isBlockedByMe)
                }
                .setNegativeButton("No", null)
                .show()
        }

        if (isGroup) {
            checkIfMeAdmin()
            block_user.text = "Exit from group"
            block_user.setCompoundDrawablesWithIntrinsicBounds(
                ContextCompat.getDrawable(this, R.drawable.ic_logout_red)
                , null, null, null
            )
        } else if (isChannel) {
            invite_link.visibility = View.GONE
            profile_heading.visibility = View.GONE

            checkIfMeAdmin()
            checkChannelPrivacy()
            block_user.text = "Exit from channel"
            block_user.setCompoundDrawablesWithIntrinsicBounds(
                ContextCompat.getDrawable(this, R.drawable.ic_logout_red)
                , null, null, null
            )
        } else {
            checkIfBlocked()
        }


        //set notification switch enable/disable
        notification_switch.setOnCheckedChangeListener { _, isChecked ->
            FirebaseUtils.ref.notificationMute(targetUID)
                .setValue(isChecked)
        }

        //set switch initial value
        FirebaseUtils.ref.notificationMute(targetUID)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    if (!p0.exists()) {
                        notification_switch.isChecked = false
                        return
                    }
                    notification_switch.isChecked = p0.getValue(Boolean::class.java)!!
                }
            })
    }


    override fun onDestroy() {

        asyncLoader?.cancel(true)

        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        if (isGroup)
            menuInflater.inflate(R.menu.edit_profile_menu, menu)
        else if (isChannel && amIAdmin)
            menuInflater.inflate(R.menu.edit_profile_menu, menu)
        else if (phone_textview.text.toString() == supportActionBar?.title) {
            menuInflater.inflate(R.menu.user_profile_menu, menu)
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item!!.itemId) {
            android.R.id.home -> finish()
            R.id.action_contact -> {
                val contactIntent = Intent(Intent.ACTION_INSERT)
                contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, phone_textview.text)
                contactIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
                startActivityForResult(contactIntent, 111)
            }

            R.id.action_edit -> {
                if (isGroup) {

                    if (!groupMembers.any { it.uid == myUID }) {
                        toast("You are no longer a part of this group")
                        return false
                    }

                    selector(
                        "Edit Group",
                        listOf("Edit name", "Change Group picture", "Remove picture")
                    ) { _, i ->
                        when (i) {
                            0 -> {
                                //show group name edit dialog
                                showGroupNameEditDialog()
                            }

                            1 -> {
                                //show group profile change
                                CropImage.activity()
                                    .setGuidelines(CropImageView.Guidelines.ON)
                                    .setCropShape(CropImageView.CropShape.RECTANGLE)
                                    .setAspectRatio(1, 1)
                                    .start(this)
                            }

                            2 -> {
                                alert {
                                    message = "Remove profile picture?"
                                    yesButton { updateGroupProfileUrl(targetUID, "") }
                                    noButton { }
                                }.show()
                            }
                        }
                    }

                } else if (isChannel && amIAdmin) {

                    if (!channelMembers.any { it.uid == myUID } || !amIAdmin) {
                        toast("You are not authorized to do this")
                        return false
                    }

                    selector(
                        "Edit Channel",
                        listOf("Edit name", "Change Channel picture", "Remove picture")
                    ) { _, i ->
                        when (i) {
                            0 -> {
                                //show channel name edit dialog
                                showChannelNameEditDialog()
                            }

                            1 -> {
                                //show CHANNEL profile change
                                CropImage.activity()
                                    .setGuidelines(CropImageView.Guidelines.ON)
                                    .setCropShape(CropImageView.CropShape.RECTANGLE)
                                    .setAspectRatio(1, 1)
                                    .start(this)
                            }

                            2 -> {
                                alert {
                                    message = "Remove profile picture?"
                                    yesButton { updateChannelProfileUrl(targetUID, "") }
                                    noButton { }
                                }.show()
                            }
                        }
                    }

                }


            }
        }

        return super.onOptionsItemSelected(item)

    }

    private fun checkIfBlocked() {
        //check if i have blocked
        FirebaseUtils.ref.blockedUser(myUID, targetUID)
            .addValueEventListener(object : ValueEventListener {
                @SuppressLint("SetTextI18n")
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    isBlockedByMe = if (dataSnapshot.exists())
                        dataSnapshot.getValue(Boolean::class.java)!!
                    else
                        false

                    block_user.text = "${if (isBlockedByMe) "Unblock" else "Block"} this user"

                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })
    }

    private fun checkIfMeAdmin() {
        if (isGroup) {
            FirebaseUtils.ref.groupMember(targetUID, FirebaseUtils.getUid())
                .child("admin").addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        amIAdmin = false
                        context.toast("You are not an Admin of this group")
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        if (p0.exists()) {
                            try {
                                amIAdmin = p0.value as Boolean
                            } catch (e: Exception) {
                            }

                        } else {
                            amIAdmin = false

                        }
                    }

                })

        } else if (isChannel) {
            FirebaseUtils.ref.channelMember(targetUID, FirebaseUtils.getUid())
                .child("admin").addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        amIAdmin = false
                        invite_link.visibility = View.GONE
                        context.toast("You are not an Admin of this group")
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        if (p0.exists()) {
                            try {
                                amIAdmin = p0.value as Boolean

                            } catch (e: Exception) {
                            }

                        } else {
                            amIAdmin = false
                            invite_link.visibility = View.GONE
                        }
                    }

                })

        }
    }

    private fun checkChannelPrivacy() {

        FirebaseUtils.ref.channelInfo(targetUID)
            .child("channel_privacy").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    channel_is_Public = false
                    invite_link.visibility = View.GONE
                    profile_heading.visibility = View.GONE
                    group_member_recycler_view.visibility = View.GONE
                }

                @SuppressLint("DefaultLocale")
                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()) {
                        try {
                            channel_is_Public = (p0.value.toString().toLowerCase()) == "public"

                            if (channel_is_Public) {
                                profile_heading.visibility = View.VISIBLE
                                group_member_recycler_view.visibility = View.VISIBLE

                                invite_link.visibility = View.VISIBLE
                                invite_link.setOnClickListener {
                                    context.toast("Invite Link Clicked")
                                }
                            } else {
                                invite_link.visibility = View.GONE
                                if (amIAdmin){
                                    profile_heading.visibility = View.VISIBLE
                                    group_member_recycler_view.visibility = View.VISIBLE
                                }else{
                                    profile_heading.visibility = View.GONE
                                    group_member_recycler_view.visibility = View.GONE
                                }
                            }
                        } catch (e: Exception) {
                        }

                    } else {
                        channel_is_Public = false
                        invite_link.visibility = View.GONE
                        profile_heading.visibility = View.GONE
                        group_member_recycler_view.visibility = View.GONE
                    }
                }

            })
    }


    var groupMembers: MutableList<Models.GroupMember> = ArrayList()
    private fun loadGroupMembers() {
        if (!isGroup)
            return

        profile_heading.text = "Group Participants"


        //load created by
        FirebaseUtils.ref.groupInfo(targetUID)
//            .child("createdBy")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(p0: DataSnapshot) {
                    if (!p0.exists())
                        return

                    val group = p0.getValue(Models.Group::class.java)

                    val uid = group?.createdBy

                    FirebaseUtils.ref.user(uid!!)
                        .child("phone")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onCancelled(p0: DatabaseError) {}
                            override fun onDataChange(p0: DataSnapshot) {
                                val phone = p0.getValue(String::class.java)
                                val subtitle = "Created by ${utils.getNameFromNumber(context,phone!!)}" +
                                        " on ${utils.getHeaderFormattedDate(group.createdOn)}"

                                supportActionBar?.subtitle = subtitle
                                toolbar_subtitle_textView.text = subtitle
                            }
                        })

                }
            })


        FirebaseUtils.ref.groupMembers(targetUID)
            .orderByChild("addedOn")
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(p0: DataSnapshot) {

                    groupMembers.clear()

                    for (post in p0.children) {
                        val member = post.getValue(Models.GroupMember::class.java)!!
                        if (!member.removed)
                            groupMembers.add(member)

                    }
                    setGroupMemberAdapter(groupMembers)
                }
            })
    }

    var channelMembers: MutableList<Models.ChannelMember> = ArrayList()
    private fun loadChannelMembers() {
        if (!isChannel)
            return

        profile_heading.text = "Channel Participants"


        //load created by
        FirebaseUtils.ref.channelInfo(targetUID)
            .child("createdBy")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(p0: DataSnapshot) {
                    if (!p0.exists())
                        return

                    val channel = p0.getValue(Models.Channel::class.java)

                    val uid = channel?.createdBy

                    FirebaseUtils.ref.user(uid!!)
                        .child("phone")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onCancelled(p0: DatabaseError) {}

                            override fun onDataChange(p0: DataSnapshot) {
                                val phone = p0.getValue(String::class.java)
                                val subtitle = "Created by ${
                                    utils.getNameFromNumber(
                                    this@UserProfileActivity,
                                    phone!!
                                )}" +
                                        " on ${utils.getHeaderFormattedDate(channel.createdOn)}"

                                Log.d("UserProfileActivity", "onDataChange: $subtitle")
                                supportActionBar?.subtitle = subtitle
                                toolbar_subtitle_textView.text = subtitle
                            }
                        })

                }
            })


        FirebaseUtils.ref.channelMembers(targetUID)
            .orderByChild("addedOn")
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(p0: DataSnapshot) {

                    channelMembers.clear()

                    for (post in p0.children) {
                        val member = post.getValue(Models.ChannelMember::class.java)!!
                        if (!member.removed)
                            channelMembers.add(member)

                    }
                    setChannelMemberAdapter(channelMembers)
                }
            })
    }


    private fun setGroupMemberAdapter(groupMembers: MutableList<Models.GroupMember>) {

        val excludedUIDs: MutableList<String> = ArrayList()
        val isAdmin = groupMembers.any { it.uid == FirebaseUtils.getUid() && it.admin }

        // keep track of latest value just in case its changed and user is engaged with the screen
        FirebaseUtils.ref.groupInfo(targetUID)
            .child(utils.constants.KEY_NAME)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    name = p0.value.toString()
                    Log.d("UserProfileActivity", "onDataChange: value has changed name = $name")
                    title = name
                }
            })


        if (!groupMembers.any { it.uid == myUID }) {
            group_member_recycler_view.visibility = View.GONE
            block_user.visibility = View.GONE
            return
        }

        groupMembers.forEach { excludedUIDs.add(it.uid) }

        if (isAdmin)
            add_group_member_btn.visibility = View.VISIBLE

        add_group_member_btn.setOnClickListener {
            startActivityForResult(Intent(this, MultiContactChooserActivity::class.java)
                .apply {
                    putStringArrayListExtra(
                        utils.constants.KEY_EXCLUDED_LIST,
                        excludedUIDs as ArrayList<String>
                    )
                }, 101
            )
        }

        class memberHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var name = itemView.name!!
            var profilePic = itemView.pic!!
            var admin = itemView.admin_textview!!

        }

        group_member_recycler_view.adapter = object : RecyclerView.Adapter<memberHolder>() {
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): memberHolder {
                return memberHolder(
                    layoutInflater.inflate(
                        R.layout.item_group_member_layout,
                        p0,
                        false
                    )
                )
            }

            override fun getItemCount(): Int = groupMembers.size

            override fun onBindViewHolder(p0: memberHolder, p1: Int) {

                FirebaseUtils.loadProfileThumbnail(
                    this@UserProfileActivity, groupMembers[p1].uid,
                    p0.profilePic
                )
                p0.name.text =
                    utils.getNameFromNumber(this@UserProfileActivity, groupMembers[p1].phoneNumber)

                p0.admin.visibility = if (groupMembers[p1].admin) View.VISIBLE else View.GONE

                val groupMember = groupMembers[p0.adapterPosition]

                p0.itemView.setOnClickListener {
                    Log.d("UserProfileActivity", "onBindViewHolder: uid = $groupMember")
                    if (groupMember.uid == myUID)
                        return@setOnClickListener


                    FirebaseUtils.showTargetOptionMenuFromProfile(
                        this@UserProfileActivity,
                        groupMember.uid,
                        targetUID,
                        groupMember.phoneNumber,
                        groupMember.admin,
                        isAdmin,
                        groupMembers,
                        name
                    )


                }
            }

        }

    }

    private fun setChannelMemberAdapter(channelMembers: MutableList<Models.ChannelMember>) {

        val excludedUIDs: MutableList<String> = ArrayList()
        val isAdmin = channelMembers.any { it.uid == FirebaseUtils.getUid() && it.admin }

        // keep track of latest value just in case its changed and user is engaged with the screen
        FirebaseUtils.ref.channelInfo(targetUID)
            .child(utils.constants.KEY_NAME)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    name = p0.value.toString()
                    Log.d("UserProfileActivity", "onDataChange: value has changed name = $name")
                    title = name
                }
            })


        if (!channelMembers.any { it.uid == myUID }) {
            group_member_recycler_view.visibility = View.GONE
            block_user.visibility = View.GONE
            return
        }

        channelMembers.forEach { excludedUIDs.add(it.uid) }

        if (isAdmin)
            add_group_member_btn.visibility = View.VISIBLE

        add_group_member_btn.setOnClickListener {
            startActivityForResult(Intent(this, MultiContactChooserActivity::class.java)
                .apply {
                    putStringArrayListExtra(
                        utils.constants.KEY_EXCLUDED_LIST,
                        excludedUIDs as ArrayList<String>
                    )
                }, 101
            )
        }

        class memberHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var name = itemView.name!!
            var profilePic = itemView.pic!!
            var admin = itemView.admin_textview!!

        }

        group_member_recycler_view.adapter = object : RecyclerView.Adapter<memberHolder>() {
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): memberHolder {
                return memberHolder(
                    layoutInflater.inflate(
                        R.layout.item_group_member_layout,
                        p0,
                        false
                    )
                )
            }

            override fun getItemCount(): Int = channelMembers.size

            override fun onBindViewHolder(p0: memberHolder, p1: Int) {

                FirebaseUtils.loadChannelPicThumbnail(
                    this@UserProfileActivity, channelMembers[p1].uid,
                    p0.profilePic
                )
                p0.name.text = utils.getNameFromNumber(
                    this@UserProfileActivity,
                    channelMembers[p1].phoneNumber
                )

                p0.admin.visibility = if (channelMembers[p1].admin) View.VISIBLE else View.GONE

                val channelMember = channelMembers[p0.adapterPosition]

                p0.itemView.setOnClickListener {
                    Log.d("UserProfileActivity", "onBindViewHolder: uid = $channelMember")
                    if (channelMember.uid == myUID)
                        return@setOnClickListener


                    FirebaseUtils.showTargetOptionMenuFromProfileForChannel(
                        this@UserProfileActivity,
                        channelMember.uid,
                        targetUID,
                        channelMember.phoneNumber,
                        channelMember.admin,
                        isAdmin,
                        channelMembers,
                        name
                    )


                }
            }

        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            utils.printIntentKeyValues(intent)
            //Now add members
            val selectedUsers = data?.getParcelableArrayListExtra<Models.Contact>(
                utils.constants.KEY_SELECTED
            )
                    as ArrayList<Models.Contact>?

            val progressDialog = ProgressDialog.show(
                this,
                "",
                "Please wait...",
                true,
                false
            )

            if (isChannel) {
                selectedUsers?.forEachWithIndex { index, it ->
                    val channelMember = Models.ChannelMember(
                        it.uid,
                        FirebaseUtils.getUid(), FirebaseUtils.getPhoneNumber(),
                        it.number, false, false, System.currentTimeMillis()
                    )

                    FirebaseUtils.ref.channelMember(targetUID, it.uid)
                        .setValue(channelMember)

                    // add create event in message node
                    FirebaseUtils.createdChannelEvent(it.uid, targetUID, it.number)

                    // add member event in message node
                    FirebaseUtils.addedChannelMemberEvent(it.uid, targetUID, it.number)

                    FirebaseUtils.ref.lastMessage(it.uid)
                        .child(targetUID)
                        .setValue(
                            Models.LastMessageDetail(
                                type = FirebaseUtils.KEY_CONVERSATION_CHANNEL,
                                nameOrNumber = name
                            )
                        )
                        .addOnSuccessListener {
                            if (index == selectedUsers.lastIndex) {
                                progressDialog.dismiss()
                                this.toast("New member added")
                            }
                        }

                    //add event to other members
                    channelMembers.forEach { member ->
                        // add member event in message node

                        if (member.uid != it.uid) {

                            FirebaseUtils.addedChannelMemberEvent(member.uid, targetUID, it.number)

                            FirebaseUtils.ref.lastMessage(member.uid)
                                .child(targetUID)
                                .setValue(
                                    Models.LastMessageDetail(
                                        type = FirebaseUtils.KEY_CONVERSATION_CHANNEL,
                                        nameOrNumber = name
                                    )
                                )
                        }

                    }

                }

            } else if (isGroup) {
                selectedUsers?.forEachWithIndex { index, it ->
                    val groupMember = Models.GroupMember(
                        it.uid,
                        FirebaseUtils.getUid(), FirebaseUtils.getPhoneNumber(),
                        it.number, false, false, System.currentTimeMillis()
                    )

                    FirebaseUtils.ref.groupMember(targetUID, it.uid)
                        .setValue(groupMember)

                    // add create event in message node
                    FirebaseUtils.createdGroupEvent(it.uid, targetUID, it.number)

                    // add member event in message node
                    FirebaseUtils.addedMemberEvent(it.uid, targetUID, it.number)

                    FirebaseUtils.ref.lastMessage(it.uid)
                        .child(targetUID)
                        .setValue(
                            Models.LastMessageDetail(
                                type = FirebaseUtils.KEY_CONVERSATION_GROUP,
                                nameOrNumber = name
                            )
                        )
                        .addOnSuccessListener {
                            if (index == selectedUsers.lastIndex) {
                                progressDialog.dismiss()
                                this.toast("New member added")
                            }
                        }

                    //add event to other members
                    groupMembers.forEach { member ->
                        // add member event in message node

                        if (member.uid != it.uid) {

                            FirebaseUtils.addedMemberEvent(member.uid, targetUID, it.number)

                            FirebaseUtils.ref.lastMessage(member.uid)
                                .child(targetUID)
                                .setValue(
                                    Models.LastMessageDetail(
                                        type = FirebaseUtils.KEY_CONVERSATION_GROUP,
                                        nameOrNumber = name
                                    )
                                )
                        }

                    }

                }
            }


        } else if (requestCode == 111 && resultCode == Activity.RESULT_OK) {
            supportActionBar?.title = utils.getNameFromNumber(this, name)
        } else if (resultCode == Activity.RESULT_OK &&
            requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE
        ) {

            utils.printIntentKeyValues(data!!)

            val result = CropImage.getActivityResult(data)
            val filePath = result.uri.path

            Luban.compress(this, File(filePath))
                .putGear(Luban.THIRD_GEAR)
                .launch(object : OnCompressListener {
                    override fun onStart() {
                    }

                    override fun onSuccess(file: File?) {
                        if (isGroup)
                            uploadGroupProfilePic(targetUID, file!!)
                        else if (isChannel)
                            uploadChannelProfilePic(targetUID, file!!)
                    }

                    override fun onError(e: Throwable?) {
                        if (isGroup)
                            uploadGroupProfilePic(targetUID, File(filePath))
                        else if (isChannel)
                            uploadChannelProfilePic(targetUID, File(filePath))
                    }

                })

        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    class imageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.iv_thumbnail_image

    }

    class videoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.iv_thumbnail_video
        val length = itemView.txt_duration

    }


    val context = this@UserProfileActivity


    //for uploading group profile pic
    private fun uploadGroupProfilePic(groupID: String, imageFile: File) {


        if (!isGroup)
            return

        val dialog = ProgressDialog(context)
        dialog.setMessage("Wait a moment...")
        dialog.setCancelable(false)
        dialog.show()

        val storageRef = FirebaseUtils.ref.profilePicStorageRef(groupID)

        val uploadTask = storageRef.putFile(utils.getUriFromFile(context, imageFile))

        Log.d("UserProfileActivity", "uploadGroupProfilePic: path = ${imageFile.path}")

        uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            Log.d("FirebaseUtils", "uploadedImage: size = " + task.result!!.bytesTransferred / 1024)
            return@Continuation storageRef.downloadUrl
        })
            .addOnCompleteListener { task ->
                dialog.dismiss()
                if (task.isSuccessful) {
                    val link = task.result
                    updateGroupProfileUrl(groupID, link.toString())
                } else
                    utils.toast(context, task.exception!!.message.toString())
            }
            .addOnSuccessListener {
                dialog.dismiss()

            }
            .addOnFailureListener {
                dialog.dismiss()
            }


    }

    //for uploading channel profile pic
    private fun uploadChannelProfilePic(channelID: String, imageFile: File) {


        if (!isChannel)
            return

        val dialog = ProgressDialog(context)
        dialog.setMessage("Wait a moment...")
        dialog.setCancelable(false)
        dialog.show()

        val storageRef = FirebaseUtils.ref.profilePicStorageRef(channelID)

        val uploadTask = storageRef.putFile(utils.getUriFromFile(context, imageFile))

        Log.d("UserProfileActivity", "uploadChannelProfilePic: path = ${imageFile.path}")

        uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            Log.d("FirebaseUtils", "uploadedImage: size = " + task.result!!.bytesTransferred / 1024)
            return@Continuation storageRef.downloadUrl
        })
            .addOnCompleteListener { task ->
                dialog.dismiss()
                if (task.isSuccessful) {
                    val link = task.result
                    updateChannelProfileUrl(channelID, link.toString())
                } else
                    utils.toast(context, task.exception!!.message.toString())
            }
            .addOnSuccessListener {
                dialog.dismiss()

            }
            .addOnFailureListener {
                dialog.dismiss()
            }


    }


    private fun updateGroupProfileUrl(groupID: String, url: String) {
        FirebaseUtils.ref.groupInfo(groupID)
            .child(FirebaseUtils.KEY_PROFILE_PIC_URL)
            .setValue(url)
            .addOnSuccessListener {
                if (url.isNotEmpty()) toast("Profile pic updated")
                else toast("Picture removed")
            }
    }

    private fun updateChannelProfileUrl(channelID: String, url: String) {
        FirebaseUtils.ref.channelInfo(channelID)
            .child(FirebaseUtils.KEY_PROFILE_PIC_URL)
            .setValue(url)
            .addOnSuccessListener {
                if (url.isNotEmpty()) toast("Profile pic updated")
                else toast("Picture removed")
            }
    }


    private fun showGroupNameEditDialog() {

        LovelyTextInputDialog(this)
            .setTopColorRes(R.color.colorAccent)
            .setTopTitleColor(Color.WHITE)
            .setTopTitle("New Group name")
            .setTitle("Edit the group name")
            .setInitialInput(name)
            .setInputFilter("Invalid Group name") {
                return@setInputFilter it.isNotBlank() && it.length > 3
            }
            .setConfirmButton("Confirm") {

                val newName = it

                FirebaseUtils.ref.groupInfo(targetUID)
                    .child(FirebaseUtils.KEY_NAME)
                    .setValue(newName)
                    .addOnSuccessListener {

                        groupMembers.forEach { member ->
                            FirebaseUtils.ref.lastMessage(member.uid)
                                .child(targetUID).child(FirebaseUtils.KEY_NAME_OR_NUMBER)
                                .setValue(newName)
                        }

                        startActivity(Intent(context, HomeActivity::class.java)
                            .apply {
                                flags =
                                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            })
                        finish()
                        toast("Group name has been changed")
                    }


            }

            .setNegativeButton("No") {}
            .show()

    }

    private fun showChannelNameEditDialog() {

        LovelyTextInputDialog(this)
            .setTopColorRes(R.color.colorAccent)
            .setTopTitleColor(Color.WHITE)
            .setTopTitle("New Channel name")
            .setTitle("Edit the channel name")
            .setInitialInput(name)
            .setInputFilter("Invalid Channel name") {
                return@setInputFilter it.isNotBlank() && it.length > 2
            }
            .setConfirmButton("Confirm") {

                val newName = it

                FirebaseUtils.ref.channelInfo(targetUID)
                    .child(FirebaseUtils.KEY_NAME)
                    .setValue(newName)
                    .addOnSuccessListener {

                        channelMembers.forEach { member ->
                            FirebaseUtils.ref.lastMessage(member.uid)
                                .child(targetUID).child(FirebaseUtils.KEY_NAME_OR_NUMBER)
                                .setValue(newName)
                        }

                        startActivity(Intent(context, HomeActivity::class.java)
                            .apply {
                                flags =
                                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            })
                        finish()
                        toast("Channel name has been changed")
                    }


            }

            .setNegativeButton("No") {}
            .show()

    }


}
