package com.shhatrat.wear.di

import com.shhatrat.wear.BuildConfig
import com.shhatrat.wear_manager.di.wearManagerModule
import org.koin.core.module.Module

object ModuleConfig {

    private fun getApiModuleLists() =
        listOf(wearManagerModule, wearModule)

    private fun getTestModuleLists() =
        listOf(wearManagerModule, wearModule)

    fun getModuleListByInjectionType(): List<Module> {
        return when (BuildConfig.INJECTION_TYPE) {
            "API" -> getApiModuleLists()
            "TEST" -> getTestModuleLists()
            else -> throw Exception("No modules for ${BuildConfig.INJECTION_TYPE} flavor")
        }
    }
}