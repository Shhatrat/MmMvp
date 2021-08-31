package com.shhatrat.mmmvp.config

@Suppress("MemberVisibilityCanBePrivate", "unused", "CanBeParameter")
class AppBuildType(val name: String) {
    val implementation = "${name}Implementation"
}