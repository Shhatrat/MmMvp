package com.shhatrat.mmmvp.navigation

import android.content.Context
import android.content.Intent
import com.shhatrat.base.navigator.ExitNavigator
import com.shhatrat.examplefeature.Feature2Activity
import com.shhatrat.examplefeature.FeatureNavigator

class FeatureNavigatorImpl(exitNavigator: ExitNavigator) : FeatureNavigator,
    ExitNavigator by exitNavigator {

    override fun goToSecond(context: Context) {
        context.startActivity(Intent(context, Feature2Activity::class.java))
    }
}