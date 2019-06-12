package com.greedy0110.gistagram.data

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GistagramAndroidScheduler : GistagramScheduler {
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun compute(): Scheduler {
        return Schedulers.computation()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}