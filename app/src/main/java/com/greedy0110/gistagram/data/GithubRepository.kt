package com.greedy0110.gistagram.data

import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User

class GithubRepository(private val source: GithubDataSource) {
    fun getCurrentUser(): User = source.getCurrentUser()
    fun getRepoList(user: User): List<Repo> = source.getRepoList(user)
    fun getFollowingList(user: User): List<User> = source.getFollowingList(user)
    fun getFollowersList(user: User): List<User> = source.getFollowersList(user)
}