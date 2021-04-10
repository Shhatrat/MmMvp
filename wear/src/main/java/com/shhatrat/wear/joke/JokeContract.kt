package com.shhatrat.wear.joke

import com.shhatrat.base.presenter.IPresenter
import com.shhatrat.base.view.IView
import com.shhatrat.model.Joke

interface JokeContract {
    interface V : IView {
        fun showJoke(joke: Joke)
    }

    interface P : IPresenter<V> {
        fun observeJokes()
    }
}