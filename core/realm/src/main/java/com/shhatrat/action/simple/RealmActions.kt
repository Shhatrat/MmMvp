package com.shhatrat.action.simple

import com.shhatrat.doInTransaction
import com.shhatrat.equalTo
import com.shhatrat.model.RealmJoke
import com.shhatrat.realmInstance
import io.realm.RealmObject
import kotlin.reflect.KClass

interface RealmActions<T : RealmObject> {

    fun save(obj: T)

    fun saveOrUpdate(obj: T)

    fun delete(obj: T)

    fun load(realmClass: KClass<T>, id: Any): T?

    fun loadAll(realmClass: KClass<T>): List<T>?

    fun delete(realmClass: KClass<T>, id: Any)
}

class RealmActionImpl<T : RealmObject> : RealmActions<T> {

    override fun save(obj: T) {
        doInTransaction { realm -> realm.insert(obj) }
    }

    override fun saveOrUpdate(obj: T) {
        doInTransaction { realm -> realm.insertOrUpdate(obj) }
    }

    override fun delete(obj: T) {
        doInTransaction { realm -> realm.delete(obj.javaClass) }
    }

    override fun load(realmClass: KClass<T>, id: Any): T? {
        return realmInstance.where(realmClass.java).equalTo(RealmJoke.getNameOfPrimaryKey(), id)
            .findAll().first()
    }

    override fun loadAll(realmClass: KClass<T>): List<T>? {
        val results = realmInstance.where(realmClass.java).findAll()
        return realmInstance.copyFromRealm(results).toList()
    }

    override fun delete(realmClass: KClass<T>, id: Any) {
        doInTransaction { realm ->
            realm.where(realmClass.java).equalTo(RealmJoke.getNameOfPrimaryKey(), id).findAll()
                .deleteAllFromRealm()
        }
    }
}