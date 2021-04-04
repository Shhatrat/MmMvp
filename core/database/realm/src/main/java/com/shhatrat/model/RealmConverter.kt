package com.shhatrat.model

interface RealmConverter<T, Realm> {
    fun Realm.fromRealm(): T
    fun T.toRealm(): Realm
    fun getNameOfPrimaryKey(): String
}