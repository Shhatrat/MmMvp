package com.shhatrat.examplefeature

import com.shhatrat.base.presenter.IPresenter
import com.shhatrat.base.useCase.view.NoInternetConnection
import com.shhatrat.base.view.IView

interface IFeatureContract {
    interface V : IView {
        val noInternetConnection: NoInternetConnection
    }

    interface P : IPresenter<V, FeatureNavigator> {

        fun onButtonClicked()
    }
}