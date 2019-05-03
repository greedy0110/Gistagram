package com.greedy0110.gistagram.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(dis: Disposable) {compositeDisposable.add(dis)}

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}