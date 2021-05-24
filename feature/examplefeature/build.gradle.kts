plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

    moduleCoreApi()
    moduleNavigation()
    moduleCoreBase()
    moduleCoreModel()
    moduleCoreDatabase()
    moduleCpp()
    moduleWearManager()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.Android.CONSTRAINT_LAYOUT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)
}