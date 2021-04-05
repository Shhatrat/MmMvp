package com.shhatrat.database

import io.reactivex.rxjava3.core.Observable
import kotlin.reflect.KClass

interface IRxDatabaseActions<Convertable> {

    fun observeAll(realmClass: KClass<out Any>): Observable<List<Convertable>>

    fun observe(realmClass: KClass<out Any>, id: Any): Observable<Convertable>
}