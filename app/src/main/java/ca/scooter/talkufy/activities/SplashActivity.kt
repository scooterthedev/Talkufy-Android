package ca.scooter.talkufy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.utils.FirebaseUtils

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(FirebaseUtils.isLoggedIn()){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

    }


    fun onGetStartedClick(v: View){
        startActivity(Intent(this, MobileLoginActivity::class.java))
    }
}
