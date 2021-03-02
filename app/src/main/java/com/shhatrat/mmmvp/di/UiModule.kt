package com.shhatrat.mmmvp.di

import com.shhatrat.mmmvp.example.ExamplePresenterImpl
import com.shhatrat.mmmvp.example.IExampleContract
//import com.shhatrat.mmmvp.example.IExamplePresenter
import org.koin.dsl.module

val uiModule = module {
    factory<IExampleContract.P> { ExamplePresenterImpl() }
}