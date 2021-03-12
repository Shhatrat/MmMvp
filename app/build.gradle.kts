plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

dependencies {

    implementation(project(":core:base"))
    implementation(project(":core:api"))

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.RxJava)
    implementation(BuildScript.Plugins.KOIN)
    implementation(Libraries.Retrofit)
    implementation(BuildScript.Plugins.MATERIAL)

}