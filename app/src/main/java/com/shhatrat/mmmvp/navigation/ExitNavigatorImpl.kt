package com.shhatrat.mmmvp.navigation

import android.app.Activity
import com.shhatrat.base.navigator.ExitNavigator

class ExitNavigatorImpl : ExitNavigator {

    override fun exitApp(activity: Activity) {
        activity.moveTaskToBack(true)
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0)
    }
}