package com.shhatrat.cpp.di

import com.shhatrat.cpp.CppManagerImpl
import com.shhatrat.cpp.ICppManager
import org.koin.dsl.module

val cppModule = module {
    single<ICppManager> { CppManagerImpl() }
}