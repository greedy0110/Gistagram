package com.greedy0110.gistagram.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<View> {
    protected val compositeDisposable = CompositeDisposable()
    protected var view: View? = null

    fun bind(view: View) {
        this.view = view
    }

    fun unbind() {
        compositeDisposable.dispose()
        this.view = null
    }

    protected fun addDisposable(dis: Disposable) {
        compositeDisposable.add(dis)
    }
}