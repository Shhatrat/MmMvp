package com.shhatrat.action.rx

import com.shhatrat.realmInstance
import io.reactivex.rxjava3.core.Observable
import io.realm.RealmObject
import kotlin.reflect.KClass

interface RealmRxActions<T : RealmObject> {

    fun observeAll(realmObject: KClass<out RealmObject>): Observable<List<T>>
}

class RealmRxActionImpl<T : RealmObject> : RealmRxActions<T> {

    override fun observeAll(realmObject: KClass<out RealmObject>): Observable<List<T>> {
        val raw = realmInstance
            .where(realmObject.java)
        val query = raw.findAllAsync()

        return Observable.create { subscriber ->
            query.addChangeListener { _, _ ->
                subscriber.onNext(realmInstance.copyFromRealm(raw.findAll()).toList() as List<T>)
            }
            subscriber.onNext(realmInstance.copyFromRealm(raw.findAll()).toList() as List<T>)
            subscriber.setCancellable {
                query.removeAllChangeListeners()
            }
        }
    }
}