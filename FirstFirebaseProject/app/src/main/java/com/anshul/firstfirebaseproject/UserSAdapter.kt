package com.anshul.firstfirebaseproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anshul.firstfirebaseproject.databinding.UserItemsBinding

class UserSAdapter(
    var context: MainActivity,
    var userList: ArrayList<Users>
) : RecyclerView.Adapter<UserSAdapter.UserViewHolder>() {

    inner class UserViewHolder(val adapterBinding: UserItemsBinding): RecyclerView.ViewHolder(adapterBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val binding = UserItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.adapterBinding.textViewName.text = userList[position].name
        holder.adapterBinding.textViewAge.text = userList[position].age.toString()
        holder.adapterBinding.textViewEmail.text = userList[position].email

        holder.adapterBinding.linearlayout.setOnClickListener {

            val intent = Intent(context, UpdateUserActivity::class.java)
            intent.putExtra("id", userList[position].userId)
            intent.putExtra("name", userList[position].name)
            intent.putExtra("age", userList[position].age)
            intent.putExtra("email", userList[position].email)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun getUserId(position: Int): String {

        return userList[position].userId

    }


}

