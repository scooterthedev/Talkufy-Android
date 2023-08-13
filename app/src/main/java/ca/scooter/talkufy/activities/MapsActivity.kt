package ca.scooter.talkufy.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import ca.scooter.talkufy.utils.utils
import kotlinx.android.synthetic.main.activity_maps.*
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var currentLatLng: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap




        mMap.isMyLocationEnabled = true
        mMap.uiSettings.isMyLocationButtonEnabled = false

        mMap.uiSettings.setAllGesturesEnabled(true)

        LocationServices.getFusedLocationProviderClient(this@MapsActivity)
            .lastLocation
            .addOnCompleteListener {
                if(it.isSuccessful) {
                    try {
                        val latLng = LatLng(it.result!!.latitude, it.result!!.longitude)

                        loadLocation(latLng)

                        current_location_btn.setOnClickListener {
                            loadLocation(latLng)
                        }
                    }
                    catch (e:Exception){ utils.toast(this@MapsActivity,"Failed to load current location")}
                }
            }




        googleMap.setOnMarkerDragListener(object: GoogleMap.OnMarkerDragListener{
            override fun onMarkerDragEnd(p0: Marker?) {

                p0!!.title= getAddress(p0.position.latitude, p0.position.longitude)
                    ?.getAddressLine(0)
                    .toString()

                currentLatLng = LatLng(p0.position.latitude, p0.position.longitude)

            }

            override fun onMarkerDragStart(p0: Marker?) {
            }

            override fun onMarkerDrag(p0: Marker?) {
            }

        })



        share_location_btn.setOnClickListener {

            val latitude = currentLatLng.latitude
            val longitude = currentLatLng.longitude

            var address = getAddress(latitude, longitude)!!.getAddressLine(0)

            if(!enable_address_checkbox.isChecked)
                address = ""



            setResult(Activity.RESULT_OK, intent.putExtra(utils.constants.KEY_LATITUDE, latitude)
                .putExtra(utils.constants.KEY_LONGITUDE, longitude)
                .putExtra(utils.constants.KEY_ADDRESS, address)
            )
            finish()

        }


        googleMap.setOnMapLongClickListener {
            loadLocation(it)
        }


    }


    private fun loadLocation(latLng: LatLng){

        currentLatLng = latLng

        mMap.clear()

        val address = getAddress(latLng.latitude,latLng.longitude)


        mMap.addMarker(MarkerOptions().position(latLng).title(address!!.getAddressLine(0))
            .draggable(true)
        )

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))

    }


    fun getAddress(latitude:Double, longitude:Double): Address?{

        return Geocoder(this@MapsActivity, Locale.getDefault())
            .getFromLocation(latitude,longitude,1)[0]
    }


}
