package com.shhatrat.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.rxjava3.RxDataStore
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

abstract class BaseDataStoreManagerImpl constructor(private val context: Context) {

    abstract val Context.myRxDataStore: RxDataStore<Preferences>

    fun <T> load(key: Preferences.Key<T>) = context.myRxDataStore.data().map { it[key] }

    fun <T> save(value: T, key: Preferences.Key<T>) =
        Completable.fromSingle(context.myRxDataStore.updateDataAsync {
            Single.just(it.toPreferences()
                .toMutablePreferences()
                .apply { set(key, value) }
                .toPreferences())
        })
}