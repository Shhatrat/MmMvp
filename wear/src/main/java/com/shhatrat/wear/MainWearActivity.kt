package com.shhatrat.wear

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.wear.ambient.AmbientModeSupport

class MainWearActivity : AppCompatActivity(), AmbientModeSupport.AmbientCallbackProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_wear)
    }

    override fun getAmbientCallback() = object : AmbientModeSupport.AmbientCallback() {}
}