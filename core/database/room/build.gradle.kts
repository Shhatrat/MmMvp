plugins {
    androidLibrary()
    kotlinAndroid()
}

dependencies {

    moduleCoreBase()
    moduleCoreModel()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
}