plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

    moduleCoreApi()
    moduleCoreBase()
    moduleCoreModel()
    moduleCoreDatabase()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.Android.CONSTRAINT_LAYOUT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
}