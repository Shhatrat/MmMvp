package com.shhatrat.mmmvp.navigation

import android.content.Context
import com.shhatrat.base.navigator.ExitNavigator
import com.shhatrat.examplefeature.FeatureNavigator
import com.shhatrat.mmmvp.destination.ExampleFeature2DestinationImpl
import com.shhatrat.navigation.ExampleFeature2Destination

class FeatureNavigatorImpl(private val context: Context, exitNavigator: ExitNavigator) :
    FeatureNavigator,
    ExitNavigator by exitNavigator,
    ExampleFeature2Destination by ExampleFeature2DestinationImpl(context)