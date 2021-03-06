import com.shhatrat.mmmvp.config.AppConfig.APPLICATION_ID

plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
}

android{
    defaultConfig{
        applicationId =  APPLICATION_ID
    }
}

dependencies {

    moduleCoreBase()
    moduleNavigation()
    moduleCoreApi()
    moduleCoreModel()
    moduleCoreRealm()
    moduleCoreRoom()
    moduleCpp()
    moduleWearManager()
    moduleExampleFeature()
    moduleExampleFeature2()
    moduleDataStore()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.RxJava)
    implementation(Libraries.KOIN)
    implementation(Libraries.Retrofit)
    implementation(Libraries.MATERIAL)
}