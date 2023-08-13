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
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.UploadTask
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.activity_create_group.*
import kotlinx.android.synthetic.main.item_grid_contact_layout.view.*
import kotlinx.android.synthetic.main.layout_profile_image_picker.*
import me.shaohui.advancedluban.Luban
import me.shaohui.advancedluban.OnCompressListener
import org.jetbrains.anko.toast
import java.io.File

class CreateGroupActivity : AppCompatActivity() {

    var participantList:MutableList<Models.Contact> = ArrayList()

    var isProfileChanged = false
    lateinit var bitmap: Bitmap
    var profileURL = ""
    lateinit var imageFile:File
    val context = this@CreateGroupActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        title = "Create a new Group"

        profile_circleimageview.setImageResource(R.drawable.ic_group_white_24dp)
        profile_circleimageview.circleBackgroundColor = ContextCompat.getColor(this,
            R.color.colorPrimary
        )

        add_participant_btn.setOnClickListener {

            val excludedUIDs:MutableList<String> = ArrayList()
             participantList.forEach { excludedUIDs.add(it.uid) }
                startActivityForResult(Intent(this, MultiContactChooserActivity::class.java).apply {
                putStringArrayListExtra(utils.constants.KEY_EXCLUDED_LIST, excludedUIDs as java.util.ArrayList<String>?)
            },101)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        profile_pick_btn.setOnClickListener {

            CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .setAspectRatio(1,1)
                .start(this)
//            ImagePicker.pickImage(this, 123)

        }


    }


    private fun setGridAdapter(selectedUsers:ArrayList<Models.Contact>?) {

        participant_recyclerview.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 4)
        participant_recyclerview.setHasFixedSize(true)

        val horizontalAdapter = object : androidx.recyclerview.widget.RecyclerView.Adapter<ParticipantHolder>() {
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ParticipantHolder {
                return ParticipantHolder(
                    layoutInflater.inflate(
                        R.layout.item_grid_contact_layout,
                        p0,
                        false
                    )
                )
            }

            override fun getItemCount(): Int = selectedUsers!!.size

            override fun onBindViewHolder(p0: ParticipantHolder, p1: Int) {


                p0.name.text = utils.getNameFromNumber(
                    this@CreateGroupActivity,
                    selectedUsers?.get(p1)!!.number
                )

                FirebaseUtils.loadProfileThumbnail(
                    this@CreateGroupActivity, selectedUsers[p1].uid,
                    p0.pic
                )

                p0.cancelBtn.setOnClickListener {
                    selectedUsers.removeAt(p0.adapterPosition)
                    notifyItemRemoved(p0.adapterPosition)
                }
            }

        }

        participant_recyclerview.adapter = horizontalAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(resultCode == Activity.RESULT_OK && requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){

            utils.printIntentKeyValues(data!!)

            val result = CropImage.getActivityResult(data)
            val filePath = result.uri.path

            Log.d("CreateGroup", "onActivityResult: path = $filePath")
            imageFile = File(filePath)

            Luban.compress(this, File(filePath))
                .putGear(Luban.THIRD_GEAR)
                .launch(object : OnCompressListener {
                    override fun onStart() {
                    }

                    override fun onSuccess(file: File?) {

                        imageFile = file!!
                        bitmap = BitmapFactory.decodeFile(file.path)
                        profile_circleimageview.setImageBitmap(bitmap)
                        isProfileChanged = true

                    }

                    override fun onError(e: Throwable?) {
                        bitmap = BitmapFactory.decodeFile(filePath)
                        profile_circleimageview.setImageBitmap(bitmap)
                        isProfileChanged = true

                    }

                })

        }
        else if(resultCode == Activity.RESULT_OK){
            // for receiving participant list
            val selectedUsers = data?.getParcelableArrayListExtra<Models.Contact>(
                utils.constants.KEY_SELECTED)
                    as java.util.ArrayList<Models.Contact>

            if(participantList.isEmpty()){
                participantList = selectedUsers
            }
            else{
                participantList.addAll(selectedUsers)
            }

            Log.d("CreateGroupActivity", "onActivityResult: $participantList")


            setGridAdapter(participantList as ArrayList<Models.Contact>)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    class ParticipantHolder(itemView: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){
        val name = itemView.grid_name!!
        val pic = itemView.grid_pic!!
        val cancelBtn = itemView.grid_cancel_btn!!
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tick, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item!!.itemId == android.R.id.home){
            finish()
        }
        else{
            //create group

            if(group_name_edittext.text.isEmpty()){
                group_name_edittext.error = "Group name cannot be empty"
                return false
            }

            if(group_name_edittext.text.length <=2){
                group_name_edittext.error = "Too short for a group name"
                return false
            }


            val groupID = "GRP${System.currentTimeMillis()}"
            if(isProfileChanged)
                uploadGroupProfilePicAndCreateGroup(groupID)
            else
                createGroup(groupID)
        }


        return super.onOptionsItemSelected(item)
    }




    private fun createGroup(groupID: String){


        val groupName = group_name_edittext.text.toString().trim()

        val groupInfo = Models.Group(groupName,
            createdBy = FirebaseUtils.getUid(),
            groupID = groupID)




        FirebaseUtils.ref.groupInfo(groupID)
            .setValue(groupInfo)
            .addOnSuccessListener {
                context.toast("Group created successfully")

                //Now add members
                participantList.forEach {
                    val groupMember = Models.GroupMember(it.uid,
                        FirebaseUtils.getUid(), FirebaseUtils.getPhoneNumber(),
                        it.number,false, false,System.currentTimeMillis())

                    FirebaseUtils.ref.groupMember(groupID, it.uid)
                        .setValue(groupMember)

                    // add create event in message node
                    FirebaseUtils.createdGroupEvent(it.uid, groupID, it.number)

                    // add member event in message node
                    FirebaseUtils.addedMemberEvent(it.uid, groupID, it.number)

                    FirebaseUtils.ref.lastMessage(it.uid)
                        .child(groupID)
                        .setValue(
                            Models.LastMessageDetail(type = FirebaseUtils.KEY_CONVERSATION_GROUP,
                            nameOrNumber = groupName))
                }


                //add myself
                val groupMember = Models.GroupMember(
                    FirebaseUtils.getUid(),
                    FirebaseUtils.getUid(), FirebaseUtils.getPhoneNumber(),
                    FirebaseUtils.getPhoneNumber()
                    ,true,false,  System.currentTimeMillis())

                //add in member
                FirebaseUtils.ref.groupMember(groupID, FirebaseUtils.getUid())
                    .setValue(groupMember)

                // add create event in message node
                FirebaseUtils.createdGroupEvent(FirebaseUtils.getUid(), groupID, FirebaseUtils.getPhoneNumber())

                participantList.forEach {
                    // add member event in message node
                    FirebaseUtils.addedMemberEvent(FirebaseUtils.getUid(), groupID, it.number)
                }

                //update last message
                FirebaseUtils.ref.lastMessage(FirebaseUtils.getUid())
                    .child(groupID)
                    .setValue(
                        Models.LastMessageDetail(type = FirebaseUtils.KEY_CONVERSATION_GROUP,
                        nameOrNumber = groupName))
                    .addOnSuccessListener {

                        if(profileURL.isEmpty())
                            finish()
                        else
                            updateProfileUrl(groupID, profileURL)
                    }
            }
    }


    private fun uploadGroupProfilePicAndCreateGroup(groupID: String){


        val dialog = ProgressDialog(context)
        dialog.setMessage("Please wait a moment...")
        dialog.setCancelable(false)
        dialog.show()

        val storageRef = FirebaseUtils.ref.profilePicStorageRef(groupID)

        val uploadTask = storageRef.putFile(utils.getUriFromFile(context, imageFile))

        Log.d("CreateGroupActivity", "uploadGroupProfilePicAndCreateGroup: path = ${imageFile.path}")

        uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            Log.d("FirebaseUtils", "uploadedImage: size = "+task.result!!.bytesTransferred/1024)
            return@Continuation storageRef.downloadUrl
        })
            .addOnCompleteListener { task ->
                dialog.dismiss()
                if(task.isSuccessful) {
                    val link = task.result

                    profileURL = link?.toString()!!

                    Log.d("CreateGroupActivity", "uploadGroupProfilePicAndCreateGroup: profile updated ")

                    createGroup(groupID)

                }
                else
                    utils.toast(context, task.exception!!.message.toString())
            }


            .addOnSuccessListener {
                dialog.dismiss()

            }
            .addOnFailureListener{
                dialog.dismiss()
            }



    }


    private fun updateProfileUrl(groupID: String, url:String){
        FirebaseUtils.ref.groupInfo(groupID)
            .child(FirebaseUtils.KEY_PROFILE_PIC_URL)
            .setValue(url)
            .addOnSuccessListener {
                finish()
            }
    }

}
