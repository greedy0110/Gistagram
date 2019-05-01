package com.greedy0110.gistagram.data

import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User

interface GithubDataSource {
    fun getCurrentUser(): User
    fun getRepoList(user: User): List<Repo>
    fun getFollowersList(user: User): List<User>
    fun getFollowingList(user: User): List<User>
}