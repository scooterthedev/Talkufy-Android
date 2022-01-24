package ca.scooter.talkufy.activities

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.activity_begining_splash_screen.*
import kotlinx.android.synthetic.main.activity_image_preview.*
import java.io.File

class ImagePreviewActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview)



        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.BLACK
        }

        title = ""


        var imgURL = intent.getStringExtra(utils.constants.KEY_IMG_PATH)
        var imgLocalPath = intent.getStringExtra(utils.constants.KEY_LOCAL_PATH)

        val messageModel = intent.getSerializableExtra(utils.constants.KEY_MSG_MODEL) as? Models.MessageModel

        messageModel?.let {

            title = if(it.from == FirebaseUtils.getUid())
                "You"
            else
                "Sender"


            toolbar.subtitle = utils.getLocalDate(it.timeInMillis) +" "+ utils.getLocalTime(it.timeInMillis)
        }



        if(imgURL == null)
            imgURL = ""

        if(imgLocalPath == null)
            imgLocalPath = ""


        if(imgURL.isEmpty() && imgLocalPath.isEmpty()){
            utils.toast(this@ImagePreviewActivity, "Failed to load image")
            finish()
        }


         val target:Target = object : Target{
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                //utils.toast(this@ImagePreviewActivity, "Preparing to load")
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                utils.toast(this@ImagePreviewActivity, "Failed to load : Image might be deleted")
                Log.d("ImagePreviewActivity", "onBitmapFailed: ${e!!.message}")
                finish()

            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                imageView.setImageBitmap(bitmap)
                //utils.toast(this@ImagePreviewActivity, "Loaded")
                progress_bar.visibility = View.GONE

            }

        }

        preview.tag = target

        if(File(imgLocalPath).exists()){


            Picasso.get()
                .load(File(imgLocalPath))
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(target)

        }
        else{

            if(imgURL.isEmpty()){
                utils.toast(this@ImagePreviewActivity, "Failed to load image")
                Log.d("ImagePreviewActivi13ty", "onCreate: path empty")
                finish()
            }
            else
            Picasso.get()
                .load(imgURL.toString())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(target)
        }




    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId){
            android.R.id.home ->{
                finish()
            }
        }


        return super.onOptionsItemSelected(item)
    }
}
