package com.shhatrat.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shhatrat.room.model.JokeTable

@Database(entities = [JokeTable::class], version = 1, exportSchema = false)
abstract class JokeDb : RoomDatabase() {

    abstract fun jokeDao(): JokeDao

    companion object {
        @Volatile
        private var INSTANCE: JokeDb? = null

        fun getDatabase(context: Context): JokeDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokeDb::class.java,
                    "jokeDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}