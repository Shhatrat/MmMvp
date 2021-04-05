package com.shhatrat.room

import androidx.room.Dao
import androidx.room.Query
import com.shhatrat.room.base.BaseDao
import com.shhatrat.room.model.JokeTable
import io.reactivex.rxjava3.core.Observable

@Dao
interface JokeDao : BaseDao<JokeTable> {

    @Query("SELECT * from joke_table")
    fun getAllJokesObs(): Observable<List<JokeTable>>

    @Query("DELETE FROM joke_table WHERE id=:id")
    fun delete(id: Int)

    @Query("SELECT * FROM joke_table WHERE id=:id ")
    fun getJoke(id: Int): JokeTable?

    @Query("SELECT * FROM joke_table WHERE id=:id ")
    fun getJokeObs(id: Int): Observable<JokeTable?>

    @Query("SELECT * from joke_table")
    fun getAllJokes(): List<JokeTable>

    @Query("DELETE FROM joke_table")
    fun deleteAll()
}