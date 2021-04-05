package com.shhatrat.room.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {

    @Insert
    fun save(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveOrUpdate(obj: T)

    @Delete
    fun delete(obj: T)
}