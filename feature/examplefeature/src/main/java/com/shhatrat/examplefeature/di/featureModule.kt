package com.shhatrat.examplefeature.di

import com.shhatrat.examplefeature.FeaturePresenter
import com.shhatrat.examplefeature.IFeatureContract
import org.koin.dsl.module

val featureModule = module {
    factory<IFeatureContract.P> { FeaturePresenter(get()) }
}