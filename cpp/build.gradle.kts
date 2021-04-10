plugins {
    androidLibrary()
    kotlinAndroid()
}

android {
    defaultConfig {
        externalNativeBuild {
            cmake {
                cppFlags.clear()
            }
        }
    }

    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
            version = "3.10.2"
        }
    }
}

dependencies {

    implementation(Libraries.KOTLIN)
    implementation(Libraries.KOIN)
}