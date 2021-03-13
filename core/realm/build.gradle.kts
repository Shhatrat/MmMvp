plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("realm-android")
}

dependencies {
    implementation(project(":core:base"))
    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
}