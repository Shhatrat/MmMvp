plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
    kotlinAndroidExtensions()
}

dependencies {

    moduleCoreBase()
    moduleCoreApi()
    moduleCoreModel()
    moduleCoreRealm()
    moduleExampleFeature()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.RxJava)
    implementation(Libraries.KOIN)
    implementation(Libraries.Retrofit)
    implementation(Libraries.MATERIAL)
}