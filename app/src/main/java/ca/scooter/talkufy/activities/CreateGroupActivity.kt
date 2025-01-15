package ca.scooter.talkufy.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ca.scooter.talkufy.R
import ca.scooter.talkufy.databinding.ActivityCreateGroupBinding
import ca.scooter.talkufy.databinding.ItemGridContactLayoutBinding
import ca.scooter.talkufy.models.Models
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.UploadTask
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import ca.scooter.talkufy.utils.utils.toast
import com.canhub.cropper.CropImage
import com.canhub.cropper.CropImage.ActivityResult
import me.shaohui.advancedluban.Luban
import me.shaohui.advancedluban.OnCompressListener
import java.io.File
import com.yarolegovich.lovelydialog.LovelyProgressDialog

class CreateGroupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateGroupBinding
    var participantList:MutableList<Models.Contact> = ArrayList()
    var isProfileChanged = false
    lateinit var bitmap: Bitmap
    var profileURL = ""
    lateinit var imageFile:File
    val context = this@CreateGroupActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Create a new Group"

        binding.profileCircleimageview.setImageResource(R.drawable.ic_group_white_24dp)
        binding.profileCircleimageview.circleBackgroundColor = ContextCompat.getColor(this, R.color.colorPrimary)

        binding.addParticipantBtn.setOnClickListener {
            val excludedUIDs:MutableList<String> = ArrayList()
            participantList.forEach { excludedUIDs.add(it.uid) }
            startActivityForResult(Intent(this, MultiContactChooserActivity::class.java).apply {
                putStringArrayListExtra(utils.constants.KEY_EXCLUDED_LIST, excludedUIDs as java.util.ArrayList<String>?)
            }, 101)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.profilePickBtn.setOnClickListener {
            CropImage.Builder()
                .setCropShape(CropImage.CropShape.RECTANGLE)
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
                p0.binding.gridName.text = utils.getNameFromNumber(this@CreateGroupActivity,
                    selectedUsers?.get(p1)?.number ?: "")
                FirebaseUtils.loadProfileThumbnail(this@CreateGroupActivity, selectedUsers?.get(p1)?.uid ?: "", p0.binding.gridPic)
                p0.binding.gridCancelBtn.setOnClickListener {
                    selectedUsers?.removeAt(p0.adapterPosition)
                    notifyItemRemoved(p0.adapterPosition)
                }
            }
        }

        binding.participantRecyclerview.adapter = horizontalAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && requestCode == CropImage.RESULT_CROP_IMAGE) {
            val result: CropImage.ActivityResult = CropImage.ActivityResult(data)
            val filePath = result.uri.path
            Log.d("CreateGroup", "onActivityResult: path = $filePath")
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
            Log.d("CreateGroupActivity", "onActivityResult: $participantList")
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
            if (binding.groupNameEdittext.text.isEmpty()) {
                binding.groupNameEdittext.error = "Group name cannot be empty"
                return false
            }
            if (binding.groupNameEdittext.text.length <= 2) {
                binding.groupNameEdittext.error = "Too short for a group name"
                return false
            }
            val groupID = "GRP${System.currentTimeMillis()}"
            if (isProfileChanged)
                uploadGroupProfilePicAndCreateGroup(groupID)
            else
                createGroup(groupID)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun createGroup(groupID: String) {
        val groupName = binding.groupNameEdittext.text.toString().trim()
        val groupInfo = Models.Group(groupName, createdBy = FirebaseUtils.getUid(), groupID = groupID)

        FirebaseUtils.ref.groupInfo(groupID)
            .setValue(groupInfo)
            .addOnSuccessListener {
                context.toast("Group created successfully")

                //Now add members
                participantList.forEach {
                    val groupMember = Models.GroupMember(it.uid, FirebaseUtils.getUid(), FirebaseUtils.getPhoneNumber(), it.number, false, false, System.currentTimeMillis())
                    FirebaseUtils.ref.groupMember(groupID, it.uid).setValue(groupMember)
                    FirebaseUtils.createdGroupEvent(it.uid, groupID, it.number)
                    FirebaseUtils.addedMemberEvent(it.uid, groupID, it.number)
                    FirebaseUtils.ref.lastMessage(it.uid).child(groupID).setValue(Models.LastMessageDetail(type = FirebaseUtils.KEY_CONVERSATION_GROUP, nameOrNumber = groupName))
                }
                val groupMember = Models.GroupMember(FirebaseUtils.getUid(), FirebaseUtils.getUid(), FirebaseUtils.getPhoneNumber(), FirebaseUtils.getPhoneNumber(), true, false, System.currentTimeMillis())
                FirebaseUtils.ref.groupMember(groupID, FirebaseUtils.getUid()).setValue(groupMember)
                FirebaseUtils.createdGroupEvent(FirebaseUtils.getUid(), groupID, FirebaseUtils.getPhoneNumber())
                participantList.forEach {
                    FirebaseUtils.addedMemberEvent(FirebaseUtils.getUid(), groupID, it.number)
                }
                FirebaseUtils.ref.lastMessage(FirebaseUtils.getUid()).child(groupID).setValue(Models.LastMessageDetail(type = FirebaseUtils.KEY_CONVERSATION_GROUP, nameOrNumber = groupName)).addOnSuccessListener {
                    if (profileURL.isEmpty())
                        finish()
                    else
                        updateProfileUrl(groupID, profileURL)
                }
            }
    }

    private fun uploadGroupProfilePicAndCreateGroup(groupID: String) {
        val dialog = LovelyProgressDialog(context)
            .setTitle("Please wait a moment...")
            .setCancelable(false)
        dialog.show()

        val storageRef = FirebaseUtils.ref.profilePicStorageRef(groupID)
        val uploadTask = storageRef.putFile(utils.getUriFromFile(context, imageFile))
        Log.d("CreateGroupActivity", "uploadGroupProfilePicAndCreateGroup: path = ${imageFile.path}")

        uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {
                task.exception?.let { throw it }
            }
            Log.d("FirebaseUtils", "uploadedImage: size = " + task.result!!.bytesTransferred / 1024)
            return@Continuation storageRef.downloadUrl
        }).addOnCompleteListener { task ->
            dialog.dismiss()
            if (task.isSuccessful) {
                val link = task.result
                profileURL = link?.toString()!!
                Log.d("CreateGroupActivity", "uploadGroupProfilePicAndCreateGroup: profile updated ")
                createGroup(groupID)
            } else
                utils.toast(context, task.exception!!.message.toString())
        }.addOnSuccessListener {
            dialog.dismiss()
        }.addOnFailureListener {
            dialog.dismiss()
        }
    }

    private fun updateProfileUrl(groupID: String, url: String) {
        FirebaseUtils.ref.groupInfo(groupID)
            .child(FirebaseUtils.KEY_PROFILE_PIC_URL)
            .setValue(url)
            .addOnSuccessListener {
                finish()
            }
    }
}