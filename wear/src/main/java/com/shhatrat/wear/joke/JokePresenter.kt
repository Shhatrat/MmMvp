package com.shhatrat.wear.joke

import android.util.Log
import com.shhatrat.base.presenter.BasePresenter
import com.shhatrat.wear_manager.IWearManager
import io.reactivex.rxjava3.kotlin.subscribeBy

class JokePresenter constructor(
    private val wearManager: IWearManager
) : BasePresenter<JokeContract.V, JokeNavigator>(), JokeContract.P {

    override fun observeJokes() {
        subscriptions.add(wearManager.observe().subscribeBy(
            onNext = { view?.showJoke(it) },
            onError = { Log.d("error", "error") }
        ))
    }
}