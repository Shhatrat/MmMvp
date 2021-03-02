package com.shhatrat.mmmvp.example

import android.widget.Toast
import com.shhatrat.base.view.BaseActivity
import com.shhatrat.mmmvp.R
import org.koin.android.ext.android.inject

class ExampleActivity : BaseActivity<IExampleContract.P, IExampleContract.V>(), IExampleContract.V {

    override val presenter: IExampleContract.P by inject()

    override fun exampleAction(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun getMvpView(): IExampleContract.V = this

    override fun onResume() {
        super.onResume()
        presenter.onViewPrepared()
    }
}