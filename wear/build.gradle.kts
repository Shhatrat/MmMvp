import com.shhatrat.mmmvp.config.AppConfig.APPLICATION_ID

plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
}

android {
    defaultConfig {
        applicationId = APPLICATION_ID
    }
}

dependencies {

    moduleWearManager()
    moduleCoreModel()
    moduleCoreBase()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.Android.CONSTRAINT_LAYOUT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
    implementation(Libraries.WEAR)
    compileOnly(Libraries.COMPILE_WEARABLE)
}