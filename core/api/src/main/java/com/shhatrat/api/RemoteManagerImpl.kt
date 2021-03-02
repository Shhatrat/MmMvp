package com.shhatrat.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

class RemoteManagerImpl
constructor(private val service: Service) : IRemoteManager {

    interface Service {
        companion object {
            internal const val URL = "http://api.icndb.com/jokes/"
        }

        @GET("random")
        fun getRandomJoke(
        ): Single<String>
    }

    override fun getRandomJoke(): Single<String> {
        return service.getRandomJoke()
    }
}