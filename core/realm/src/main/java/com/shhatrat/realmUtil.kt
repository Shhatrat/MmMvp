package com.shhatrat

import com.shhatrat.model.RealmJoke
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

fun <E> RealmQuery<E>.equalTo(nameOfPrimaryKey: String, id: Any): RealmQuery<E> {
    return when (id) {
        is String -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Date -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Boolean -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Byte -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is ByteArray -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Double -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Float -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Int -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Long -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Short -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is Decimal128 -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        is ObjectId -> equalTo(RealmJoke.getNameOfPrimaryKey(), id)
        else -> throw Exception("Bad parameterType")
    }
}