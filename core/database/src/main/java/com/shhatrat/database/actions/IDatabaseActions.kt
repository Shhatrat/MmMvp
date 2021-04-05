package com.shhatrat.database.actions

import kotlin.reflect.KClass

interface IDatabaseActions<C> {

    fun save(obj: C)

    fun saveOrUpdate(obj: C)

    fun delete(obj: C)

    fun load(objClass: KClass<Any>, id: Any): C?

    fun loadAll(objClass: KClass<Any>): List<C>?

    fun delete(objClass: KClass<Any>, id: Any)
}
