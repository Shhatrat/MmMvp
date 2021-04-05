package com.shhatrat.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shhatrat.model.Joke

@Entity(tableName = "joke_table")
data class JokeTable(
    @PrimaryKey
    val id: Int,
    val joke: String
) {
    companion object {
        fun Joke.toJokeTable() = JokeTable(this.id, this.joke)

        fun JokeTable.toJoke() = Joke(this.id, this.joke)
    }
}