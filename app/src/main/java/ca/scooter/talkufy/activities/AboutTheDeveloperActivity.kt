package ca.scooter.talkufy.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import ca.scooter.talkufy.utils.utils.toast
import com.yarolegovich.lovelydialog.BuildConfig
import com.yarolegovich.lovelydialog.LovelyTextInputDialog
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element


class AboutTheDeveloperActivity : AppCompatActivity(){
    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val aboutPage = AboutPage(this)
            .isRTL(false)
            .setImage(R.mipmap.ic_launcher)
            .setDescription("Talkufy is a chatting/video calling app developed by Scooter")
            .addItem(
                Element(
                    "Version " + BuildConfig.VERSION_NAME,
                    R.mipmap.ic_launcher
                )
            )
            .addGroup("Connect with us")
            .addEmail("info@talkufy.com")
            .addWebsite(
                "https://instructables.com/member/AwesomeBanana120/",
                "Visit my website (Temp, it will be removed in a later update.)"
            )
            .addGitHub("scooterthedev/", "Visit me on Github")


        Log.d("about", "onCreate: uid = ${FirebaseUtils.getUid()}")

        if (FirebaseUtils.getUid() == utils.constants.debugUserID ||
            FirebaseUtils.getUid() == "C0eXLeD02zYWTTsIPt3OyDQndad2" ||
            FirebaseUtils.getUid() == "C0eXLeD02zYWTTsIPt3OyDQndad2" || BuildConfig.DEBUG
        ) {

            // if it falls under one of my uids or debug APK
            Log.d("AboutTheDeveloper", "onCreate: show feedbacks")

            aboutPage.addItem(Element("Feedbacks", android.R.drawable.ic_dialog_info).setOnClickListener
            { startActivity(Intent(this@AboutTheDeveloperActivity, FeedbackActivity::class.java)) })
        }

        val aboutView = aboutPage.create()

        setContentView(aboutView)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    private fun showFeedbackDialog(uid:String){


        LovelyTextInputDialog(this)
            .setTopColorRes(R.color.colorAccent)
            .setTopTitleColor(Color.WHITE)
            .setTopTitle("Feedback")
            .setTitle("Type your feedback here...")
            .setInputFilter("Too short") {
                return@setInputFilter it.isNotBlank() && it.length > 5
            }
            .setConfirmButton("Submit") {

                FirebaseUtils.ref.feedback()
                    .push()
                    .setValue(Models.Feedback(uid, feedback = it))
                    .addOnSuccessListener { toast("Feedback submitted! If this is a bug that makes this app not workable please contact me with on of the options in the last page or file an issue on Github. Thanks!") }


            }
            .setNegativeButton("Cancel"){}
            .show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //just finishing this activity
        finish()
        return super.onOptionsItemSelected(item)
    }


}
