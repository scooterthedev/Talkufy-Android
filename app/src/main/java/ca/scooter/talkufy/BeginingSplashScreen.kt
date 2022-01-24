package ca.scooter.talkufy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.activities.HomeActivity
import ca.scooter.talkufy.activities.MobileLoginActivity
import ca.scooter.talkufy.activities.SplashActivity
import ca.scooter.talkufy.utils.FirebaseUtils


class BeginingSplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 sec
    lateinit var sharedPreferences: SharedPreferences
    var isFirstTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begining_splash_screen)



            sharedPreferences = getSharedPreferences("Shared-prefs", Context.MODE_PRIVATE)

            isFirstTime = sharedPreferences.getBoolean("CHECKBOX", true)
            Handler().postDelayed({
                if (isFirstTime) {
                    startActivity(Intent(this, SplashActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this, MobileLoginActivity::class.java))
                    finish()
            if (FirebaseUtils.isLoggedIn()) {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }
        }, SPLASH_TIME_OUT)
    }
}