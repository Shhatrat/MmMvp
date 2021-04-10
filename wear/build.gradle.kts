import com.shhatrat.mmmvp.config.AppConfig.APPLICATION_ID

plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
}

android{
    defaultConfig{
        applicationId = APPLICATION_ID
    }
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
    compileOnly("com.google.android.wearable:wearable:2.8.1")
}