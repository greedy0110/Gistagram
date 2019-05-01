package com.greedy0110.gistagram.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.adapter.UserListAdapter
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.presenter.UserListPresenter
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class UserListFragment : Fragment(), UserListView {

    // TODO
    private val presenter: UserListPresenter by inject{ parametersOf(UserListKind.Following)}
    lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.bind(this)
        // TODO here is the place where user object is passed
        presenter.setUser(user)
    }

    override fun setUserList(userList: List<User>) {
        rv_user_list.adapter = UserListAdapter(activity!!, userList)
        rv_user_list.layoutManager = LinearLayoutManager(activity!!)
    }
}
