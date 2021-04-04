plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
    realmAndroid()
}

dependencies {

    moduleCoreBase()
    moduleCoreModel()
    moduleCoreDatabase()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
}