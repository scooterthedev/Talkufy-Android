package ca.scooter.talkufy.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage

object Pref {

    const val KEY_SOUND = "sound"
    const val KEY_VIBRATION = "vibration"
    const val FILE_SETTING = "settings"
    const val FILE_PROFILE = "profile"
    const val KEY_DEFAULT_TRANSLATION_LANG = "default_translation_language"
    const val KEY_TAP_TO_REPLY = "tap_to_reply"
    const val KEY_CURRENT_TARGET = "current"
    const val KEY_MEDIA_VISIBILITY = "media_visibility"

    fun storeToken(context: Context, token:String){
        context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
            .edit().putString("token", token)
            .apply()
    }

    fun getStoredToken(context: Context):String? = context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
            .getString("token","")


    object Notification{
        fun setSoundEnabled(context: Context, isEnabled:Boolean){
            context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(KEY_SOUND, isEnabled)
                .apply()
        }

        fun setVibrationEnabled(context: Context, isEnabled:Boolean){
            context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(KEY_VIBRATION, isEnabled)
                .apply()
        }


        fun hasSoundEnabled(context: Context):Boolean =
            context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
                .getBoolean(KEY_SOUND, true)

        fun hasVibrationEnabled(context: Context):Boolean =
            context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
                .getBoolean(KEY_VIBRATION, true)

    }

    object Profile{
        fun setProfileUrl(context: Context, uid:String, url:String){
            Log.d("Profile", "setProfileUrl: profile url updated")
            context.getSharedPreferences(FILE_PROFILE, Context.MODE_PRIVATE)
                .edit()
                .putString(uid, url)
                .apply()
        }

        fun isProfileUrlSame(context: Context, uid: String, providedURL:String): Boolean{
           return  context.getSharedPreferences(FILE_PROFILE, Context.MODE_PRIVATE)
                .getString(uid,"") == providedURL

        }
    }

   fun setCurrentTargetUID(context: Context, targetUID:String){
       context.getSharedPreferences(KEY_CURRENT_TARGET, Context.MODE_PRIVATE)
           .edit()
           .putString(KEY_CURRENT_TARGET, targetUID)
           .apply()
   }


    fun getCurrentTargetUID(context: Context):String? {
        return context.getSharedPreferences(KEY_CURRENT_TARGET, Context.MODE_PRIVATE)
            .getString(KEY_CURRENT_TARGET,"")
    }


    fun setMediaVisibility(context:Context, isVisible:Boolean){
        context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_MEDIA_VISIBILITY, isVisible)
            .apply()
    }


    fun isMediaVisible(context:Context):Boolean{
        return context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
            .getBoolean(KEY_MEDIA_VISIBILITY, true)
    }

    fun getSettingFile(context: Context):SharedPreferences{
        return context.getSharedPreferences(FILE_SETTING, Context.MODE_PRIVATE)
    }

    fun isTapToReply(context: Context):Boolean {
        return getSettingFile(context)
            .getBoolean(KEY_TAP_TO_REPLY, true)
    }


     fun isTapToReply(context: Context, isEnabled: Boolean) {
         Log.d("Pref", "isTapToReply: $isEnabled")
            getSettingFile(context)
                .edit().putBoolean(KEY_TAP_TO_REPLY, isEnabled).apply()

     }

    fun setDefaultLanguage(context: Context, languageCode:Int){

        Log.d("Pref", "setDefaultLanguage: language set to -> ${FirebaseTranslateLanguage.languageCodeForLanguage(languageCode)}")

        getSettingFile(context).edit()
            .putInt(KEY_DEFAULT_TRANSLATION_LANG, languageCode).apply()
    }

    fun getDefaultLanguage(context: Context, defaultLanguage:Int = -1):Int{
        return getSettingFile(context)
            .getInt(KEY_DEFAULT_TRANSLATION_LANG, defaultLanguage)
    }


}