package com.shhatrat.action.rx

import com.shhatrat.equalTo
import com.shhatrat.model.RealmJoke
import com.shhatrat.realmInstance
import io.reactivex.rxjava3.core.Observable
import io.realm.RealmObject
import kotlin.reflect.KClass

interface RealmRxActions<T : RealmObject> {

    fun observeAll(realmClass: KClass<out RealmObject>): Observable<List<T>>
    fun observe(realmClass: KClass<out RealmObject>, id: Any): Observable<T>
}

class RealmRxActionImpl<T : RealmObject> : RealmRxActions<T> {

    override fun observeAll(realmClass: KClass<out RealmObject>): Observable<List<T>> {
        val raw = realmInstance
            .where(realmClass.java)
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

    override fun observe(realmClass: KClass<out RealmObject>, id: Any): Observable<T> {
        val raw = realmInstance.where(realmClass.java).equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        val query = raw.findFirstAsync()

        return Observable.create { subscriber ->
            query.addChangeListener<T> { _, _ ->
                subscriber.onNext(raw.findFirst() as T)
            }
            subscriber.setCancellable {
                query.removeAllChangeListeners()
            }
        }
    }
}