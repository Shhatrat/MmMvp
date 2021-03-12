plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

dependencies {
    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.RxJava)
    implementation(BuildScript.Plugins.KOIN)
    implementation(Libraries.Retrofit)

}