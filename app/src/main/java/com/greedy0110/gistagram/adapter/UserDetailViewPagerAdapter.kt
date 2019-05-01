package com.greedy0110.gistagram.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.view.RepoListFragment
import com.greedy0110.gistagram.view.UserListFragment

class UserDetailViewPagerAdapter(fm: FragmentManager, private val user: User): FragmentStatePagerAdapter(fm) {
    // TODO how can i pass "user object" into these fragments?
    override fun getItem(position: Int): Fragment? {
        return when(position) {
            0 -> RepoListFragment().apply { this.user = this@UserDetailViewPagerAdapter.user }
            1 -> UserListFragment().apply { this.user = this@UserDetailViewPagerAdapter.user }
            2 -> UserListFragment().apply { this.user = this@UserDetailViewPagerAdapter.user }
            else -> null
        }
    }

    override fun getCount(): Int = 3
}