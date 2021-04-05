plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

    moduleCoreBase()
    moduleCoreModel()
    moduleCoreDatabase()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)

    implementation(Libraries.Room)
    kapt(Libraries.RoomCompiler)
}