package com.shhatrat.mmmvp

import android.app.Application
import com.shhatrat.mmmvp.di.ModuleConfig.getModuleListByInjectionType
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MmMvpApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDI()
    }

    private fun setupDI() {
        startKoin {
            androidContext(this@MmMvpApplication)
            modules(getModuleListByInjectionType())
        }
    }
}