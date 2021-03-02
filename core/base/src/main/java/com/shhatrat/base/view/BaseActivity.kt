package com.shhatrat.base.view

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.shhatrat.base.presenter.IPresenter

abstract class BaseActivity<PresenterType : IPresenter<ViewType>, ViewType : IView>
    : AppCompatActivity(),
    BaseAndroidView<PresenterType, ViewType> {


    override fun onStart() {
        super.onStart()
        if (!presenter.isAttached()) {
            attachToPresenter()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        detachFromPresenter()
    }

    override fun getActivity(): Activity? = this

    override fun getContext(): Context? = this

}