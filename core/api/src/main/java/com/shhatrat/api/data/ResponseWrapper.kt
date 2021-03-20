package com.shhatrat.api.data

data class ResponseWrapper<T : Any>(
    val type: String,
    val value: T
)