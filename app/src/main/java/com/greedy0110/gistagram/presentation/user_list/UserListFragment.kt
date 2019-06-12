package com.greedy0110.gistagram.presentation.user_list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.adapter.UserListAdapter
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.ext.UserListKind
import com.greedy0110.gistagram.presentation.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserListFragment(private val kind: UserListKind) : Fragment() {

    private val userViewModel: UserViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        when(kind) {
            UserListKind.Follower -> userViewModel.followerList.subscribe {
                setUserList(it)
            }

            UserListKind.Following -> userViewModel.followingList.subscribe {
                setUserList(it)
            }
        }
    }

    private fun setUserList(userList: List<User>) {
        rv_user_list.adapter = UserListAdapter(activity!!, userList)
        rv_user_list.layoutManager = LinearLayoutManager(activity!!)
    }
}
