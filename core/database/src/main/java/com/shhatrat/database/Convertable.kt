package com.shhatrat.database

interface Convertable<NormalType, DataBaseType> {
    fun NormalType.toRealm(): DataBaseType
    fun DataBaseType.toNormal(): NormalType
}