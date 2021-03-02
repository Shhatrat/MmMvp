package com.shhatrat.api

import io.reactivex.rxjava3.core.Single

class MockRemoteManager : IRemoteManager {

    override fun getRandomJoke(): Single<String> = Single.just("XD")
}