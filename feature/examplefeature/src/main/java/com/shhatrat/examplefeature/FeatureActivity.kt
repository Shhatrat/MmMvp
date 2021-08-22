package com.shhatrat.examplefeature

import android.view.LayoutInflater
import com.shhatrat.base.useCase.view.NoInternetConnection
import com.shhatrat.base.useCase.view.NoInternetConnectionImpl
import com.shhatrat.base.view.BaseActivity
import com.shhatrat.examplefeature.databinding.ActivityFeatureBinding
import org.koin.android.ext.android.inject

class FeatureActivity :
    BaseActivity<IFeatureContract.P, IFeatureContract.V, ActivityFeatureBinding, FeatureNavigator>(),
    IFeatureContract.V {

    override val noInternetConnection: NoInternetConnection by lazy {
        NoInternetConnectionImpl(getContext())
    }

    override val navigator: FeatureNavigator by injectContext()

    override val presenter: IFeatureContract.P by inject()

    override fun getLayoutResId(): Int = R.layout.activity_feature

    override fun getMvpView(): IFeatureContract.V = this

    override fun attachViewBinding(layoutInflater: LayoutInflater) =
        ActivityFeatureBinding.inflate(layoutInflater)

    override fun onViewAttached() {
        withBinding {
            button.setOnClickListener { presenter.onButtonClicked() }
        }
    }
}