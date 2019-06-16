package com.greedy0110.gistagram.presentation.repo_list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.adapter.RepoListAdapter
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.presentation.BaseFragment
import com.greedy0110.gistagram.presentation.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RepoListFragment : BaseFragment() {

    private val userViewModel: UserViewModel by sharedViewModel()
    private lateinit var adapter: RepoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = RepoListAdapter(activity!!, listOf())
        rv_repo_list.adapter = adapter
        rv_repo_list.layoutManager = LinearLayoutManager(activity!!)

        userViewModel.repoList.subscribe {
            adapter.data = it
            adapter.notifyDataSetChanged()
        }.apply { addDisposable(this) }
    }
}
