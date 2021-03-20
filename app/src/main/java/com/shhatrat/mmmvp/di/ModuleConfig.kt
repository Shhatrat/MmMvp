package com.shhatrat.mmmvp.di

import com.shhatrat.api.di.apiModule
import com.shhatrat.api.di.mockApiModule
import com.shhatrat.base.BuildConfig
import com.shhatrat.di.realmModule
import com.shhatrat.examplefeature.di.featureModule
import org.koin.core.module.Module

object ModuleConfig {

    private fun getApiModuleLists() = listOf(apiModule, realmModule, featureModule)

    private fun getTestModuleLists() = listOf(mockApiModule, realmModule, featureModule)

    fun getModuleListByInjectionType(): List<Module> {
        return when (BuildConfig.INJECTION_TYPE) {
            "API" -> getApiModuleLists()
            "TEST" -> getTestModuleLists()
            else -> throw Exception("No modules for ${BuildConfig.INJECTION_TYPE} flavor")
        }
    }
}