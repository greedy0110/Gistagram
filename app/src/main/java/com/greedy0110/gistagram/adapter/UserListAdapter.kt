package com.greedy0110.gistagram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.entity.User

class UserListAdapter(private val ctx: Context, var data: List<User>): RecyclerView.Adapter<UserListAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_user, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val d = data[position]

        with(holder) {
            Glide.with(ctx)
                .load(d.avatar_url)
                .into(img_avatar)
            txt_name.text = d.name
            txt_nickname.text = d.login
            txt_bio.text = d.bio
            // TODO add follow, unfollow feature in btn_follow
        }
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.cl_rv_item_user_container)
        val img_avatar: ImageView = view.findViewById(R.id.img_rv_item_user_avatar)
        val txt_name: TextView = view.findViewById(R.id.txt_rv_item_user_name)
        val txt_nickname: TextView = view.findViewById(R.id.txt_rv_item_user_nickname)
        val txt_bio: TextView = view.findViewById(R.id.txt_rv_item_user_bio)
        val btn_follow: Button = view.findViewById(R.id.btn_rv_item_user_follow)
    }
}