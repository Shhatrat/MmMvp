package com.shhatrat.base.navigator

import android.app.Activity

interface ExitNavigator : Navigator{

    fun exitApp(activity: Activity)
}