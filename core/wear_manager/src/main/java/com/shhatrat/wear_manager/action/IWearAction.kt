package com.shhatrat.wear_manager.action

import io.reactivex.rxjava3.core.Observable

interface IWearAction<C> {

    fun send(obj: C)

    fun observe(): Observable<C>
}