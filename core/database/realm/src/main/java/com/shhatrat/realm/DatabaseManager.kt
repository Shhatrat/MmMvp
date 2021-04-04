//package com.shhatrat.realm
//
//import com.shhatrat.action.RealmActionImpl
//import com.shhatrat.action.RealmActions
//import com.shhatrat.action.RealmRxActionImpl
//import com.shhatrat.action.RealmRxActions
//import com.shhatrat.database.Convertable
//import com.shhatrat.database.IDatabaseActions
//import com.shhatrat.database.IDatabaseManager
//import com.shhatrat.model.Joke
//import com.shhatrat.model.RealmJoke
//import kotlin.reflect.KClass
//
//class DatabaseManager : IRealmDatabaseManager,
//    RealmActions<RealmJoke> by RealmActionImpl(),
//    RealmRxActions<RealmJoke> by RealmRxActionImpl()
//
//class CC: Convertable<Joke, RealmJoke>{
//    override fun Joke.toRealm(): RealmJoke = RealmJoke(this.id, this.joke)
//    override fun RealmJoke.toNormal(): Joke = Joke(this.id, this.joke)
//}
//
//class A : IDatabaseManager
//class DB: IDatabaseActions<CC> {
//    override fun save(obj: CC) {
//        TODO("Not yet implemented")
//    }
//
//    override fun saveOrUpdate(obj: CC) {
//        TODO("Not yet implemented")
//    }
//
//    override fun delete(obj: CC) {
//        TODO("Not yet implemented")
//    }
//
//    override fun load(objClass: KClass<Any>, id: Any): CC? {
//        TODO("Not yet implemented")
//    }
//
//    override fun loadAll(objClass: KClass<Any>): List<CC>? {
//        TODO("Not yet implemented")
//    }
//
//    override fun delete(objClass: KClass<Any>, id: Any) {
//        TODO("Not yet implemented")
//    }
//
//}