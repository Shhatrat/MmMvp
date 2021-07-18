package com.shhatrat.datastore.action

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.rxjava3.RxDataStore
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

class DataStoreActionImpl<T>(
    private val rxDataStore: RxDataStore<Preferences>,
    private val key: Preferences.Key<T>
) : DataStoreAction<T> {

    override fun getValue(): Flowable<T?> = rxDataStore.data().map { it[key] }

    override fun saveValue(value: T) =
        Completable.fromSingle(rxDataStore.updateDataAsync {
            Single.just(it.toPreferences()
                .toMutablePreferences()
                .apply { set(key, value) }
                .toPreferences())
        })
}