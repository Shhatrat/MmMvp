package com.shhatrat.api

import io.reactivex.rxjava3.core.Single

interface IRemoteManager {

    fun getRandomJoke(): Single<String>
}