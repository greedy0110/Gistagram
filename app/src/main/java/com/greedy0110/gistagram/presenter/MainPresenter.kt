package com.greedy0110.gistagram.presenter

import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.view.MainView

class MainPresenter(private val repository: GithubRepository): BasePresenter<MainView>()
{
    fun onCreate() {
        repository.getCurrentUser().subscribe {
            user ->
            view?.setUserInfo(user)
        }.apply { addDisposable(this) }
    }
}