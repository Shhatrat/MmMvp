package com.shhatrat.database.actions

import kotlin.reflect.KClass

interface IDatabaseActions<C> {

    fun save(obj: C)

    fun saveOrUpdate(obj: C)

    fun delete(obj: C)

    fun load(objClass: KClass<out Any>, id: Any): C?

    fun loadAll(objClass: KClass<out Any>): List<C>?

    fun delete(objClass: KClass<out Any>, id: Any)
}
