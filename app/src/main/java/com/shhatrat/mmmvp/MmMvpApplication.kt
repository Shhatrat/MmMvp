package com.shhatrat.mmmvp

import android.app.Application
import com.shhatrat.api.di.remoteManagerModule
import com.shhatrat.mmmvp.di.uiModule
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
            modules(listOf(uiModule, remoteManagerModule))
        }
    }
}