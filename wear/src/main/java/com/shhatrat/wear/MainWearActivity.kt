package com.shhatrat.wear

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.wear.ambient.AmbientModeSupport
import com.google.gson.Gson
import com.shhatrat.model.Joke
import com.shhatrat.wear_manager.WearManagerImpl

class MainWearActivity : AppCompatActivity(), AmbientModeSupport.AmbientCallbackProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_wear)
        setupListener()
    }


    private fun setupListener() {
        findViewById<Button>(R.id.button).setOnClickListener {

            WearManagerImpl(this, Gson()).send(Joke.generateMock())
        }
    }

    override fun getAmbientCallback() = object : AmbientModeSupport.AmbientCallback() {}
}