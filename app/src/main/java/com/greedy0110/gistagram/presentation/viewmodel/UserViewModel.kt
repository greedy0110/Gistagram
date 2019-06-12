package com.greedy0110.gistagram.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject

// LiveData to Observable? LiveData Testing?
class UserViewModel(private val repository: GithubRepository) : BaseViewModel() {
    private val _user = PublishSubject.create<User>() // 내부적으로는 next 로 값을 넘기는 것 가능
    private val _repoList = PublishSubject.create<List<Repo>>()
    private val _followerList = PublishSubject.create<List<User>>()
    private val _followingList = PublishSubject.create<List<User>>()

    val user: Observable<User> = _user // 외부적으로는 구독으로 값을 받는 것만 가능
    val repoList: Observable<List<Repo>> = _repoList
    val followerList: Observable<List<User>> = _followerList
    val followingList: Observable<List<User>> = _followingList

    fun setUser(user: User) {
        _user.onNext(user)

        repository.getRepoList(user).subscribe { it ->
            _repoList.onNext(it)
        }.apply { addDisposable(this) }

        repository.getFollowingList(user).subscribe { it ->
            _followingList.onNext(it)
        }.apply { addDisposable(this) }

        repository.getFollowersList(user).subscribe { it ->
            _followerList.onNext(it)
        }.apply { addDisposable(this) }
    }

    init {
        repository.getCurrentUser().subscribe { it ->
            setUser(it)
        }.apply { addDisposable(this) }
    }
}