package com.shhatrat.actionsImpl

import com.shhatrat.database.IRxDatabaseActions
import com.shhatrat.equalTo
import com.shhatrat.model.RealmJoke
import com.shhatrat.realmInstance
import io.reactivex.rxjava3.core.Observable
import io.realm.RealmObject
import kotlin.reflect.KClass

class IRxDatabaseActionsImpl<T>(
    private val converter: (RealmObject) -> T,
    private val realmModelClass: KClass<out RealmObject>
) : IRxDatabaseActions<T> {

    override fun observeAll(realmClass: KClass<out Any>): Observable<List<T>> {
        val raw = realmInstance
            .where(realmModelClass.java)
        val query = raw.findAllAsync()

        return Observable.create { subscriber ->
            query.addChangeListener { _, _ ->
                subscriber.onNext(
                    realmInstance.copyFromRealm(raw.findAll()).toList().map(converter)
                )
            }
            subscriber.onNext(realmInstance.copyFromRealm(raw.findAll()).toList().map(converter))
            subscriber.setCancellable {
                query.removeAllChangeListeners()
            }
        }
    }

    override fun observe(realmClass: KClass<out Any>, id: Any): Observable<T> {
        val raw =
            realmInstance.where(realmModelClass.java).equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        val query = raw.findFirstAsync()

        return Observable.create { subscriber ->
            query.addChangeListener<RealmObject> { _, _ ->
                raw.findFirst()?.let { subscriber.onNext(converter.invoke(it)) }
            }
            subscriber.setCancellable {
                query.removeAllChangeListeners()
            }
        }
    }
}