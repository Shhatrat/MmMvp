plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

dependencies {

    implementation(project(":core:base"))
    implementation(project(":core:api"))
    implementation(project(":core:realm"))
    implementation(project(":feature:examplefeature"))

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.RxJava)
    implementation(Libraries.KOIN)
    implementation(Libraries.Retrofit)
    implementation(Libraries.MATERIAL)
}