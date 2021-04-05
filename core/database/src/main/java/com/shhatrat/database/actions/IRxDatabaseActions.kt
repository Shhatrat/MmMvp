package com.shhatrat.database.actions

import io.reactivex.rxjava3.core.Observable
import kotlin.reflect.KClass

interface IRxDatabaseActions<C> {

    fun observeAll(realmClass: KClass<out Any>): Observable<List<C>>

    fun observe(realmClass: KClass<out Any>, id: Any): Observable<C>
}