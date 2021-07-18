package com.shhatrat.datastore.action

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface DataStoreAction<T> {

    fun getValue(): Flowable<T?>

    fun saveValue(value: T): Completable
}