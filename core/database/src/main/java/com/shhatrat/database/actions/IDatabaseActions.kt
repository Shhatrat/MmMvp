package com.shhatrat.database.actions

interface IDatabaseActions<C> {

    fun save(obj: C)

    fun saveOrUpdate(obj: C)

    fun delete(obj: C)

    fun load(id: Any): C?

    fun loadAll(): List<C>?

    fun deleteById(id: Any)
}
