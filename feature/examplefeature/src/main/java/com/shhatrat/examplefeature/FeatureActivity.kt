package com.shhatrat.examplefeature

import android.widget.Toast
import com.shhatrat.base.useCase.view.NoInternetConnection
import com.shhatrat.base.useCase.view.NoInternetConnectionImpl
import com.shhatrat.base.view.BaseActivity
import com.shhatrat.model.Joke
import kotlinx.android.synthetic.main.activity_feature.*
import org.koin.android.ext.android.inject

class FeatureActivity : BaseActivity<IFeatureContract.P, IFeatureContract.V>(), IFeatureContract.V {

    override val noInternetConnection: NoInternetConnection by lazy {
        NoInternetConnectionImpl(
            getContext()
        )
    }

    override val presenter: IFeatureContract.P by inject()

    override fun getLayoutResId(): Int = R.layout.activity_feature

    override fun getMvpView(): IFeatureContract.V = this

    override fun showJoke(joke: Joke) {
        Toast.makeText(this, joke.joke, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        button.setOnClickListener {
            presenter.saveRandom()
        }
    }
}