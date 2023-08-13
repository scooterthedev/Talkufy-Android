package ca.scooter.talkufy.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ca.scooter.talkufy.R
import ca.scooter.talkufy.utils.FirebaseUtils
import com.firebase.ui.database.FirebaseListAdapter
import com.firebase.ui.database.FirebaseListOptions
import ca.scooter.talkufy.utils.utils
import kotlinx.android.synthetic.main.activity_block_list.*
import kotlinx.android.synthetic.main.item_contact_layout.view.*

class BlockListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block_list)

        title = "Block List"
        if(supportActionBar!= null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeButtonEnabled(true)
        }


        val query = FirebaseUtils.ref.getBlockedUserListQuery(
            FirebaseUtils.getUid())

        val options = FirebaseListOptions.Builder<Any>()
            .setQuery(query, Any::class.java)
            .setLifecycleOwner(this)
            .setLayout(R.layout.item_contact_layout)
            .build()


        val adapter = object : FirebaseListAdapter<Any>(options){
            override fun populateView(v: View, model: Any, position: Int) {

                val title = v.name
                val pic = v.pic
                val uid =  getRef(position).key.toString()


                FirebaseUtils.setUserDetailFromUID(this@BlockListActivity,title, uid , true)

                FirebaseUtils.loadProfileThumbnail(this@BlockListActivity, uid, pic)
            }



        }


        block_listview.setOnItemClickListener { _, _, position, _ ->
            val uid = adapter.getRef(position).key.toString()

            AlertDialog.Builder(this@BlockListActivity).setMessage("Unblock this user")
                .setPositiveButton("Yes") { _, _ ->
                    FirebaseUtils.ref.blockedUser(FirebaseUtils.getUid(), uid)
                        .setValue(false)
                }
                .setNegativeButton("No", null)
                .show()

        }

        block_listview.adapter = adapter
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId == android.R.id.home)
        finish()
        else{
            startActivityForResult(Intent(this, ContactsActivity::class.java).apply {
                putExtra(utils.constants.KEY_IS_FOR_SELECTION, true)
            },111)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.user_profile_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    @SuppressLint("LogNotTimber")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 111 && resultCode == Activity.RESULT_OK){

            val uid = data!!.getStringExtra(FirebaseUtils.KEY_UID)
            Log.d("BlockListActivity", "onActivityResult: blocking -> $uid")
            if (uid != null) {
                FirebaseUtils.ref.blockedUser(FirebaseUtils.getUid(), uid)
                    .setValue(true)
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}
