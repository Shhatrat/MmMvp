plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

    moduleCoreBase()
    moduleCoreModel()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
    implementation(Libraries.RxJava)

    val room_version = "2.2.5"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    implementation("androidx.room:room-rxjava3:2.3.0-rc01")
    kapt("androidx.room:room-compiler:$room_version")

}