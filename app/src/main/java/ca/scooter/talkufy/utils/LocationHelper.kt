package ca.scooter.talkufy.utils

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import java.util.*

class LocationHelper(val context: Context) : GoogleApiClient.ConnectionCallbacks , GoogleApiClient.OnConnectionFailedListener
{
    private val apiClient: GoogleApiClient = GoogleApiClient.Builder(context)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(LocationServices.API)
        .build()


    constructor( context: Context, map: GoogleMap) : this(context) {
        this.map = map
    }

    private  lateinit var  map:GoogleMap

    private var dialog:AlertDialog? = AlertDialog.Builder(context)
        .setMessage("Getting your current location...").create()

    init {
        connect()
    }

    fun connect() = apiClient.connect()

    fun disconnect() = apiClient.disconnect()



     fun getAddress(latitude:Double, longitude:Double):Address?{

        return Geocoder(context, Locale.getDefault())
            .getFromLocation(latitude,longitude,1)[0]
    }


    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d("LocationHelper", "onConnectionFailed: ")
    }

    @SuppressLint("MissingPermission")
    override fun onConnected(p0: Bundle?) {


        Log.d("LocationHelper", "onConnected:  ")

        LocationServices.getFusedLocationProviderClient(context)
            .lastLocation
            .addOnSuccessListener {
                if(it!=null){

                    if(!apiClient.isConnected) {
                        utils.toast(
                            context,
                            "Location unavailable, check your connection"
                        )
                        return@addOnSuccessListener
                    }


                    val address = getAddress(it.latitude,it.longitude)!!.getAddressLine(0)
                    dialog!!.setMessage(address!!)

                    // Add a marker  and move the camera

                    if(map== null)
                        return@addOnSuccessListener


                    val latLng = LatLng(it.latitude, it.longitude)
                    map.clear()
                    map.addMarker(MarkerOptions().position(latLng).title(address)
                        .draggable(true)
                    )

                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f))



                }
            }
            .addOnFailureListener {
                utils.toast(
                    context,
                    "Error while getting location"
                )
            }
            .addOnCompleteListener{task: Task<Location> ->

                if(task.isSuccessful && task.result!=null){
                    val latitude = task.result!!.latitude
                    val longitude = task.result!!.longitude

                  //  getAddress(latitude, longitude)

                }
                else{
//                    Log.d("LocationHelper", "onConnected: "+task.exception.toString())
//                    Log.d("LocationHelper", "onConnected: exception = "+task.exception!!.message)
                }
            }

       // getAddress(getLastLocation().latitude, getLastLocation().longitude))
    }

    override fun onConnectionSuspended(p0: Int) {
        Log.d("LocationHelper", "onConnectionSuspended: ")

    }



}