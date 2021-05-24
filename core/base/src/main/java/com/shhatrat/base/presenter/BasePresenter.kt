package com.shhatrat.base.presenter

import com.shhatrat.base.navigator.Navigator
import com.shhatrat.base.view.IView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BasePresenter<ViewType : IView, NavigatorType : Navigator> :
    IPresenter<ViewType, NavigatorType> {

    val subscriptions = CompositeDisposable()

    var view: ViewType? = null

    var navigator: NavigatorType? = null

    override fun attachView(view: ViewType, navigator: NavigatorType) {
        this.view = view
        this.navigator = navigator
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