package com.shhatrat.wear_manager

import android.content.Context
import com.google.android.gms.wearable.*
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

class WearManagerImpl(private val context: Context) : IWearManager {

    private fun getDataClient() = Wearable.getDataClient(context)

    override fun sendJokeString() {
        val data: PutDataRequest = PutDataMapRequest.create("/count").run {
            dataMap.putInt("KEY", Random.nextInt(1, 100))
            asPutDataRequest()
        }
        getDataClient().putDataItem(data)
    }

    override fun observeJokeString(): Observable<Int> {

        var listener: DataClient.OnDataChangedListener? = null
        val obs = Observable.create<Int> { em ->
            listener = DataClient.OnDataChangedListener { dataEvents ->
                dataEvents.forEach { event ->
                    event.dataItem.also { item ->
                        if (item.uri.path?.compareTo("/count") == 0) {
                            DataMapItem.fromDataItem(item).dataMap.apply {
                                em.onNext(getInt("KEY"))
                            }
                        }
                    }
                }
            }
            listener?.let { getDataClient().addListener(it) }
        }
        obs.doOnComplete { listener?.let { getDataClient().removeListener(it) } }
        return obs
    }
}