package com.shhatrat.wear_manager

import io.reactivex.rxjava3.core.Observable

interface IWearManager {

    fun sendJokeString()

    fun observeJokeString(): Observable<Int>
}