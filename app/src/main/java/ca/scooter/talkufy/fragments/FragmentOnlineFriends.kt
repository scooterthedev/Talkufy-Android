package ca.scooter.talkufy.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ca.scooter.talkufy.R
import ca.scooter.talkufy.activities.HomeActivity
import ca.scooter.talkufy.activities.MessageActivity
import ca.scooter.talkufy.models.Models
import ca.scooter.talkufy.utils.FirebaseUtils
import ca.scooter.talkufy.utils.utils
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.item_contact_layout_2.view.*
import kotlinx.android.synthetic.main.layout_recycler_view.*
import kotlinx.android.synthetic.main.layout_recycler_view.view.*
import org.jetbrains.anko.collections.forEachWithIndex

class FragmentOnlineFriends : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.layout_recycler_view,container, false)
        loadRegisteredUsers(view)
        return view


    }


    @SuppressLint("UseRequireInsteadOfGet")
    private fun loadRegisteredUsers(view: View){

        if(!utils.hasContactPermission(context!!))
            return



        FirebaseUtils.ref.allUser()
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(p0: DataSnapshot) {


                    if(context == null)
                        return

                    val numberList: MutableList<Models.Contact> = utils.getContactList(context)
                    val registeredAvailableUser:MutableList<Models.Contact> = mutableListOf()


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


                    val onlineUsers = mutableListOf<Models.Contact>()


                    registeredAvailableUser.forEachWithIndex { _, it ->
                        FirebaseUtils.ref.userStatus(it.uid)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onCancelled(p0: DatabaseError) {
                            }

                            override fun onDataChange(p0: DataSnapshot) {

                                if(!p0.exists())
                                    return

                                val onlineStatus = p0.getValue(Models.UserActivityStatus::class.java)

                                if(onlineStatus?.status == FirebaseUtils.VAL_ONLINE ||
                                        onlineStatus?.status!!.startsWith(FirebaseUtils.VAL_TYPING)) {
                                    if (!onlineUsers.contains(it)) {
                                        onlineUsers.add(it)
                                    }
                                }
                                else
                                    onlineUsers.remove(it)

                                try {
                                    setOnlineAdapter(onlineUsers, view)
                                }
                                catch (e:Exception){ }
                            }

                        })}


                }

                override fun onCancelled(p0: DatabaseError) {
                }

            })
    }

    private fun setOnlineAdapter(onlineUsers:MutableList<Models.Contact>, view: View){


        recycler_back_message.visibility =if(onlineUsers.isNotEmpty()) View.GONE
        else View.VISIBLE

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val name = itemView.name
            val pic = itemView.pic

        }

       try { (context as HomeActivity).setOnlineCount(onlineUsers.size) }
       catch (e:Exception){}

        view.recyclerView.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
                return ViewHolder(layoutInflater.inflate(R.layout.item_layout_online,
                    p0, false))
            }

            override fun getItemCount(): Int = onlineUsers.size

            override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
                p0.name.text = utils.getNameFromNumber(context!!, onlineUsers[p1].number)
                FirebaseUtils.loadProfileThumbnail(context!!, onlineUsers[p1].uid, p0.pic)

                p0.itemView.setOnClickListener {
                    startActivity(
                        Intent(context, MessageActivity::class.java)
                            .apply {
                                putExtra(FirebaseUtils.KEY_UID, onlineUsers[p1].uid)
                                putExtra(utils.constants.KEY_TARGET_TYPE, FirebaseUtils.KEY_CONVERSATION_SINGLE)
                                putExtra(utils.constants.KEY_NAME_OR_NUMBER, onlineUsers[p1].number)
                            })
                }
            }

        }


    }
}