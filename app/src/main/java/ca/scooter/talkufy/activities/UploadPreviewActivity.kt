package ca.scooter.talkufy.activities

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.adapters.ViewPagerImageAdapter
import ca.scooter.talkufy.databinding.ActivityUploadPreviewBinding
import ca.scooter.talkufy.utils.utils
import com.molihuan.pathselector.entity.FileEntity
import com.molihuan.pathselector.dialog.impl.PathSelectDialog
class UploadPreviewActivity : AppCompatActivity() {

    val imagePaths: MutableList<String> = ArrayList()
    var imageCaptions: MutableList<String> = ArrayList()
    private lateinit var binding: ActivityUploadPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_preview)
        binding = ActivityUploadPreviewBinding.inflate(LayoutInflater).also { setContentView(it.root) }

        setSupportActionBar(binding.toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeButtonEnabled(true)
        }

        val isForSingleFile = intent.getBooleanExtra(utils.constants.IS_FOR_SINGLE_FILE, false)

        if (isForSingleFile) {
            val cameraImagePath = intent.getStringExtra(utils.constants.KEY_IMG_PATH)
            if (cameraImagePath != null) {
                imagePaths.add(cameraImagePath)
            }
        } else {
            val fileType = intent.getStringExtra(utils.constants.KEY_FILE_TYPE)

            if (fileType == utils.constants.FILE_TYPE_VIDEO || fileType == utils.constants.FILE_TYPE_IMAGE) {
                val fileSelector = PathSelectDialog().apply {
                    this.config(this@UploadPreviewActivity) {
                        showFileTypes = listOf("video/*", "image/*")
                    }
                }

                fileSelector.show(supportFragmentManager, "PathSelectorDialog")

                fileSelector.setOnFileSelectCallback { selectedFiles ->
                    for (fileEntity in selectedFiles) {
                        imageCaptions.add("")
                        imagePaths.add(fileEntity.path)
                    }
                }
            }
        }

        val fileTypes = ArrayList<String>()
        for (i in 0 until imagePaths.size)
            intent.getStringExtra(utils.constants.KEY_FILE_TYPE)?.let { fileTypes.add(it) }

        if (imagePaths.isEmpty()) {
            setResult(Activity.RESULT_CANCELED)
            finish()
            utils.longToast(this, "Failed to load image")
        }

        val adapter = ViewPagerImageAdapter(
            layoutInflater,
            imagePaths as java.util.ArrayList<String>,
            fileTypes
        )
        binding.viewPager.adapter = adapter

        binding.sendBtn.setOnClickListener {

            if (imagePaths.isEmpty()) {
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            } else {

                imageCaptions = adapter.getImageCaptions()

                setResult(
                    Activity.RESULT_OK,
                    intent.putStringArrayListExtra(
                        utils.constants.KEY_CAPTION,
                        imageCaptions as java.util.ArrayList<String>?
                    )
                        .putStringArrayListExtra(
                            utils.constants.KEY_IMG_PATH,
                            imagePaths as java.util.ArrayList<String>?
                        )
                        .putExtra(
                            utils.constants.KEY_FILE_TYPE, intent.getStringExtra(
                                utils.constants.KEY_FILE_TYPE
                            )
                        )
                )

                finish()

            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                setResult(Activity.RESULT_CANCELED)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}