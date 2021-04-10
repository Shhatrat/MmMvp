package com.shhatrat.cpp.native

object HelloCpp {

    init {
        System.loadLibrary("native-lib")
    }

    external fun printHello(): String
}