package com.shhatrat.datastore

import org.koin.dsl.module

val dataStoreManager = module {
    single<DataStoreManager> {
        DataStoreManagerImpl(get())
    }
}