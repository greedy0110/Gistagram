package com.greedy0110.gistagram.presenter

import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.view.MainView

class MainPresenter(private val repository: GithubRepository)
{
    private lateinit var view: MainView
    private lateinit var user: User

    fun bind(view: MainView) {
        this.view = view
    }

    fun onCreate() {
        user = repository.getCurrentUser()
        view.setUserInfo(user)
    }
}