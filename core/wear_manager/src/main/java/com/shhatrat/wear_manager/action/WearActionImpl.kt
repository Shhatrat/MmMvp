package com.shhatrat.wear_manager.action

import android.content.Context
import com.google.android.gms.wearable.*
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Observable

class WearActionImpl<T>(private val context: Context,
                        private val gson: Gson,
                        private val path: String,
                        private val key: String,
                        private val classType: Class<out Any>) : IWearAction<T> {

    private fun getDataClient() = Wearable.getDataClient(context)

    override fun send(obj: T) {
        val data: PutDataRequest = PutDataMapRequest.create(path).run {
            dataMap.putString(key, gson.toJson(obj))
            asPutDataRequest()
        }
        getDataClient().putDataItem(data)
    }

    override fun observe(): Observable<T> {
        var listener: DataClient.OnDataChangedListener? = null
        val obs = Observable.create<T> { em ->
            listener = DataClient.OnDataChangedListener { dataEvents ->
                dataEvents.forEach { event ->
                    event.dataItem.also { item ->
                        if (item.uri.path?.compareTo(path) == 0) {
                            DataMapItem.fromDataItem(item).dataMap.apply {
                                em.onNext(gson.fromJson(getString(key), classType) as T)
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