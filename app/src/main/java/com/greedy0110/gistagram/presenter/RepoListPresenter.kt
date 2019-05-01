package com.greedy0110.gistagram.presenter

import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.view.RepoListView

class RepoListPresenter(private val repository: GithubRepository) {
    private lateinit var view: RepoListView

    fun bind(view: RepoListView) {
        this.view = view
    }

    fun setUser(user: User) {
        view.setRepoList(repository.getRepoList(user))
    }
}