package com.greedy0110.gistagram.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.presentation.repo_list.RepoListFragment
import com.greedy0110.gistagram.presentation.user_list.UserListFragment
import com.greedy0110.gistagram.ext.UserListKind

class UserDetailViewPagerAdapter(fm: FragmentManager, private val user: User): FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        return when(position) {
            0 -> RepoListFragment()
            1 -> UserListFragment(UserListKind.Follower)
            2 -> UserListFragment(UserListKind.Following)
            else -> null
        }
    }

    override fun getCount(): Int = 3
}