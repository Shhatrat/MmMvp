package com.shhatrat.examplefeature

import android.util.Log
import com.shhatrat.api.IRemoteManager
import com.shhatrat.base.presenter.BasePresenter
import com.shhatrat.database.IDatabaseManager
import com.shhatrat.model.Joke
import io.reactivex.rxjava3.disposables.Disposable

class FeaturePresenter constructor(
    private val remoteManager: IRemoteManager,
    private val databaseManager: IDatabaseManager,
) : BasePresenter<IFeatureContract.V>(), IFeatureContract.P {

    override fun attachView(view: IFeatureContract.V) {
        super.attachView(view)
        downloadJoke()
    }

    override fun saveRandom() {
        databaseManager.saveOrUpdate(Joke.getMock())
        Log.d("XDD2", databaseManager.loadAll()?.first()?.joke ?: "NIE MA")
        ddddc?.dispose()
    }

    var ddddc: Disposable? = null

    private fun downloadJoke() {
//        remoteManager.getRandomJoke()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeBy(
//                onSuccess = {
//                    databaseManager.load(RealmJoke::class, ObjectId())
//                    databaseManager.load(RealmJoke::class, "dfds")
//                    view?.showJoke(it)
//                    ddddc = databaseManager.observeAll(RealmJoke::class)
////                        .subscribeOn(Schedulers.io())
////                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribeBy(
//                            onNext = {
//                                Log.d("xdd", "xdd1 ${it.size}")
//                            },
//                            onError = {
//                                Log.d("xdd", "xdd2 ${it.message}")
//                            },
//                            onComplete = {
//                                Log.d("xdd", "xdd3")
//                            }
//                        )
//                    databaseManager.save(it.toRealm())
//                },
//                onError = {
//                    it.message?.let { message ->
//                        view?.noInternetConnection?.noInternetConnectionTooltip(message)
//                    }
//                },
//            )
//            .add(subscriptions)
    }
}