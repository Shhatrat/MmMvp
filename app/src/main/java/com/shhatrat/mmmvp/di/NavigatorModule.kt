package com.shhatrat.mmmvp.di

import com.shhatrat.base.navigator.ExitNavigator
import com.shhatrat.examplefeature.FeatureNavigator
import com.shhatrat.mmmvp.navigation.ExitNavigatorImpl
import com.shhatrat.mmmvp.navigation.FeatureNavigatorImpl
import org.koin.dsl.module

val navigatorModule = module {
    single<ExitNavigator> { ExitNavigatorImpl() }
    single<FeatureNavigator> { params -> FeatureNavigatorImpl(params[0], get()) }
}