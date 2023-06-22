package ca.scooter.talkufy.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.fragments.FragmentOTP
import kotlinx.android.synthetic.main.input_phone.*
import org.jetbrains.anko.alert

class MobileLoginActivity : AppCompatActivity() {


    private var fragmentOTP: FragmentOTP? = null

    object KEY {
        const val PHONE = "phone"
        const val COUNTRY = "country"
        const val COUNTRY_CODE = "countryCode"
        const val COUNTRY_LOCALE_CODE = "locale"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_phone)

        country_picker.registerCarrierNumberEditText(mobile_number)

        generate_otp.setOnClickListener {


            if(!country_picker.isValidFullNumber) {
                mobile_number.error = "Input valid number"
                return@setOnClickListener
            }


            fragmentOTP = FragmentOTP()
            val bundle = Bundle()
            val countryCode = country_picker.selectedCountryCode
            val countryName = country_picker.selectedCountryName
            val countryLocale = country_picker.selectedCountryNameCode

            bundle.putString(KEY.PHONE, country_picker.fullNumberWithPlus)
            bundle.putString(KEY.COUNTRY, countryName)
            bundle.putString(KEY.COUNTRY_LOCALE_CODE, countryLocale)
            bundle.putString(KEY.COUNTRY_CODE, countryCode)




            fragmentOTP?.arguments = bundle

            Log.d("MobileLoginActivity", "onCreate: bundle = $bundle")


            alert {
                message = "Is ${country_picker.fullNumberWithPlus} your phone number?"
                positiveButton("Yes"){
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragmentOTP!!)
                        .commit()
            }
            negativeButton("No"){

            }

            }.show()


        }
    }


    override fun onBackPressed() {

        if(!supportFragmentManager.fragments.contains(fragmentOTP))
            super.onBackPressed()
    }

}
