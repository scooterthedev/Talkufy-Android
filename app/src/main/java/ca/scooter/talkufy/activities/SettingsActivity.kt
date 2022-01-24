package ca.scooter.talkufy.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import android.widget.Switch
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ca.scooter.talkufy.R
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.Pref
import ca.scooter.talkufy.utils.utils.longToast
import ca.scooter.talkufy.views.AnimCheckBox
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateModelManager
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateRemoteModel
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.dialog_list_selector.*
import kotlinx.android.synthetic.main.item_selector.view.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.toast
import java.util.*


class SettingsActivity : AppCompatActivity() {

    val context = this@SettingsActivity

    var languageDialog:BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        title = "Settings"
        if(supportActionBar!=null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeButtonEnabled(true)
        }



        val enableSound = setting_nav_view.menu.findItem(R.id.setting_sound_enable).actionView as Switch
        val enableVibration = setting_nav_view.menu.findItem(R.id.setting_vibration_enable).actionView as Switch

        val mediaVisiblity = setting_nav_view.menu.findItem(R.id.setting_media_visibility).actionView as Switch

        mediaVisiblity.isChecked = Pref.isMediaVisible(this)

        enableSound.isChecked = Pref.Notification.hasSoundEnabled(context)
        enableVibration.isChecked = Pref.Notification.hasVibrationEnabled(context)

        enableSound.setOnCheckedChangeListener { _, isChecked ->
            Pref.Notification.setSoundEnabled(context, isChecked)
        }

        enableVibration.setOnCheckedChangeListener { _, isChecked ->
            Pref.Notification.setVibrationEnabled(context, isChecked)
        }

        mediaVisiblity.setOnCheckedChangeListener{_,isChecked ->
            Pref.setMediaVisibility(context, isChecked)
        }


        with(setting_nav_view.menu){


            val defaultLanguage = Pref.getSettingFile(context)
                .getInt(Pref.KEY_DEFAULT_TRANSLATION_LANG, FirebaseTranslateLanguage.HI)


            Log.d("SettingsActivity", "onCreate: default Language = $defaultLanguage")

            val smartReply = findItem(R.id.setting_smart_reply).actionView as Switch
            smartReply.isChecked = Pref.isTapToReply(context)
            smartReply.setOnCheckedChangeListener { _, isChecked -> Pref.isTapToReply(context, isChecked) }
        }



        //load language list
        val languages:MutableList<String> = ArrayList()
        FirebaseTranslateLanguage.getAllLanguages().forEach {
            val code = FirebaseTranslateLanguage.languageCodeForLanguage(it)
            languages.add(Locale(code).displayName)
        }

        if(Pref.getDefaultLanguage(this) > -1)
        setting_nav_view.menu.findItem(R.id.setting_default_language)?.title = "Default Language (${languages[Pref.getDefaultLanguage(this)]})"

        setting_nav_view.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.setting_block_list -> {
                    startActivity(Intent(context, BlockListActivity::class.java))
                }

                R.id.setting_default_language -> {
                    onDefaultLanguageClick(languages)
                }
            }


            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


    private fun onDefaultLanguageClick(languages:MutableList<String> ){

        if(languageDialog != null){
            languageDialog?.show()
            if(Pref.getDefaultLanguage(context) > -1)
                languageDialog?.recyclerView?.scrollToPosition(Pref.getDefaultLanguage(context))
            return
        }

        val dialog = BottomSheetDialog(context)
        languageDialog = dialog
        with(dialog){
            setContentView(R.layout.dialog_list_selector)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
            show()
            bindLanguageDialog(languages)
        }

    }

    var selectedPosition = -1
    private fun BottomSheetDialog.bindLanguageDialog(languages:MutableList<String> ){


        save_btn.setOnClickListener {
            dismiss()
            if(selectedPosition > -1)
            {
                Pref.setDefaultLanguage(context, selectedPosition)
                this@SettingsActivity.logout_btn.snackbar("Language Changed to ${languages[selectedPosition]}")
                this@SettingsActivity.setting_nav_view.menu.findItem(R.id.setting_default_language)?.title = "Default Language (${languages[selectedPosition]})"
            }


        }
        cancel_btn.setOnClickListener { dismiss() }

        var lastCheckbox: AnimCheckBox? = null

        recyclerView.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                return object : RecyclerView.ViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_selector,parent, false)){}
            }

            override fun getItemCount(): Int = languages.size

            @SuppressLint("SetTextI18n")
            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                with(holder.itemView){
                    item_title.text = languages[position]
                    item_sub_title.text = ""

                    item_checkbox.isChecked = Pref.getDefaultLanguage(context) == position
                    if(item_checkbox.isChecked) lastCheckbox = item_checkbox as AnimCheckBox?

                    FirebaseApp.initializeApp(context)?.let { firebaseApp ->
                        FirebaseTranslateModelManager.getInstance().getAvailableModels(firebaseApp)
                            .addOnSuccessListener {

                                if (it.any { it.language == position }){
                                    item_sub_title.text = "Downloaded"
                                }
                            }
                    }

                    item_selector_layout.setOnClickListener {
                        lastCheckbox?.isChecked = false
                        item_checkbox.isChecked = true
                        lastCheckbox = item_checkbox as AnimCheckBox?
                        selectedPosition = position
                    }

                    setOnLongClickListener {
                        val popupMenu = PopupMenu(context, it)
                        popupMenu.menu.add("Delete")
                        popupMenu.setOnMenuItemClickListener {
                            //delete selected model
                            FirebaseTranslateModelManager.getInstance()
                                .deleteDownloadedModel(FirebaseTranslateRemoteModel.Builder(position).build())
                                .addOnSuccessListener {
                                    toast("Language deleted")
                                    if(position == Pref.getDefaultLanguage(context)){
                                        Pref.getSettingFile(context).edit().remove(
                                            Pref.KEY_DEFAULT_TRANSLATION_LANG).apply()
                                        recyclerView.adapter?.notifyItemChanged(position)
                                        selectedPosition = -1
                                        this@SettingsActivity.setting_nav_view.menu.findItem(R.id.setting_default_language)?.title = "Default Language (Tap to choose)"
                                    }
                                }
                            return@setOnMenuItemClickListener true
                        }
                        popupMenu.show()
                        return@setOnLongClickListener true
                    }
                }
            }

        }

        if(Pref.getDefaultLanguage(context) > -1)
            recyclerView.scrollToPosition(Pref.getDefaultLanguage(context))


    }

    fun onLogoutClick(view: View){


        AlertDialog.Builder(this)
            .setMessage("Logout from this account")
            .setPositiveButton("Yes") { _, _ ->
                FirebaseAuth.getInstance().signOut()
                FirebaseUtils.deleteCurrentToken()
                val intent = Intent(context, MobileLoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }


                longToast("You have been logged out")

                startActivity(intent)
                finish()
            }
            .setNegativeButton("No",null)
            .show()


    }

}
