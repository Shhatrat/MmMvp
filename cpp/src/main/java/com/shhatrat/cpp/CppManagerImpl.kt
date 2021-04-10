package com.shhatrat.cpp

import com.shhatrat.cpp.native.HelloCpp

class CppManagerImpl : ICppManager {

    override fun printHello() = HelloCpp.printHello()
}