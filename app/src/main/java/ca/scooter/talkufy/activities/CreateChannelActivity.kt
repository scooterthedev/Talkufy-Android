package ca.scooter.talkufy.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ca.scooter.talkufy.R
import ca.scooter.talkufy.databinding.ActivityCreateChannelBinding
import ca.scooter.talkufy.databinding.ItemGridContactLayoutBinding
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import ca.scooter.talkufy.utils.utils.toast
import com.canhub.cropper.CropImage
import com.canhub.cropper.CropImageView
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.UploadTask
import me.shaohui.advancedluban.Luban
import me.shaohui.advancedluban.OnCompressListener
import java.io.File

class CreateChannelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateChannelBinding
    var participantList: MutableList<Models.Contact> = ArrayList()
    var isProfileChanged = false
    lateinit var bitmap: Bitmap
    var profileURL = ""
    lateinit var imageFile: File
    val context = this@CreateChannelActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateChannelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Create a new Channel"

        binding.profileCircleimageview.setImageResource(R.drawable.ic_group_white_24dp)
        binding.profileCircleimageview.circleBackgroundColor = ContextCompat.getColor(this, R.color.colorPrimary)

        binding.addParticipantBtn.setOnClickListener {
            val excludedUIDs: MutableList<String> = ArrayList()
            participantList.forEach { excludedUIDs.add(it.uid) }
            startActivityForResult(Intent(this, MultiContactChooserActivity::class.java).apply {
                putStringArrayListExtra(utils.constants.KEY_EXCLUDED_LIST, excludedUIDs as java.util.ArrayList<String>?)
            }, 101)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.profilePickBtn.setOnClickListener {
            CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .setAspectRatio(1, 1)
                .start(this)
        }
    }

    private fun setGridAdapter(selectedUsers: ArrayList<Models.Contact>?) {
        binding.participantRecyclerview.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 4)
        binding.participantRecyclerview.setHasFixedSize(true)

        val horizontalAdapter = object : androidx.recyclerview.widget.RecyclerView.Adapter<ParticipantHolder>() {
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ParticipantHolder {
                val itemBinding = ItemGridContactLayoutBinding.inflate(layoutInflater, p0, false)
                return ParticipantHolder(itemBinding)
            }

            override fun getItemCount(): Int = selectedUsers!!.size

            override fun onBindViewHolder(p0: ParticipantHolder, p1: Int) {
                p0.binding.gridName.text = utils.getNameFromNumber(this@CreateChannelActivity, selectedUsers?.get(p1).number)

                FirebaseUtils.loadProfileThumbnail(this@CreateChannelActivity, selectedUsers?.get(p1).uid, p0.binding.gridPic)

                p0.binding.gridCancelBtn.setOnClickListener {
                    selectedUsers.removeAt(p0.adapterPosition)
                    notifyItemRemoved(p0.adapterPosition)
                }
            }
        }

        binding.participantRecyclerview.adapter = horizontalAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            val filePath = result.uri.path

            Log.d("CreateChannel", "onActivityResult: path = $filePath")
            imageFile = File(filePath)

            Luban.compress(this, File(filePath))
                .putGear(Luban.THIRD_GEAR)
                .launch(object : OnCompressListener {
                    override fun onStart() {}

                    override fun onSuccess(file: File?) {
                        imageFile = file!!
                        bitmap = BitmapFactory.decodeFile(file.path)
                        binding.profileCircleimageview.setImageBitmap(bitmap)
                        isProfileChanged = true
                    }

                    override fun onError(e: Throwable?) {
                        bitmap = BitmapFactory.decodeFile(filePath)
                        binding.profileCircleimageview.setImageBitmap(bitmap)
                        isProfileChanged = true
                    }
                })
        } else if (resultCode == Activity.RESULT_OK) {
            val selectedUsers = data?.getParcelableArrayListExtra<Models.Contact>(utils.constants.KEY_SELECTED)
                as java.util.ArrayList<Models.Contact>

            if (participantList.isEmpty()) {
                participantList = selectedUsers
            } else {
                participantList.addAll(selectedUsers)
            }

            Log.d("CreateChannelActivity", "onActivityResult: $participantList")
            setGridAdapter(participantList as ArrayList<Models.Contact>)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    class ParticipantHolder(val binding: ItemGridContactLayoutBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tick, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            if (binding.channelNameEdittext.text.isEmpty()) {
                binding.channelNameEdittext.error = "Channel name cannot be empty"
                return false
            }

            if (binding.channelNameEdittext.text.length <= 2) {
                binding.channelNameEdittext.error = "Too short for a Channel name"
                return false
            }

            val channelID = "CHN${System.currentTimeMillis()}"
            if (isProfileChanged)
                uploadChannelProfilePicAndCreateChannel(channelID)
            else
                createChannel(channelID)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun createChannel(channelID: String) {
        val channelName = binding.channelNameEdittext.text.toString().trim()
        val channelInfo = Models.Channel(
            channelName,
            createdBy = FirebaseUtils.getUid(),
            channelID = channelID,
            channel_privacy = "public",
            channel_url = channelName
        )

        FirebaseUtils.ref.channelInfo(channelID)
            .setValue(channelInfo)
            .addOnSuccessListener {
                context.toast("Channel created successfully")

                participantList.forEach {
                    val channelMember = Models.ChannelMember(
                        it.uid,
                        FirebaseUtils.getUid(),
                        FirebaseUtils.getPhoneNumber(),
                        it.number,
                        false,
                        false,
                        System.currentTimeMillis(),
                        admin_power = 0
                    )

                    FirebaseUtils.ref.channelMember(channelID, it.uid)
                        .setValue(channelMember)

                    FirebaseUtils.createdChannelEvent(it.uid, channelID, it.number)
                    FirebaseUtils.addedChannelMemberEvent(it.uid, channelID, it.number)

                    FirebaseUtils.ref.lastMessage(it.uid)
                        .child(channelID)
                        .setValue(
                            Models.LastMessageDetail(
                                type = FirebaseUtils.KEY_CONVERSATION_CHANNEL,
                                nameOrNumber = channelName
                            )
                        )
                }

                val channelMember = Models.ChannelMember(
                    FirebaseUtils.getUid(),
                    FirebaseUtils.getUid(),
                    FirebaseUtils.getPhoneNumber(),
                    FirebaseUtils.getPhoneNumber(),
                    true,
                    false,
                    System.currentTimeMillis(),
                    admin_power = 5
                )

                FirebaseUtils.ref.channelMember(channelID, FirebaseUtils.getUid())
                    .setValue(channelMember)

                FirebaseUtils.createdChannelEvent(FirebaseUtils.getUid(), channelID, FirebaseUtils.getPhoneNumber())

                participantList.forEach {
                    FirebaseUtils.addedChannelMemberEvent(FirebaseUtils.getUid(), channelID, it.number)
                }

                FirebaseUtils.ref.lastMessage(FirebaseUtils.getUid())
                    .child(channelID)
                    .setValue(
                        Models.LastMessageDetail(
                            type = FirebaseUtils.KEY_CONVERSATION_CHANNEL,
                            nameOrNumber = channelName
                        )
                    )
                    .addOnSuccessListener {
                        if (profileURL.isEmpty())
                            finish()
                        else
                            updateProfileUrl(channelID, profileURL)
                    }
            }
    }

    private fun uploadChannelProfilePicAndCreateChannel(channelID: String) {
        val dialog = ProgressDialog(context)
        dialog.setMessage("Please wait a moment...")
        dialog.setCancelable(false)
        dialog.show()

        val storageRef = FirebaseUtils.ref.profilePicStorageRef(channelID)
        val uploadTask = storageRef.putFile(utils.getUriFromFile(context, imageFile))

        Log.d("CreateChannelActivity", "uploadChannelProfilePicAndCreateChannel: path = ${imageFile.path}")

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
                    profileURL = link?.toString()!!
                    Log.d("CreateChannelActivity", "uploadChannelProfilePicAndCreateChannel: profile updated ")
                    createChannel(channelID)
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

    private fun updateProfileUrl(channelID: String, url: String) {
        FirebaseUtils.ref.channelInfo(channelID)
            .child(FirebaseUtils.KEY_PROFILE_PIC_URL)
            .setValue(url)
            .addOnSuccessListener {
                finish()
            }
    }
}