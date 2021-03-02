package com.shhatrat.base.presenter

import com.shhatrat.base.view.IView

interface IPresenter<ViewType : IView> {

    fun attachView(view: ViewType)

    fun detachView()

    fun isAttached(): Boolean

    fun onViewPrepared()

    fun onResume() {}

    fun onPause() {}
}