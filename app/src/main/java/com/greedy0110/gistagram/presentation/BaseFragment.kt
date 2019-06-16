package com.greedy0110.gistagram.presentation

import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment: Fragment() {
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(dis: Disposable) {
        compositeDisposable.add(dis)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}