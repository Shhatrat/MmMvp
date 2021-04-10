import BuildScript.Versions.KOTLIN_VER
import BuildScript.Versions.NAVIGATION_VER

object BuildScript {

    object Versions {
        const val KOTLIN_VER = "1.4.10"
        const val NAVIGATION_VER = "2.3.2"
    }


    object Plugins {
        const val GMS = "com.google.gms:google-services:4.3.4"
        const val ANDROID = "com.android.tools.build:gradle:4.1.1"
        const val JUNIT5 = "de.mannodermaus.gradle.plugins:android-junit5:1.7.0.0"
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VER"
        const val NAVIGATION =
            "androidx.navigation:navigation-safe-args-gradle-plugin:$NAVIGATION_VER"
        const val GRAPH_VISUALIZER = "com.vanniktech:gradle-dependency-graph-generator-plugin:0.5.0"
        const val PROGUARD_GENERATOR =
            "gradle.plugin.ru.cleverpumpkin.proguard-dictionaries-generator:plugin:1.0.8"
        const val REALM = "io.realm:realm-gradle-plugin:10.0.1"
    }

}

object Libraries {

    const val EDGE_TO_EDGE = "de.halfbit:edge-to-edge:1.0-rc1"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$KOTLIN_VER"

    object Android {

        object Lifecycle : DependenciesCollection {

            private const val VER = "2.3.0-rc01"
            private const val ARTIFACT = "androidx.lifecycle"

            override fun invoke(): Collection<String> {
                return listOf(
                    "$ARTIFACT:lifecycle-common-java8:$VER",
                    "$ARTIFACT:lifecycle-extensions:2.2.0",
                    "$ARTIFACT:lifecycle-viewmodel-ktx:$VER",
                    "$ARTIFACT:lifecycle-livedata-ktx:$VER"
                )
            }

        }

        const val APPCOMPAT = "androidx.appcompat:appcompat:1.3.0-beta01"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"

        object Navigation : DependenciesCollection {

            private const val ARTIFACT = "androidx.navigation"

            override fun invoke(): Collection<String> {
                return listOf(
                    "$ARTIFACT:navigation-ui-ktx:$NAVIGATION_VER",
                    "$ARTIFACT:navigation-runtime:$NAVIGATION_VER",
                    "$ARTIFACT:navigation-fragment-ktx:$NAVIGATION_VER"
                )
            }

        }

    }

    object RxJava : DependenciesCollection {

        override fun invoke(): Collection<String> {
            return listOf(
                "io.reactivex.rxjava3:rxjava:3.0.6",
                "io.reactivex.rxjava3:rxandroid:3.0.0",
                "io.reactivex.rxjava3:rxkotlin:3.0.1",
                "com.jakewharton.rxrelay3:rxrelay:3.0.0"
            )
        }

    }

    const val KOIN = "org.koin:koin-android:2.2.2"
    const val MATERIAL = "com.google.android.material:material:1.3.0"
    const val BUILD_GRADLE = "com.android.tools.build:gradle:4.1.1"


    const val GMS_WEARABLE = "com.google.android.gms:play-services-wearable:17.0.0"
    const val GSON = "com.google.code.gson:gson:2.8.6"
    const val WEAR = "androidx.wear:wear:1.1.0"
    const val COMPILE_WEARABLE = "com.google.android.wearable:wearable:2.8.1"


    object Retrofit : DependenciesCollection {

        override fun invoke(): Collection<String> {
            return listOf(
                "com.squareup.retrofit2:retrofit:2.9.0",
                "com.squareup.retrofit2:converter-gson:2.9.0",
                "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0",
                "com.squareup.okhttp3:logging-interceptor:3.14.7"

            )
        }

    }

    private val room_version = "2.3.0-rc01"

    object Room : DependenciesCollection {
        override fun invoke(): Collection<String> {
            return listOf(
                "androidx.room:room-runtime:$room_version",
                "androidx.room:room-ktx:$room_version",
                "androidx.room:room-rxjava3:2.3.0-rc01"
            )
        }
    }

    val RoomCompiler = "androidx.room:room-compiler:$room_version"

    object Tests {

        private const val JUNIT_VER = "5.7.0"
        private const val SPEK_VER = "2.0.15"

        const val MOCKK = "io.mockk:mockk:1.9.3"
        const val STRIKT = "io.strikt:strikt-core:0.28.1"

        // It's required for Strikt.
        const val FILE_PEEK = "com.christophsturm:filepeek:0.1.2"
        const val ASSERTIONS = "org.jetbrains.kotlin:kotlin-test:$KOTLIN_VER"
        const val SPEK_JVM = "org.spekframework.spek2:spek-dsl-jvm:$SPEK_VER"
        const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:$KOTLIN_VER"
        const val SPEK_RUNNER = "org.spekframework.spek2:spek-runner-junit5:$SPEK_VER"

        const val JUPITER_API = "org.junit.jupiter:junit-jupiter-api:$JUNIT_VER"
        const val JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:$JUNIT_VER"
    }
}