package com.greedy0110.gistagram.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.adapter.RepoListAdapter
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.presenter.RepoListPresenter
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

class RepoListFragment : Fragment(), RepoListView {

    private val presenter: RepoListPresenter by inject()
    lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo_list, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.bind(this)

        // TODO here is the place where user object is passed
        presenter.setUser(user)
    }

    override fun setRepoList(repoList: List<Repo>) {
        rv_repo_list.adapter = RepoListAdapter(activity!!, repoList)
        rv_repo_list.layoutManager = LinearLayoutManager(activity!!)
    }
}
