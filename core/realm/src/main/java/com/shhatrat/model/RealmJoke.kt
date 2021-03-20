package com.shhatrat.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmJoke(
    @PrimaryKey
    open var id: Int = 0,
    open var joke: String = ""
) : RealmObject() {

    companion object : RealmConverter<Joke, RealmJoke> {
        override fun RealmJoke.fromRealm() = Joke(this.id, this.joke)
        override fun Joke.toRealm() = RealmJoke(this.id, this.joke)
        override fun getNameOfPrimaryKey() = "id"
    }
}