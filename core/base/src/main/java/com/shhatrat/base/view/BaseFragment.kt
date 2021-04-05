package com.shhatrat.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.shhatrat.base.presenter.IPresenter

abstract class BaseFragment<PresenterType : IPresenter<ViewType>, ViewType : IView, ViewBindingChild : ViewBinding>
    : Fragment(),
    BaseAndroidView<PresenterType, ViewType, ViewBindingChild> {

    override var binding: ViewBindingChild? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = getInflatedView(inflater, container, false)

    override fun onDestroy() {
        super.onDestroy()
        detachFromPresenter()
        this.binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!presenter.isAttached()) {
            attachToPresenter()
        }
    }

    private fun getInflatedView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): View {
        val tempList = mutableListOf<ViewBindingChild>()
        attachBinding(tempList, inflater, container, attachToRoot)
        this.binding = tempList[0]
        return binding?.root
            ?: error("Please add your inflated binding class instance at 0th position in list")
    }

    abstract fun attachBinding(
        list: MutableList<ViewBindingChild>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    )
}