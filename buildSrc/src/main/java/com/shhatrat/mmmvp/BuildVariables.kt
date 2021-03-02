object Version {
    const val minSdkVersion = 23
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.2"
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "testInstrumentationRunner"
}

object Dep {
    const val kotlin = "1.3.71"
    const val kotlin_coroutines = "1.3.5"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib"

    const val androidx_test_ext_junit = "androidx.test.ext:junit:1.1.1"
    const val androidx_test_espresso_espresso_core = "androidx.test.espresso:espresso-core:3.2.0"
    const val androidx_appcompat_appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"

    const val androidx_core_core_ktx = "androidx.core:core-ktx:1.2.0"
    const val junit_junit = "junit:junit:4.13"

    const val koin = "org.koin:koin-android:2.1.5"
    const val koin_experimental = "org.koin:koin-core-ext:2.1.5"
    const val koin_test = "org.koin:koin-test:2.1.5"
    const val koin_ext = "org.koin:koin-android-ext:2.1.5"
    const val koin_fragment = "org.koin:koin-androidx-fragment:2.1.5"
    const val koin_androidx = "org.koin:koin-androidx-ext:2.1.5"

}

object Mod {
    const val interactor = ":interactor"
    const val model = ":model"
    const val presenter = ":presenter"
    const val repository = ":repository"
    const val ui = ":ui"
    const val base = ":base"
}