plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("realm-android")
}

dependencies {
    implementation(project(":core:base"))
    implementation(project(":core:model"))
    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
    implementation("com.jakewharton.rxrelay3:rxrelay:3.0.0")
}