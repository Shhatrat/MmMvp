package com.shhatrat.api

import com.shhatrat.model.Joke
import io.reactivex.rxjava3.core.Single

interface IRemoteManager {

    fun getRandomJoke(): Single<Joke>
}