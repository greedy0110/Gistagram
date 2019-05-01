package com.greedy0110.gistagram.data

import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import io.reactivex.Single

interface GithubDataSource {
    fun getCurrentUser(): Single<User>
    fun getRepoList(user: User): Single<List<Repo>>
    fun getFollowersList(user: User): Single<List<User>>
    fun getFollowingList(user: User): Single<List<User>>
}