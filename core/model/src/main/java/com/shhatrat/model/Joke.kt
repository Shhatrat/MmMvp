package com.shhatrat.model

import kotlin.random.Random

data class Joke(
    val id: Int,
    val joke: String
) {

    companion object {
        fun getMock() = Joke(1, "mock joke")

        fun generateMock() = Joke(Random.nextInt(1,2000), "mock joke ${Random.nextInt(1,2000)}")
    }
}