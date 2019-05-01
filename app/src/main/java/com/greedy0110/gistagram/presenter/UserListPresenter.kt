package com.greedy0110.gistagram.presenter

import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.view.UserListKind
import com.greedy0110.gistagram.view.UserListView

class UserListPresenter(private val repository: GithubRepository): BasePresenter<UserListView>() {
    fun setUser(user: User, kind: UserListKind) {
        when(kind) {
            UserListKind.Follower -> {
                repository.getFollowersList(user).subscribe {
                    userList ->
                    view?.setUserList(userList)
                }.apply { addDisposable(this) }
            }
            UserListKind.Following -> {
                repository.getFollowingList(user).subscribe {
                        userList ->
                    view?.setUserList(userList)
                }.apply { addDisposable(this) }
            }
        }
    }
}