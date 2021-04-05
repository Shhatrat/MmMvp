package com.shhatrat.base.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.shhatrat.base.navigator.Navigator
import com.shhatrat.base.presenter.IPresenter

abstract class BaseActivity<PresenterType : IPresenter<ViewType>, ViewType : IView,
        ViewBindingChild : ViewBinding,
        Navi : Navigator>
    : AppCompatActivity(),
    BaseAndroidView<PresenterType, ViewType, ViewBindingChild, Navi> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflatedLayout(layoutInflater))
    }

    override fun onStart() {
        super.onStart()
        if (!presenter.isAttached()) {
            attachToPresenter()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        detachFromPresenter()
        binding = null
    }

    override fun getActivity(): Activity? = this

    override fun getContext(): Context? = this

    override var binding: ViewBindingChild? = null

    private fun getInflatedLayout(inflater: LayoutInflater): View {
        val tempList = mutableListOf<ViewBindingChild>()
        tempList.add(attachViewBinding(inflater))
        this.binding = tempList[0]
        return binding?.root
            ?: error("Please add your inflated binding class instance at 0th position in list")
    }

    abstract fun attachViewBinding(layoutInflater: LayoutInflater): ViewBindingChild
}