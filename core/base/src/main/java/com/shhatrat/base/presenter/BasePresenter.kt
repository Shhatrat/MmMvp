package com.shhatrat.base.presenter

import com.shhatrat.base.view.IView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BasePresenter<ViewType : IView> : IPresenter<ViewType> {

    val subscriptions = CompositeDisposable()

    var view: ViewType? = null

    override fun attachView(view: ViewType) {
        this.view = view
        subscriptions.clear()
    }

    override fun detachView() {
        view = null
        subscriptions.clear()
    }

    override fun onViewPrepared() {}

    override fun isAttached(): Boolean = view != null

    fun Disposable.add(compositeDisposable: CompositeDisposable): Disposable =
        apply { compositeDisposable.add(this) }
}