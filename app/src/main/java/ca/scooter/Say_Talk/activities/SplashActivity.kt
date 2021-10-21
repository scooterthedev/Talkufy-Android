package ca.scooter.Say_Talk.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.Say_Talk.R
import ca.scooter.Say_Talk.utils.FirebaseUtils

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
