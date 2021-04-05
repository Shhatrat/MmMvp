package com.shhatrat.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shhatrat.room.model.JokeTable
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface JokeDao {

    @Query("SELECT * from joke_table")
    fun getJoke(): Observable<List<JokeTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: JokeTable): Completable

    @Query("DELETE FROM joke_table")
    fun deleteAll(): Completable
}