plugins {
    androidLibrary()
    kotlinAndroid()
}

dependencies {
    implementation(Libraries.KOTLIN)
    implementation(Libraries.DataStore)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)

}