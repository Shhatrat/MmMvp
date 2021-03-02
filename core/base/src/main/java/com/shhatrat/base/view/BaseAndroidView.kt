package com.shhatrat.base.view

import android.app.Activity
import android.content.Context
import androidx.annotation.LayoutRes
import com.shhatrat.base.presenter.IPresenter

interface BaseAndroidView<PresenterType : IPresenter<ViewType>, ViewType : IView> {

    fun getActivity(): Activity?

    fun getContext(): Context?

    @LayoutRes
    fun getLayoutResId(): Int

    val presenter: PresenterType

    fun getMvpView(): ViewType

    fun attachToPresenter() = getMvpView().let { presenter.attachView(it) }

    fun detachFromPresenter() = presenter.detachView()


}