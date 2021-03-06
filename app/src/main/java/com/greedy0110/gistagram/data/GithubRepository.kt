package com.greedy0110.gistagram.data

import android.util.Log
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubRepository(
    private val source: GithubDataSource,
    private val scheduler: GistagramScheduler
) {
    fun getCurrentUser(): Single<User>
            = source.getCurrentUser()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnError { t -> Log.e("seungmin", "get user error : ${t.message}") }
    fun getRepoList(user: User): Single<List<Repo>>
            = source.getRepoList(user)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnError { t -> Log.e("seungmin", "get $user repos error : ${t.message}") }
    fun getFollowingList(user: User): Single<List<User>>
            = source.getFollowingList(user)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnError { t -> Log.e("seungmin", "get following error : ${t.message}") }
    fun getFollowersList(user: User): Single<List<User>>
            = source.getFollowersList(user)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnError { t -> Log.e("seungmin", "get follwer error : ${t.message}") }
}