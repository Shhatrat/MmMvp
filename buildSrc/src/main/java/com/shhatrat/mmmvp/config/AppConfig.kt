package com.shhatrat.mmmvp.config

/**
 * Created by Sergey Chuprin on 07.06.2019.
 */
object AppConfig {

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val APPLICATION_ID = "com.shhtrat.mmmvp"

    const val MIN_SDK = 23
    const val TARGET_SDK = 30
    const val BUILD_TOOLS_VERSION = "29.0.3"

    object BuildTypes {

        val DEV = AppBuildType("dev")
        val DEBUG = AppBuildType("debug")
        val RELEASE = AppBuildType("release")

    }

}