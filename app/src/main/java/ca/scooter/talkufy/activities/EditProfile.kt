package ca.scooter.talkufy.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.layout_profile_image_picker.*
import me.shaohui.advancedluban.Luban
import me.shaohui.advancedluban.OnCompressListener
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast
import java.io.File

class EditProfile : AppCompatActivity() {

    var myUID = FirebaseUtils.getUid()
    val context = this
    var isProfileChanged = false
    lateinit var bitmap:Bitmap
    lateinit var imageFile:File
    var isForAccountCreation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)


        isForAccountCreation = intent.getBooleanExtra(utils.constants.KEY_IS_ON_ACCOUNT_CREATION, false)

        if(supportActionBar!=null && !isForAccountCreation)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        title = "My Profile"

        myUID = FirebaseUtils.getUid()

        FirebaseUtils.loadProfilePic(this, myUID, profile_circleimageview)


        ///Pick Profile Image Button
        profile_pick_btn.setOnClickListener {
//            ImagePicker.pickImage(context)

            selector("Edit profile picture", listOf("Change picture", "Remove picture")) { _, pos ->

                if(pos == 0){
                    CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setCropShape(CropImageView.CropShape.RECTANGLE)
                    .setAspectRatio(1,1)
                    .start(this)
                }
                else{
                    //delete pic
                     FirebaseUtils.ref.user(myUID)
                        .child(FirebaseUtils.KEY_PROFILE_PIC_URL).setValue("").addOnSuccessListener { toast("Profile pic removed") }
                }

            }


        }



        ///Fill TextEdits with user info if user
        // already logged in
        if(FirebaseUtils.isLoggedIn()) {
            FirebaseUtils.ref.user(myUID)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) { }

                    override fun onDataChange(p0: DataSnapshot) {
                        var profileURL = ""
                        var name = ""
                        var full_name = ""
                        var city = ""
                        var bio = "Hey there, I am using Talkafy!"
                        if(p0.exists()){
                            try {
                                profileURL=p0.getValue(Models.User::class.java)?.profile_pic_url!!
                                name = p0.getValue(Models.User::class.java)?.name!!
                                full_name= p0.getValue(Models.User::class.java)?.full_name!!
                                bio = p0.getValue(Models.User::class.java)?.bio!!
                                city = p0.getValue(Models.User::class.java)?.city!!
                            } catch (e: Exception) { }
                        }

                        profile_name.setText(name)
                        profile_bio.setText(bio)
                        profile_location.setText(city)
                        profile_full_name.setText(full_name)
                    }
                })
        }



        ///Update user Info
        updateProfileBtn.setOnClickListener {

            /// Check if username is empty
            if(profile_name.text.isEmpty()){
                profile_name.error = "Username cannot be empty"
                return@setOnClickListener
            }
            /// Check if full name is empty
            if(profile_full_name.text.isEmpty()){
                profile_full_name.error = "Enter your full name"
                return@setOnClickListener
            }
            /// Check if city is empty
            if(profile_location.text.isEmpty()){
                profile_location.error = "Tell us your current city"
                return@setOnClickListener
            }
            /// Check if bio is empty
            if(profile_bio.text.isEmpty()){
                profile_bio.error = "Write your current status"
                return@setOnClickListener
            }


            if(isProfileChanged) {

                val storageRef = FirebaseUtils.ref.profilePicStorageRef(myUID)

                val dbRef = FirebaseUtils.ref.user(myUID)
                    .child(FirebaseUtils.KEY_PROFILE_PIC_URL)

               uploadProfilePic(context, imageFile, storageRef, dbRef, "Profile updated")

               // uploadImage(imageFile)
                isProfileChanged = false
            }





            //Update Username
            FirebaseUtils.ref.user(myUID)
                .child(FirebaseUtils.KEY_NAME)
                .setValue(profile_name.text.toString())
            //Update full name
            FirebaseUtils.ref.user(myUID)
                .child(FirebaseUtils.KEY_FULL_NAME)
                .setValue(profile_full_name.text.toString())
            //Update current City
            FirebaseUtils.ref.user(myUID)
                .child(FirebaseUtils.KEY_CITY)
                .setValue(profile_location.text.toString())
            //Update current BIO
            FirebaseUtils.ref.user(myUID)
                .child(FirebaseUtils.KEY_BIO)
                .setValue(profile_bio.text.toString())


            if(profile_name.text.isNotEmpty()){
                if(FirebaseUtils.isLoggedIn()) {
                    FirebaseAuth.getInstance().currentUser!!.updateProfile(
                    UserProfileChangeRequest.Builder()
                        .setDisplayName(profile_name.text.toString().trim()).build())
                }
            }


            if(intent.getBooleanExtra(utils.constants.KEY_IS_ON_ACCOUNT_CREATION, false)
                and !isProfileChanged){
                startActivity(Intent(context, HomeActivity::class.java))
                finish()
            }


        }

        //load profile name
        FirebaseUtils.ref.user(FirebaseUtils.getUid())
            .child(FirebaseUtils.KEY_NAME)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    profile_name.setText( p0.value.toString().trim() )
                }
            })

    }


    private fun uploadProfilePic(context: Context, file: File, storageRef: StorageReference,
                                 dbRef: DatabaseReference,
                                 toastAfterUploadIfAny: String){


        val dialog = ProgressDialog(context)
        dialog.setMessage("Please wait a moment...")
        dialog.setCancelable(false)
        dialog.show()



        Log.d("EditProfile", "uploadImage: File size = "+file.length()/1024)




        val uploadTask = storageRef.putFile(utils.getUriFromFile(context, file))

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

                try {
                    dialog.dismiss()
                }catch (e:Exception){}
                if(task.isSuccessful) {
                    val link = task.result

                    dbRef.setValue(link.toString())
                        .addOnSuccessListener {
                            //   isProfileChanged = false
                            if(toastAfterUploadIfAny.isNotEmpty())
                                utils.toast(context, toastAfterUploadIfAny) }


                    if(FirebaseUtils.isLoggedIn()) {
                        FirebaseAuth.getInstance().currentUser!!
                            .updateProfile(
                                UserProfileChangeRequest.Builder()
                                    .setPhotoUri(link).build()
                            )
                    }

                    if(intent.getBooleanExtra(utils.constants.KEY_IS_ON_ACCOUNT_CREATION, false)){
                        startActivity(Intent(context, HomeActivity::class.java))
                        finish()
                    }




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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when(resultCode){
            Activity.RESULT_OK -> {


                utils.printIntentKeyValues(data!!)

                 val result = CropImage.getActivityResult(data)
                val filePath = result.uri.path

                Log.d("EditProfile", "onActivityResult: $filePath")
                    //utils.getRealPathFromURI(context, result.uri)
                     //ImagePicker.getImagePathFromResult(context, requestCode, resultCode, data)

                Luban.compress(context, File(filePath))
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
                            utils.toast(context, e!!.message.toString())
                        }

                    })


            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

}
