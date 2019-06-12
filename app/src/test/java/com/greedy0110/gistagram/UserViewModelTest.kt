package com.greedy0110.gistagram

import com.greedy0110.gistagram.data.GistagramScheduler
import com.greedy0110.gistagram.data.GithubDataSource
import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.presentation.viewmodel.UserViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class UserViewModelTest {
    private lateinit var viewModel: UserViewModel
    private lateinit var repository: GithubRepository
    private lateinit var dataSource: GithubDataSource
    private lateinit var scheduler: GistagramScheduler
    private lateinit var user: User

    @Before
    fun setup(){
        user = User("","","")

        scheduler = object : GistagramScheduler {
            override fun io(): Scheduler = Schedulers.trampoline()
            override fun compute(): Scheduler = Schedulers.trampoline()
            override fun ui(): Scheduler = Schedulers.trampoline()
        }

        dataSource = object : GithubDataSource {
            override fun getCurrentUser(): Single<User> {
                return Single.just(user)
            }

            override fun getRepoList(user: User): Single<List<Repo>> {
                return Single.just(listOf())
            }

            override fun getFollowersList(user: User): Single<List<User>> {
                return Single.just(listOf())
            }

            override fun getFollowingList(user: User): Single<List<User>> {
                return Single.just(listOf())
            }
        }

        repository = GithubRepository(source = dataSource, scheduler = scheduler)

        viewModel = UserViewModel(repository = repository)
    }

    @Test
    fun setUserThenRefreshRepoList(){
        viewModel.setUser(user)

        repository.getRepoList(user).subscribe { list ->
            assertEquals(listOf<Repo>(), list)
        }
    }
}