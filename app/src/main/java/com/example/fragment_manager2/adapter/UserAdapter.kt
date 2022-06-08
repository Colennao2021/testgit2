package com.example.fragment_manager2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_manager2.data.User
import com.example.fragment_manager2.fragment.HomeFragmentDirections
import com.example.fragment_manager2.myinterface.PostClickHandler
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(
    //te
    private val clickHandler: PostClickHandler
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listData: ArrayList<User> = ArrayList()

    public fun setData(listData: ArrayList<User>) {
        this.listData = listData
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val user =listData.get(position)
            holder.bindingData(user)
            holder.itemView.setOnClickListener {
                clickHandler.clickedPostItem(user)
            }
        }
    }


    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(com.example.fragment_manager2.R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val username: TextView = itemView.txt_userName

        fun bindingData(user: User) {
            username.text = user.username
        }
    }
}