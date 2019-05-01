package com.greedy0110.gistagram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.entity.Repo
import kotlinx.android.synthetic.main.rv_item_repo.view.*

class RepoListAdapter(private val ctx: Context, var data: List<Repo>): RecyclerView.Adapter<RepoListAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_repo, parent, false)
        return Holder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val d = data[position]

        with(holder) {
            txt_name.text = d.name
            txt_desc.text = d.description
        }
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.cl_rv_item_repo_container)
        val txt_name:TextView = view.findViewById(R.id.txt_rv_item_repo_name)
        val txt_desc:TextView = view.findViewById(R.id.txt_rv_item_repo_desc)
    }
}