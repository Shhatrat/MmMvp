package com.shhatrat.wear_manager.di

import com.shhatrat.wear_manager.IWearManager
import com.shhatrat.wear_manager.WearManagerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val wearManagerModule = module {
    single<IWearManager> {
        WearManagerImpl(androidContext())
    }
}