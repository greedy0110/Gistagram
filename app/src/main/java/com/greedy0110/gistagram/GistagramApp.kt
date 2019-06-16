package com.greedy0110.gistagram

import android.app.Application
import com.greedy0110.gistagram.data.GistagramAndroidScheduler
import com.greedy0110.gistagram.data.GistagramScheduler
import com.greedy0110.gistagram.data.GithubDataSource
import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.data.remote.GithubClient
import com.greedy0110.gistagram.data.source.GithubDemoSource
import com.greedy0110.gistagram.data.source.GithubRemoteSource
import com.greedy0110.gistagram.presentation.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
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
    // view model
    viewModel { UserViewModel(get()) }

    // data repository
    single { GithubClient() }
    single { GithubRepository(get(), get()) }

    // data source
    single { GithubRemoteSource(get()) as GithubDataSource }
//    single { GithubDemoSource() as GithubDataSource }
    factory { GistagramAndroidScheduler() as GistagramScheduler }
}