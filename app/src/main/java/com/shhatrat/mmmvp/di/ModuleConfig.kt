package com.shhatrat.mmmvp.di

import com.shhatrat.api.di.apiModule
import com.shhatrat.api.di.mockApiModule
import com.shhatrat.cpp.di.cppModule
import com.shhatrat.datastore.dataStoreManager
import com.shhatrat.di.realmModule
import com.shhatrat.examplefeature.di.featureModule
import com.shhatrat.mmmvp.BuildConfig
import com.shhatrat.room.di.roomModule
import com.shhatrat.wear_manager.di.wearManagerModule
import org.koin.core.module.Module

object ModuleConfig {

    private fun getApiModuleLists() =
        listOf(apiModule, featureModule, roomModule, navigatorModule, cppModule, wearManagerModule, dataStoreManager)

    private fun getTestModuleLists() =
        listOf(mockApiModule, realmModule, featureModule, navigatorModule, cppModule, wearManagerModule, dataStoreManager)

    fun getModuleListByInjectionType(): List<Module> {
        return when (BuildConfig.INJECTION_TYPE) {
            "API" -> getApiModuleLists()
            "TEST" -> getTestModuleLists()
            else -> throw Exception("No modules for ${BuildConfig.INJECTION_TYPE} flavor")
        }
    }
}