import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec


const val PLUGIN_GRADLE_VERSIONS = "com.github.ben-manes.versions"
const val PLUGIN_GRADLE_VERSIONS_VERSION = "0.36.0"
const val PLUGIN_GRAPH_GENERATOR = "com.vanniktech.dependency.graph.generator"
const val PLUGIN_GRAPH_GENERATOR_VERSION = "0.5.0"
const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"
const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
const val PLUGIN_ANDROID_APPLICATION = "com.android.application"
const val PLUGIN_ANDROID_LIBRARY = "com.android.library"
const val REALM_ANDROID = "realm-android"

fun PluginDependenciesSpec.benManesGradleVersion() =
    (id(PLUGIN_GRADLE_VERSIONS) version (PLUGIN_GRADLE_VERSIONS_VERSION))

fun PluginDependenciesSpec.graphGenerator() =
    (id(PLUGIN_GRAPH_GENERATOR) version (PLUGIN_GRAPH_GENERATOR_VERSION))

fun PluginDependenciesSpec.kotlinKapt(): PluginDependencySpec = id(PLUGIN_KOTLIN_KAPT)

fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec = id(PLUGIN_KOTLIN_ANDROID)

fun PluginDependenciesSpec.androidApplication(): PluginDependencySpec =
    id(PLUGIN_ANDROID_APPLICATION)

fun PluginDependenciesSpec.androidLibrary(): PluginDependencySpec = id(PLUGIN_ANDROID_LIBRARY)

fun PluginDependenciesSpec.realmAndroid(): PluginDependencySpec = id(REALM_ANDROID)