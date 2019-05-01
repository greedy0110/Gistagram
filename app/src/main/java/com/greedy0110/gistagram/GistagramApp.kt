package com.greedy0110.gistagram

import android.app.Application
import com.greedy0110.gistagram.data.GithubDataSource
import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.data.remote.GithubClient
import com.greedy0110.gistagram.data.source.GithubDemoSource
import com.greedy0110.gistagram.data.source.GithubRemoteSource
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.presenter.MainPresenter
import com.greedy0110.gistagram.presenter.RepoListPresenter
import com.greedy0110.gistagram.presenter.UserListPresenter
import com.greedy0110.gistagram.view.UserListKind
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class GistagramApp: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GistagramApp)
            modules(gistagramDemoModule)
        }
    }
}

val gistagramDemoModule = module {
    // presenter
    factory { UserListPresenter(get()) }
    factory { RepoListPresenter(get()) }
    factory { MainPresenter(get()) }

    // data repository
    single { GithubClient() }
    single { GithubRepository(get()) }

    // data source
    single { GithubRemoteSource(get()) as GithubDataSource }
//    single { GithubDemoSource() as GithubDataSource }
}