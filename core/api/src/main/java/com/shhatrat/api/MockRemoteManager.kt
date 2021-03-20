package com.shhatrat.api

import com.shhatrat.model.Joke
import io.reactivex.rxjava3.core.Single

class MockRemoteManager : IRemoteManager {

    override fun getRandomJoke(): Single<Joke> = Single.just(Joke.getMock())
}