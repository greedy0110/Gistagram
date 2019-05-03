package com.greedy0110.gistagram.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import io.reactivex.functions.Consumer

class UserViewModel(private val repository: GithubRepository) : BaseViewModel() {
    private val _user = MutableLiveData<User>()
    private val _repoList = MutableLiveData<List<Repo>>()
    private val _followerList = MutableLiveData<List<User>>()
    private val _followingList = MutableLiveData<List<User>>()

    val user: LiveData<User> = _user
    val repoList: LiveData<List<Repo>> = _repoList
    val followerList: LiveData<List<User>> = _followerList
    val followingList: LiveData<List<User>> = _followingList

    fun setUser(user: User) {
        _user.value = user

        repository.getRepoList(user).subscribe(Consumer {
            _repoList.value = it
        }).apply { addDisposable(this) }

        repository.getFollowingList(user).subscribe(Consumer {
            _followingList.value = it
        }).apply { addDisposable(this) }

        repository.getFollowersList(user).subscribe(Consumer {
            _followerList.value = it
        }).apply { addDisposable(this) }
    }

    init {
        repository.getCurrentUser().subscribe(Consumer {
            setUser(it)
        }).apply { addDisposable(this) }
    }
}