package com.shhatrat.actionsImpl

import com.shhatrat.database.actions.IDatabaseActions
import com.shhatrat.doInTransaction
import com.shhatrat.equalTo
import com.shhatrat.model.RealmJoke
import com.shhatrat.realmInstance
import io.realm.RealmObject
import kotlin.reflect.KClass


class IDatabaseActionsImpl<T>(
    private val converter: (T) -> RealmObject,
    private val realmConverter: (dd: RealmObject) -> T,
    private val propertyIdName: String,
    private val realmModelClass: KClass<out RealmObject>
) : IDatabaseActions<T> {

    override fun save(obj: T) {
        doInTransaction { realm -> realm.insert(converter.invoke(obj)) }
    }

    override fun saveOrUpdate(obj: T) {
        doInTransaction { realm -> realm.insertOrUpdate(converter.invoke(obj)) }
    }

    override fun delete(obj: T) {
        doInTransaction { realm -> realm.delete(converter(obj).javaClass) }
    }

    override fun load(objClass: KClass<Any>, id: Any): T? {
        return realmInstance.where(realmModelClass.java).equalTo(propertyIdName, id)
            .findAll().first()?.let { realmConverter.invoke(it) }
    }

    override fun loadAll(objClass: KClass<Any>): List<T>? {
        val results = realmInstance.where(realmModelClass.java).findAll()
        return realmInstance.copyFromRealm(results).toList().map { realmConverter.invoke(it) }
    }

    override fun delete(objClass: KClass<Any>, id: Any) {
        doInTransaction { realm ->
            realm.where(realmModelClass.java).equalTo(RealmJoke.getNameOfPrimaryKey(), id).findAll()
                .deleteAllFromRealm()
        }
    }
}