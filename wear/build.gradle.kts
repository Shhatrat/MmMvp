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

    moduleWearManager()
    moduleCoreModel()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.Android.CONSTRAINT_LAYOUT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
    implementation("androidx.wear:wear:1.1.0")
    compileOnly("com.google.android.wearable:wearable:2.8.1")
    implementation("com.google.code.gson:gson:2.8.6")

}