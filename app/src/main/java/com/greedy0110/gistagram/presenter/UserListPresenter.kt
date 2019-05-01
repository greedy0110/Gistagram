package com.greedy0110.gistagram.presenter

import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.view.UserListKind
import com.greedy0110.gistagram.view.UserListView

class UserListPresenter(private val repository: GithubRepository, private val kind: UserListKind) {
    private lateinit var view: UserListView

    fun bind(view: UserListView) {
        this.view = view
    }

    fun setUser(user: User) {
        when(kind) {
            UserListKind.Follower -> view.setUserList(repository.getFollowersList(user))
            UserListKind.Following -> view.setUserList(repository.getFollowingList(user))
        }
    }
}