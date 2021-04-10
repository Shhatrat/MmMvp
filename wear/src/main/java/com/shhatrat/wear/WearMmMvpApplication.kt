package com.shhatrat.wear

import android.app.Application
import com.shhatrat.wear.di.ModuleConfig.getModuleListByInjectionType
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class WearMmMvpApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDI()
    }

    private fun setupDI() {
        startKoin {
            androidContext(this@WearMmMvpApplication)
            modules(getModuleListByInjectionType())
        }
    }
}