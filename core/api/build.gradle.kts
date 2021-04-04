plugins {
    androidLibrary()
    kotlinAndroid()
}

dependencies {

    moduleCoreModel()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.RxJava)
    implementation(Libraries.KOIN)
    implementation(Libraries.Retrofit)

}