package com.shhatrat.mmmvp.example

import com.shhatrat.base.presenter.IPresenter
import com.shhatrat.base.view.IView

interface IExampleContract {
    interface V : IView {
        fun exampleAction(data: String)
    }

    interface P : IPresenter<V>
}