package com.shhatrat.base.presenter

import com.shhatrat.base.navigator.Navigator
import com.shhatrat.base.view.IView

interface IPresenter<ViewType : IView, NavigatorType : Navigator> {

    fun attachView(view: ViewType, navigator: NavigatorType)

    fun detachView()

    fun isAttached(): Boolean

    fun onViewPrepared()

    fun onResume() {}

    fun onPause() {}
}