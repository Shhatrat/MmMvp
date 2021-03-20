package com.shhatrat.model

data class Joke(
    val id: Int,
    val joke: String
) {

    companion object {
        fun getMock() = Joke(1, "mock joke")
    }
}