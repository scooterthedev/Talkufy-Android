package ca.scooter.talkufy.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.databinding.ActivityMessageBinding
import ca.scooter.talkufy.databinding.InputPhoneBinding
import ca.scooter.talkufy.fragments.FragmentOTP
import kotlinx.android.synthetic.main.input_phone.*
import org.jetbrains.anko.alert

class MobileLoginActivity : AppCompatActivity() {


    private var fragmentOTP: FragmentOTP? = null

    private lateinit var binding: InputPhoneBinding

    object KEY {
        const val PHONE = "phone"
        const val COUNTRY = "country"
        const val COUNTRY_CODE = "countryCode"
        const val COUNTRY_LOCALE_CODE = "locale"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_phone)

        binding = InputPhoneBinding.inflate(LayoutInflater).also { setContentView(it.root) }

        binding.countryPicker.registerCarrierNumberEditText(binding.mobileNumber)

        binding.generateOtp.setOnClickListener {


            if(!binding.countryPicker.isValidFullNumber) {
                binding.mobileNumber.error = "Input valid number"
                return@setOnClickListener
            }


            fragmentOTP = FragmentOTP()
            val bundle = Bundle()
            val countryCode = binding.countryPicker.selectedCountryCode
            val countryName = binding.countryPicker.selectedCountryName
            val countryLocale = binding.countryPicker.selectedCountryNameCode

            bundle.putString(KEY.PHONE, binding.countryPicker.fullNumberWithPlus)
            bundle.putString(KEY.COUNTRY, countryName)
            bundle.putString(KEY.COUNTRY_LOCALE_CODE, countryLocale)
            bundle.putString(KEY.COUNTRY_CODE, countryCode)




            fragmentOTP?.arguments = bundle

            Log.d("MobileLoginActivity", "onCreate: bundle = $bundle")


            alert {
                message = "Is ${binding.countryPicker.fullNumberWithPlus} your phone number?"
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
