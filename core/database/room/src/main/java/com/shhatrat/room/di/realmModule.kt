package com.shhatrat.room.di

import com.shhatrat.database.IDatabaseManager
import com.shhatrat.room.DatabaseManager
import com.shhatrat.room.JokeDb
import org.koin.dsl.module

val roomModule = module {
    single<IDatabaseManager> {
        DatabaseManager(get())
    }
    single { JokeDb.getDatabase(get()) }
}