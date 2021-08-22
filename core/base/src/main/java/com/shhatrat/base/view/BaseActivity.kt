package com.shhatrat.base.view

import android.app.Activity
import android.content.ComponentCallbacks
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.shhatrat.base.navigator.Navigator
import com.shhatrat.base.presenter.ComponentType
import com.shhatrat.base.presenter.IPresenter
import com.shhatrat.base.presenter.PresenterState
import org.koin.android.ext.android.get
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

abstract class BaseActivity<PresenterType : IPresenter<ViewType, Navi>,
        ViewType : IView,
        ViewBindingChild : ViewBinding,
        Navi : Navigator>
    : AppCompatActivity(),
    BaseAndroidView<PresenterType, ViewType, ViewBindingChild, Navi> {

    override var binding: ViewBindingChild? = null

    override val componentType = ComponentType.ACTIVITY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflatedLayout(layoutInflater))
        onViewAttached()
        if (!presenter.isAttached()) {
            attachToPresenter()
        }
        invokeStateOnCreate()
    }

    override fun onStart() {
        super.onStart()
        invokeStateOnStart()
    }

    override fun onResume() {
        super.onResume()
        invokeStateOnResume()
    }

    override fun onStop() {
        super.onStop()
        invokeStateOnStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        invokeStateOnDestroy()
        detachFromPresenter()
        binding = null
    }

    inline fun <reified T : Any> ComponentCallbacks.injectContext(
        qualifier: Qualifier? = null,
        mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED,
        noinline parameters: ParametersDefinition? = { parametersOf(this) }
    ) = lazy(mode) { get<T>(qualifier, parameters) }

    override fun getActivity(): Activity? = this

    override fun getContext(): Context? = this

    override fun onViewAttached() {}

    private fun getInflatedLayout(inflater: LayoutInflater): View {
        val tempList = mutableListOf<ViewBindingChild>()
        tempList.add(attachViewBinding(inflater))
        this.binding = tempList[0]
        return binding?.root
            ?: error("Please add your inflated binding class instance at 0th position in list")
    }

    abstract fun attachViewBinding(layoutInflater: LayoutInflater): ViewBindingChild
}