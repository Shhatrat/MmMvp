package com.shhatrat.mmmvp.example

import com.shhatrat.base.presenter.BasePresenter

class ExamplePresenterImpl : BasePresenter<IExampleContract.V>(), IExampleContract.P {

    override fun onViewPrepared() {
        super.onViewPrepared()
        view?.exampleAction("xD")
    }
}