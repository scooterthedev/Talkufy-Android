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
import ca.scooter.talkufy.databinding.ActivitySettingsBinding
import ca.scooter.talkufy.databinding.DialogListSelectorBinding
import ca.scooter.talkufy.databinding.ItemSelectorBinding
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.Pref
import ca.scooter.talkufy.utils.utils.longToast
import ca.scooter.talkufy.utils.utils.toast
import ca.scooter.talkufy.views.AnimCheckBox
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateModelManager
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateRemoteModel
import org.jetbrains.anko.design.snackbar
import java.util.*


class SettingsActivity : AppCompatActivity() {

    val context = this@SettingsActivity

    private lateinit var settings_binding: ActivitySettingsBinding
    private lateinit var list_binding: DialogListSelectorBinding
    private lateinit var selector_binding: ItemSelectorBinding

    var languageDialog:BottomSheetDialog? = null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        settings_binding = ActivitySettingsBinding.inflate(LayoutInflater).also { setContentView(it.root) }
        list_binding = DialogListSelectorBinding.inflate(LayoutInflater).also { setContentView(it.root) }
        selector_binding = ItemSelectorBinding.inflate(LayoutInflater).also { setContentView(it.root) }

        title = "Settings"
        if(supportActionBar!=null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeButtonEnabled(true)
        }



        val enableSound = settings_binding.settingNavView.menu.findItem(R.id.setting_sound_enable).actionView as Switch
        val enableVibration = settings_binding.settingNavView.menu.findItem(R.id.setting_vibration_enable).actionView as Switch

        val mediaVisiblity = settings_binding.settingNavView.menu.findItem(R.id.setting_media_visibility).actionView as Switch

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


        with(settings_binding.settingNavView.menu){


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
            settings_binding.settingNavView.menu.findItem(R.id.setting_default_language)?.title = "Default Language (${languages[Pref.getDefaultLanguage(this)]})"

        settings_binding.settingNavView.setNavigationItemSelectedListener {

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


        list_binding.saveBtn.setOnClickListener {
            dismiss()
            if(selectedPosition > -1)
            {
                Pref.setDefaultLanguage(context, selectedPosition)
                this@SettingsActivity.settings_binding.logoutBtn.snackbar("Language Changed to ${languages[selectedPosition]}")
                this@SettingsActivity.settings_binding.settingNavView.menu.findItem(R.id.setting_default_language)?.title = "Default Language (${languages[selectedPosition]})"
            }


        }
        list_binding.cancelBtn.setOnClickListener { dismiss() }

        var lastCheckbox: AnimCheckBox? = null

        list_binding.recyclerView.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                return object : RecyclerView.ViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_selector,parent, false)){}
            }

            override fun getItemCount(): Int = languages.size

            @SuppressLint("SetTextI18n")
            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                with(holder.itemView){
                    selector_binding.itemTitle.text = languages[position]
                    selector_binding.itemSubTitle.text = ""

                    selector_binding.itemCheckbox.isChecked = Pref.getDefaultLanguage(context) == position
                    if(selector_binding.itemCheckbox.isChecked) lastCheckbox = selector_binding.itemCheckbox as AnimCheckBox?

                    FirebaseApp.initializeApp(context)?.let { firebaseApp ->
                        FirebaseTranslateModelManager.getInstance().getAvailableModels(firebaseApp)
                            .addOnSuccessListener {

                                if (it.any { it.language == position }){
                                    selector_binding.itemSubTitle.text = "Downloaded"
                                }
                            }
                    }

                    selector_binding.itemSelectorLayout.setOnClickListener {
                        lastCheckbox?.isChecked = false
                        selector_binding.itemCheckbox.isChecked = true
                        lastCheckbox = selector_binding.itemCheckbox as AnimCheckBox?
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
                                        list_binding.recyclerView.adapter?.notifyItemChanged(position)
                                        selectedPosition = -1
                                        this@SettingsActivity.settings_binding.settingNavView.menu.findItem(R.id.setting_default_language)?.title = "Default Language (Tap to choose)"
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
            list_binding.recyclerView.scrollToPosition(Pref.getDefaultLanguage(context))


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
