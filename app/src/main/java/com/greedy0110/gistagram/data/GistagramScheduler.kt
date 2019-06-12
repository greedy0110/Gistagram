package com.greedy0110.gistagram.data

import io.reactivex.Scheduler

interface GistagramScheduler {
    fun io(): Scheduler
    fun compute(): Scheduler
    fun ui(): Scheduler
}