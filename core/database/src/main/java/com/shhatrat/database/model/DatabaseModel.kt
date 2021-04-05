package com.shhatrat.database.model

abstract class DatabaseModel<NormalType, DatabaseType> {

    abstract val value: NormalType

    abstract fun DatabaseType.fromDatabase(): NormalType
    abstract fun NormalType.toDatabase(): DatabaseType
}