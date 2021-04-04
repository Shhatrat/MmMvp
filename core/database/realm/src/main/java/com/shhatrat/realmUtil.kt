package com.shhatrat

import io.realm.Realm
import io.realm.RealmQuery
import org.bson.types.Decimal128
import org.bson.types.ObjectId
import java.util.*

internal fun doInTransaction(action: (realm: Realm) -> Unit) {
    realmInstance.executeTransaction {
        action.invoke(it)
    }
}

internal val realmInstance: Realm by lazy { Realm.getDefaultInstance() }

fun <E> RealmQuery<E>.equalTo(nameOfPrimaryKey: String, id: Any): RealmQuery<out E> {
    return when (id) {
        is String -> equalTo(nameOfPrimaryKey, id)
        is Date -> equalTo(nameOfPrimaryKey, id)
        is Boolean -> equalTo(nameOfPrimaryKey, id)
        is Byte -> equalTo(nameOfPrimaryKey, id)
        is ByteArray -> equalTo(nameOfPrimaryKey, id)
        is Double -> equalTo(nameOfPrimaryKey, id)
        is Float -> equalTo(nameOfPrimaryKey, id)
        is Int -> equalTo(nameOfPrimaryKey, id)
        is Long -> equalTo(nameOfPrimaryKey, id)
        is Short -> equalTo(nameOfPrimaryKey, id)
        is Decimal128 -> equalTo(nameOfPrimaryKey, id)
        is ObjectId -> equalTo(nameOfPrimaryKey, id)
        else -> throw Exception("Bad parameterType")
    }
}