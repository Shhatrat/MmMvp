package com.shhatrat.room

import com.shhatrat.database.IDatabaseManager
import com.shhatrat.model.Joke
import com.shhatrat.room.model.JokeTable.Companion.toJoke
import com.shhatrat.room.model.JokeTable.Companion.toJokeTable
import io.reactivex.rxjava3.core.Observable
import kotlin.reflect.KClass

class DatabaseManager
constructor(private val jokeDb: JokeDb) : IDatabaseManager {

    override fun save(obj: Joke) {
        jokeDb.jokeDao().save(obj.toJokeTable())
    }

    override fun saveOrUpdate(obj: Joke) {
        jokeDb.jokeDao().saveOrUpdate(obj.toJokeTable())
    }

    override fun delete(obj: Joke) {
        jokeDb.jokeDao().delete(obj.toJokeTable())
    }

    override fun loadAll(): List<Joke>? {
        return jokeDb.jokeDao().getAllJokes().map { jokeTable -> jokeTable.toJoke() }
    }

    override fun load(id: Any): Joke? {
        return jokeDb.jokeDao().getJoke(id as Int)?.toJoke()
    }

    override fun deleteById(id: Any) {
        jokeDb.jokeDao().delete(id as Int)
    }

    override fun observeAll(realmClass: KClass<out Any>): Observable<List<Joke>> {
        return jokeDb.jokeDao().getAllJokesObs()
            .map { listJokeTable ->
                listJokeTable
                    .map { jokeTable -> jokeTable.toJoke() }
            }
    }

    override fun observe(realmClass: KClass<out Any>, id: Any): Observable<Joke> {
        return jokeDb.jokeDao().getJokeObs(id as Int).map { it?.toJoke() }
    }
}