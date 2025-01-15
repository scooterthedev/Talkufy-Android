package ca.scooter.talkufy.activities

import android.Manifest
import android.annotation.SuppressLint
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
import ca.scooter.talkufy.databinding.ContactScreenBinding
import ca.scooter.talkufy.databinding.ItemConversationLayoutBinding
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ContactScreenBinding
    private var numberList: MutableList<Models.Contact> = mutableListOf()
    private var registeredAvailableUser: MutableList<Models.Contact> = mutableListOf()
    private var isForSelection = false
    private var asyncLoader: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "My Contacts"
        binding.contactsList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@ContactsActivity)
        isForSelection = intent.getBooleanExtra(utils.constants.KEY_IS_FOR_SELECTION, false)

        asyncLoader = CoroutineScope(Dispatchers.IO).launch {
            try {
                withContext(Dispatchers.Main) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ActivityCompat.checkSelfPermission(this@ContactsActivity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 101)
                        } else {
                            loadRegisteredUsers()
                        }
                    } else {
                        loadRegisteredUsers()
                    }
                }
            } finally {
                withContext(Dispatchers.Main) {
                    binding.contactProgressbar.visibility = View.GONE
                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroy() {
        asyncLoader?.cancel()
        super.onDestroy()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            101 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.isNotEmpty())
                    loadRegisteredUsers()
                else {
                    utils.longToast(this, "Permission not granted, exiting...")
                    finish()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun loadRegisteredUsers() {
        numberList = utils.getContactList(this)

        FirebaseUtils.ref.allUser()
            .addValueEventListener(object : ValueEventListener {
                @SuppressLint("SuspiciousIndentation")
                override fun onDataChange(p0: DataSnapshot) {
                    if (!p0.exists()) {
                        utils.toast(this@ContactsActivity, "No registered users")
                        return
                    }

                    registeredAvailableUser.clear()

                    for (post in p0.children) {
                        val userModel = post.getValue(Models.User::class.java)
                        val number = utils.getFormattedTenDigitNumber(userModel!!.phone)
                        val uid = userModel.uid

                        for ((index, item) in numberList.withIndex()) {
                            if (item.number == number || item.number.contains(number)) {
                                numberList[index].uid = uid
                                if (uid != FirebaseUtils.getUid() && !registeredAvailableUser.contains(numberList[index]))
                                    registeredAvailableUser.add(numberList[index])
                            }
                        }
                    }

                    binding.contactsList.adapter = adapter

                    if (isForSelection)
                        return

                    registeredAvailableUser.add(Models.Contact("Invite Users"))
                    registeredAvailableUser.add(0, Models.Contact("New Contact"))
                    registeredAvailableUser.add(1, Models.Contact("New Group"))

                    adapter.notifyDataSetChanged()
                    binding.contactProgressbar.visibility = View.GONE
                }

                override fun onCancelled(p0: DatabaseError) {}
            })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return item.let { super.onOptionsItemSelected(it) }
    }

    private val adapter: RecyclerView.Adapter<ViewHolder> = object : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemConversationLayoutBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int = registeredAvailableUser.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val contact = registeredAvailableUser[position]
            holder.bind(contact, position)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            Log.d("ContactsActivity", "onActivityResult: ")
            loadRegisteredUsers()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    inner class ViewHolder(private val binding: ItemConversationLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Models.Contact, position: Int) {
            binding.name.text = contact.name
            binding.mobileNumber.text = contact.number
            binding.pic.borderWidth = binding.pic.borderWidth
            binding.mobileNumber.visibility = View.VISIBLE

            val uid = contact.uid

            FirebaseUtils.loadProfilePic(this@ContactsActivity, uid, binding.pic)
            binding.pic.setPadding(0, 0, 0, 0)

            if (position == registeredAvailableUser.size - 1 || position == 0 || position == 1) {
                binding.mobileNumber.visibility = View.GONE
                binding.pic.borderWidth = 0
            }

            when (position) {
                0 -> {
                    binding.pic.setImageResource(R.drawable.ic_person_add_white_padded_24dp)
                    binding.pic.circleBackgroundColor = ContextCompat.getColor(this@ContactsActivity, R.color.colorPrimary)
                }
                1 -> {
                    binding.pic.setImageResource(R.drawable.ic_group_add_white_24dp)
                    binding.pic.circleBackgroundColor = ContextCompat.getColor(this@ContactsActivity, R.color.colorPrimary)
                }
                registeredAvailableUser.lastIndex -> {
                    binding.pic.setPadding(30, 30, 30, 30)
                    binding.pic.circleBackgroundColor = Color.TRANSPARENT
                    binding.pic.setImageResource(android.R.drawable.ic_menu_share)
                }
            }

            binding.root.setOnClickListener {
                if (isForSelection) {
                    setResult(Activity.RESULT_OK, intent.apply {
                        putExtra(FirebaseUtils.KEY_UID, uid)
                    })
                    finish()
                    return@setOnClickListener
                }

                when (position) {
                    0 -> {
                        val contactIntent = Intent(Intent.ACTION_INSERT)
                        contactIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
                        startActivityForResult(contactIntent, 1024)
                    }
                    1 -> {
                        startActivity(Intent(this@ContactsActivity, CreateGroupActivity::class.java))
                        finish()
                    }
                    registeredAvailableUser.lastIndex -> utils.shareInviteText(this@ContactsActivity)
                    else -> {
                        startActivity(Intent(this@ContactsActivity, MessageActivity::class.java).apply {
                            putExtra(FirebaseUtils.KEY_UID, uid)
                            putExtra(utils.constants.KEY_NAME_OR_NUMBER, contact.number)
                            putExtra(utils.constants.KEY_TARGET_TYPE, FirebaseUtils.KEY_CONVERSATION_SINGLE)
                        })
                        finish()
                    }
                }
            }
        }
    }
}