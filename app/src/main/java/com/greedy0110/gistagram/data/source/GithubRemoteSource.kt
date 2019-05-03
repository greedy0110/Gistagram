package com.greedy0110.gistagram.data.source

import com.greedy0110.gistagram.data.GithubDataSource
import com.greedy0110.gistagram.data.remote.GithubClient
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import io.reactivex.Single

class GithubRemoteSource(private val client: GithubClient): GithubDataSource {
    override fun getCurrentUser(): Single<User> = client.getApi().getUser("omjoonkim")
    override fun getRepoList(user: User): Single<List<Repo>> = client.getApi().getRepos(user.login)
    override fun getFollowersList(user: User): Single<List<User>> = client.getApi().getFollowers(user.login)
    override fun getFollowingList(user: User): Single<List<User>> = client.getApi().getFollowing(user.login)
}