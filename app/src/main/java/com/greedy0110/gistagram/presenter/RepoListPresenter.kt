package com.greedy0110.gistagram.presenter

import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.view.RepoListView

class RepoListPresenter(private val repository: GithubRepository): BasePresenter<RepoListView>() {
    fun setUser(user: User) {
        repository.getRepoList(user).subscribe {
            repoList ->
            view?.setRepoList(repoList)
        }.apply { addDisposable(this) }
    }
}