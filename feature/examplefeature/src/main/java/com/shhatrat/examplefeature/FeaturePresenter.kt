package com.shhatrat.examplefeature

import com.shhatrat.api.IRemoteManager
import com.shhatrat.base.presenter.BasePresenter
import com.shhatrat.database.IDatabaseManager

class FeaturePresenter constructor(
    private val remoteManager: IRemoteManager,
    private val databaseManager: IDatabaseManager,
) : BasePresenter<IFeatureContract.V, FeatureNavigator>(), IFeatureContract.P {

    override fun onButtonClicked() {
        navigator?.openExampleFeature2()
    }

}