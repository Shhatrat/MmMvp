plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}

dependencies {

   moduleCoreModel()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.Android.CONSTRAINT_LAYOUT)
    implementation(Libraries.MATERIAL)
}