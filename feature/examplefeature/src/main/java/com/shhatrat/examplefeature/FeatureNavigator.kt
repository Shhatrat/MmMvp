package com.shhatrat.examplefeature

import android.content.Context
import com.shhatrat.base.navigator.ExitNavigator
import com.shhatrat.base.navigator.Navigator

interface FeatureNavigator : Navigator, ExitNavigator{

    fun goToSecond(context: Context)
}