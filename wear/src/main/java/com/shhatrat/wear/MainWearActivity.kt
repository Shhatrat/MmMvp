package com.shhatrat.wear

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.wear.ambient.AmbientModeSupport
import com.shhatrat.wear.joke.JokeActivity

class MainWearActivity : AppCompatActivity(), AmbientModeSupport.AmbientCallbackProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_wear)
        setupListener()
    }

    private fun setupListener() {
        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, JokeActivity::class.java))
        }
    }

    override fun getAmbientCallback() = object : AmbientModeSupport.AmbientCallback() {}
}