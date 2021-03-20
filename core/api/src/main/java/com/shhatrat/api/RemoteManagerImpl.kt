package com.shhatrat.api

import com.shhatrat.api.data.ResponseWrapper
import com.shhatrat.model.Joke
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
        ): Single<ResponseWrapper<Joke>>
    }

    override fun getRandomJoke(): Single<Joke> {
        return service.getRandomJoke().map { it.value }
    }
}