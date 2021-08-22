package com.shhatrat.base.view

import android.content.ComponentCallbacks
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.shhatrat.base.navigator.Navigator
import com.shhatrat.base.presenter.ComponentType
import com.shhatrat.base.presenter.IPresenter
import org.koin.android.ext.android.get
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

abstract class BaseFragment<PresenterType : IPresenter<ViewType, Navi>,
        ViewType : IView,
        ViewBindingChild : ViewBinding,
        Navi : Navigator>
    : Fragment(),
    BaseAndroidView<PresenterType, ViewType, ViewBindingChild, Navi> {

    override var binding: ViewBindingChild? = null

    override val componentType = ComponentType.FRAGMENT

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = getInflatedView(inflater, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!presenter.isAttached()) {
            attachToPresenter()
        }
        invokeStateOnCreate()
    }

    override fun onStart() {
        super.onStart()
        invokeStateOnStart()
    }

    override fun onPause() {
        super.onPause()
        invokeStateOnPause()
    }

    override fun onStop() {
        super.onStop()
        invokeStateOnStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        invokeStateOnDestroy()
        detachFromPresenter()
        this.binding = null
    }

    override fun onViewAttached() {}

    private fun getInflatedView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): View {
        this.binding = attachBinding(inflater, container, attachToRoot)
        return binding?.root
            ?: error("Please add your inflated binding class instance at 0th position in list")
    }

    abstract fun attachBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): ViewBindingChild

    inline fun <reified T : Any> ComponentCallbacks.injectNavigator(
        qualifier: Qualifier? = null,
        mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED,
        noinline parameters: ParametersDefinition? = { parametersOf(findNavController()) }
    ) = lazy(mode) { get<T>(qualifier, parameters) }
}