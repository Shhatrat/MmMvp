package com.shhatrat.wear

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.wear.ambient.AmbientModeSupport
import com.google.android.gms.tasks.Task
import com.google.android.gms.wearable.*
import kotlin.random.Random

class MainWearActivity : AppCompatActivity(), AmbientModeSupport.AmbientCallbackProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_wear)
        setupListener()
    }

    lateinit var putDataTask: Task<DataItem>

    private fun setupListener() {
        findViewById<Button>(R.id.button).setOnClickListener {

            val dataClient: DataClient = Wearable.getDataClient(this)

            val data: PutDataRequest = PutDataMapRequest.create("/count").run {
                dataMap.putInt("KEY", Random.nextInt(1,100))
//                setUrgent()
                asPutDataRequest()
            }
            putDataTask = dataClient.putDataItem(data)
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            putDataTask.isComplete
        }
    }

    override fun getAmbientCallback() = object : AmbientModeSupport.AmbientCallback() {}
}