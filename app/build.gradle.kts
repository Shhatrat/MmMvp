plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

    moduleCoreBase()
    moduleCoreApi()
    moduleCoreModel()
    moduleCoreRealm()
    moduleCoreRoom()
    moduleExampleFeature()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.RxJava)
    implementation(Libraries.KOIN)
    implementation(Libraries.Retrofit)
    implementation(Libraries.MATERIAL)
}