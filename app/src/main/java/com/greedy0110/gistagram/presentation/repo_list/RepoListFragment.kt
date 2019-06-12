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
import com.greedy0110.gistagram.presentation.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RepoListFragment : Fragment() {

    private val userViewModel: UserViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userViewModel.repoList.subscribe {
            setRepoList(it)
        }
    }

    private fun setRepoList(repoList: List<Repo>) {
        rv_repo_list.adapter = RepoListAdapter(activity!!, repoList)
        rv_repo_list.layoutManager = LinearLayoutManager(activity!!)
    }
}
