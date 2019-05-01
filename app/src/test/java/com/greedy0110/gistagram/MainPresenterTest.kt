package com.greedy0110.gistagram

import com.greedy0110.gistagram.data.GithubDataSource
import com.greedy0110.gistagram.data.GithubRepository
import com.greedy0110.gistagram.data.source.GithubDemoSource
import com.greedy0110.gistagram.presenter.MainPresenter
import com.greedy0110.gistagram.view.MainView
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainPresenterTest{
    @Before
    fun setup() {
        startKoin {
            module {
                single { GithubDemoSource() as GithubDataSource }
                single { GithubRepository(get()) }
                single { MainPresenter(get(), get()) }
                single { object : MainView { // if i use mock framework, than i could write it more easier.

                } }
            }
        }
    }

    @Test
    fun testOnCreate() {

    }
}