package com.greedy0110.gistagram.view

import com.greedy0110.gistagram.entity.Repo

interface RepoListView {
    // require update repo list view
    fun setRepoList(repoList: List<Repo>)
}