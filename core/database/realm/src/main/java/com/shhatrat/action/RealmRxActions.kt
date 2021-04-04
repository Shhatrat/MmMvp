//package com.shhatrat.action
//
//import com.shhatrat.database.IRxDatabaseActions
//import com.shhatrat.equalTo
//import com.shhatrat.model.RealmJoke
//import com.shhatrat.realmInstance
//import io.reactivex.rxjava3.core.Observable
//import io.realm.RealmObject
//import kotlin.reflect.KClass
//
//interface RealmRxActions<T : RealmObject>: IRxDatabaseActions<T>
//
//class RealmRxActionImpl<T : RealmObject> : RealmRxActions<T> {
//
//    override fun observeAll(realmClass: KClass<out T>): Observable<List<T>> {
//        val raw = realmInstance
//            .where(realmClass.java)
//        val query = raw.findAllAsync()
//
//        return Observable.create { subscriber ->
//            query.addChangeListener { _, _ ->
//                subscriber.onNext(realmInstance.copyFromRealm(raw.findAll()).toList() as List<T>)
//            }
//            subscriber.onNext(realmInstance.copyFromRealm(raw.findAll()).toList() as List<T>)
//            subscriber.setCancellable {
//                query.removeAllChangeListeners()
//            }
//        }
//    }
//
//    override fun observe(realmClass: KClass<out T>, id: Any): Observable<T> {
//        val raw = realmInstance.where(realmClass.java).equalTo(RealmJoke.getNameOfPrimaryKey(), id)
//        val query = raw.findFirstAsync()
//
//        return Observable.create { subscriber ->
//            query.addChangeListener<T> { _, _ ->
//                raw.findFirst()?.let { subscriber.onNext(it as T) }
//            }
//            subscriber.setCancellable {
//                query.removeAllChangeListeners()
//            }
//        }
//    }
//}