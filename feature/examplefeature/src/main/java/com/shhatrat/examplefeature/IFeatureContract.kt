package com.shhatrat.examplefeature

import com.shhatrat.base.presenter.IPresenter
import com.shhatrat.base.useCase.view.NoInternetConnection
import com.shhatrat.base.view.IView
import com.shhatrat.model.Joke

interface IFeatureContract {
    interface V : IView {
        val noInternetConnection: NoInternetConnection
        fun showJoke(joke: Joke)
    }

    interface P : IPresenter<V> {
        fun saveRandom()
    }
}