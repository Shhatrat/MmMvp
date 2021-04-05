package com.shhatrat.di

import com.shhatrat.database.IDatabaseManager
import com.shhatrat.realm.DatabaseManager
import com.shhatrat.realm.InitRealmManager
import org.koin.dsl.module

val realmModule = module {
    single<IDatabaseManager> {
        InitRealmManager(get()).init()
        DatabaseManager()
    }
}