package ca.scooter.talkufy.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ca.scooter.talkufy.R
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.contact_screen.*
import kotlinx.android.synthetic.main.item_conversation_layout.view.*
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.onComplete
import org.jetbrains.anko.uiThread
import java.util.concurrent.Future

class ContactsActivity : AppCompatActivity(){

    //number list has 10 digit formatted number
    var numberList:MutableList<Models.Contact> = mutableListOf()
    var registeredAvailableUser:MutableList<Models.Contact> = mutableListOf()

    var isForSelection = false
    private var asyncLoader: Future<Unit>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.contact_screen)

        title = "My Contacts"

        contacts_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@ContactsActivity)

        isForSelection = intent.getBooleanExtra(utils.constants.KEY_IS_FOR_SELECTION, false)

        asyncLoader = doAsyncResult {

            uiThread {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if(ActivityCompat.checkSelfPermission(this@ContactsActivity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
                        requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 101)
                    else
                        loadRegisteredUsers()

                }
                else
                    loadRegisteredUsers()
            }

            onComplete { contact_progressbar.visibility = View.GONE  }
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true)




    }


    override fun onDestroy() {
        asyncLoader?.cancel(true)
        super.onDestroy()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when(requestCode){
            101 -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.isNotEmpty())
                    loadRegisteredUsers()
                else {
                    utils.longToast(this, "Permission not granted, exiting...")
                    finish()
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    private fun loadRegisteredUsers(){




        numberList = utils.getContactList(this)

        FirebaseUtils.ref.allUser()
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(p0: DataSnapshot) {

                    if(!p0.exists()) {
                        utils.toast(this@ContactsActivity, "No registered users")
                        return
                    }

                    registeredAvailableUser.clear()

                    for (post in p0.children){
                        val userModel = post.getValue(Models.User ::class.java)

                        val number = utils.getFormattedTenDigitNumber(userModel!!.phone)
                        val uid = userModel.uid


                        for((index, item) in numberList.withIndex()) {
                            if (item.number == number || item.number.contains(number)) {
                                numberList[index].uid = uid
                                if(uid!= FirebaseUtils.getUid() && !registeredAvailableUser.contains(numberList[index]))
                                registeredAvailableUser.add(numberList[index])
                            }

                        }

                    }

                    contacts_list.adapter = adapter

                    if(isForSelection)
                        return

                    registeredAvailableUser.add(Models.Contact("Invite Users"))
                    registeredAvailableUser.add(0, Models.Contact("New Contact"))
                    registeredAvailableUser.add(1, Models.Contact("New Group"))

                    adapter.notifyDataSetChanged()
                    contact_progressbar.visibility = View.GONE


                }

                override fun onCancelled(p0: DatabaseError) {
                }

            })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return item.let { super.onOptionsItemSelected(it) }
    }


    val adapter: RecyclerView.Adapter<ViewHolder> = object : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder
                = ViewHolder(layoutInflater.inflate(R.layout.item_conversation_layout, p0, false))

        override fun getItemCount(): Int = registeredAvailableUser.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.name.text = registeredAvailableUser[position].name
            holder.number.text = registeredAvailableUser[position].number

            holder.pic.borderWidth = holder.pic.borderWidth
            holder.number.visibility = View.VISIBLE

            val uid = registeredAvailableUser.get(index = position).uid

            FirebaseUtils.loadProfilePic(this@ContactsActivity, uid, holder.pic)
            holder.pic.setPadding(0,0,0,0)

            if(position == registeredAvailableUser.size - 1 || position == 0 || position == 1) {
                holder.number.visibility = View.GONE
                holder.pic.borderWidth = 0
            }

            when(position){
                0 -> {
                    holder.pic.setImageResource(R.drawable.ic_person_add_white_padded_24dp)
                    holder.pic.circleBackgroundColor = ContextCompat.getColor(this@ContactsActivity,
                        R.color.colorPrimary
                    )
                }

                1-> {
                    holder.pic.setImageResource(R.drawable.ic_group_add_white_24dp)
                    holder.pic.circleBackgroundColor = ContextCompat.getColor(this@ContactsActivity,
                        R.color.colorPrimary
                    )
                }
                registeredAvailableUser.lastIndex -> {
                    holder.pic.setPadding(30,30,30,30)
                    holder.pic.circleBackgroundColor = Color.TRANSPARENT
                    holder.pic.setImageResource(android.R.drawable.ic_menu_share)
                }
            }


            holder.itemView.setOnClickListener {

                if(isForSelection){
                    setResult(Activity.RESULT_OK, intent.apply {
                        putExtra(FirebaseUtils.KEY_UID, uid )
                    })
                    finish()
                    return@setOnClickListener
                }



                when (position) {
                    0 -> {
                        // new contact
                        val contactIntent = Intent(Intent.ACTION_INSERT)
                        contactIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
                        startActivityForResult(contactIntent,1024)
                    }
                    1 -> {
                        //new group
                        startActivity(Intent(this@ContactsActivity, CreateGroupActivity::class.java))
                        finish()
                    }
                    registeredAvailableUser.lastIndex -> utils.shareInviteText(this@ContactsActivity)
                    
                    else -> {
                        startActivity(Intent(this@ContactsActivity, MessageActivity::class.java)
                            .putExtra(FirebaseUtils.KEY_UID, uid)
                            .putExtra(utils.constants.KEY_NAME_OR_NUMBER, registeredAvailableUser[position].number)
                            .putExtra(utils.constants.KEY_TARGET_TYPE, FirebaseUtils.KEY_CONVERSATION_SINGLE))
                        finish()
                    }
                }


            }


        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(resultCode == Activity.RESULT_OK) {
            Log.d("ContactsActivity", "onActivityResult: ")
            //refresh list
            loadRegisteredUsers()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){
                val name = itemView.name
                val number = itemView.mobile_number
                val pic = itemView.pic
                private val time = itemView.messageTime!!

                init {
                    time.visibility = View.GONE
                }
            }
}