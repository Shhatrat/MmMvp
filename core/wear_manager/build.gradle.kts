plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

    moduleCoreModel()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)

    implementation("androidx.wear:wear:1.1.0")
    implementation("com.google.android.gms:play-services-wearable:17.0.0")
    implementation("com.google.code.gson:gson:2.8.6")
}
