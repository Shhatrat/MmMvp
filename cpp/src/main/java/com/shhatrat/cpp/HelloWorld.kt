package com.shhatrat.cpp

object HelloWorld {

    init {
        System.loadLibrary("native-lib")
    }

    external fun stringFromJNI(): String
}