package com.shhatrat.wear.di

import com.shhatrat.wear.joke.JokeContract
import com.shhatrat.wear.joke.JokePresenter
import org.koin.dsl.module

val wearModule = module {
    factory<JokeContract.P> { JokePresenter(get()) }
}