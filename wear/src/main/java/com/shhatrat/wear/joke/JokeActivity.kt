package com.shhatrat.wear.joke

import android.view.LayoutInflater
import android.widget.Toast
import com.shhatrat.base.view.BaseActivity
import com.shhatrat.model.Joke
import com.shhatrat.wear.R
import com.shhatrat.wear.databinding.ActivityJokeWearBinding
import org.koin.android.ext.android.inject

class JokeActivity :
    BaseActivity<JokeContract.P, JokeContract.V, ActivityJokeWearBinding, JokeNavigator>(),
    JokeContract.V {

    override val presenter: JokeContract.P by inject()

    override fun getLayoutResId(): Int = R.layout.activity_joke_wear

    override fun getMvpView(): JokeContract.V = this

    override fun showJoke(joke: Joke) {
        Toast.makeText(this, joke.joke, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        withBinding {
            buttonJoke.setOnClickListener {
                presenter.observeJokes()
            }
        }
    }

    override fun attachViewBinding(layoutInflater: LayoutInflater) =
        ActivityJokeWearBinding.inflate(layoutInflater)

    override val navigator: JokeNavigator by inject()
}