package com.shhatrat.base.view

import android.app.Activity
import android.content.Context
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.shhatrat.base.navigator.Navigator
import com.shhatrat.base.presenter.IPresenter

interface BaseAndroidView<
        PresenterType : IPresenter<ViewType, Navi>, ViewType : IView,
        ViewBindingChild : ViewBinding,
        Navi : Navigator> {

    val navigator: Navi

    val presenter: PresenterType

    var binding: ViewBindingChild?

    fun getActivity(): Activity?

    fun getContext(): Context?

    @LayoutRes
    fun getLayoutResId(): Int

    fun getMvpView(): ViewType

    fun onViewAttached()

    fun attachToPresenter() = getMvpView().let { presenter.attachView(it, navigator) }

    fun detachFromPresenter() = presenter.detachView()

    fun withBinding(block: (ViewBindingChild.() -> Unit)?): ViewBindingChild {
        val bindingAfterRunning: ViewBindingChild? = binding?.apply { block?.invoke(this) }
        return bindingAfterRunning
            ?: error("Accessing binding outside of lifecycle: ${this::class.java.simpleName}")
    }
}