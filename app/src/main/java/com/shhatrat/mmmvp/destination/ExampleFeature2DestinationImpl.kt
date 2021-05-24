package com.shhatrat.mmmvp.destination

import android.content.Context
import android.content.Intent
import com.shhatrat.examplefeature.Feature2Activity
import com.shhatrat.navigation.ExampleFeature2Destination

class ExampleFeature2DestinationImpl(private val context: Context) : ExampleFeature2Destination {

    override fun openExampleFeature2() {
        context.startActivity(Intent(context, Feature2Activity::class.java))
    }
}