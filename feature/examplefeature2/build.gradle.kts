plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
    kotlinAndroidExtensions()
}

dependencies {

    moduleCoreModel()

    implementation(Libraries.KOTLIN)
    implementation(Libraries.Android.APPCOMPAT)
    implementation(Libraries.Android.CONSTRAINT_LAYOUT)
    implementation(Libraries.MATERIAL)
}