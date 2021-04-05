package com.shhatrat.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "joke_table")
data class JokeTable(
    @PrimaryKey
    val id: Int,
    val joke: String
)