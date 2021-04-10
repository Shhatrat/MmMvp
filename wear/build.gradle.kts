plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

    moduleCoreApi()
    moduleCoreBase()
    moduleCoreModel()
    moduleCoreDatabase()
    moduleCpp()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.Android.CONSTRAINT_LAYOUT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
    implementation("androidx.wear:wear:1.1.0")
    implementation("com.google.android.gms:play-services-wearable:17.0.0")
//    implementation("com.google.android.support:wearable:2.8.1")
    compileOnly("com.google.android.wearable:wearable:2.8.1")

}