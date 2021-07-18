import BuildScript.Versions.KOTLIN_VER
import BuildScript.Versions.NAVIGATION_VER

object BuildScript {

    object Versions {
        const val KOTLIN_VER = "1.5.21"
        const val NAVIGATION_VER = "2.4.0-alpha04"
    }

    object Plugins {
        const val GMS = "com.google.gms:google-services:4.3.8"
        const val ANDROID = "com.android.tools.build:gradle:4.1.1"
        const val JUNIT5 = "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1"
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VER"
        const val NAVIGATION =
            "androidx.navigation:navigation-safe-args-gradle-plugin:$NAVIGATION_VER"
        const val GRAPH_VISUALIZER = "com.vanniktech:gradle-dependency-graph-generator-plugin:0.5.0"
        const val PROGUARD_GENERATOR =
            "gradle.plugin.ru.cleverpumpkin.proguard-dictionaries-generator:plugin:1.0.8"
        const val REALM = "io.realm:realm-gradle-plugin:10.6.1"
        const val VERSIONS = "com.github.ben-manes:gradle-versions-plugin:0.39.0"
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

        const val APPCOMPAT = "androidx.appcompat:appcompat:1.4.0-alpha03"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.0-beta02"

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
                "io.reactivex.rxjava3:rxjava:3.0.13",
                "io.reactivex.rxjava3:rxandroid:3.0.0",
                "io.reactivex.rxjava3:rxkotlin:3.0.1",
                "com.jakewharton.rxrelay3:rxrelay:3.0.0"
            )
        }

    }

    const val KOIN = "io.insert-koin:koin-android:3.1.2"
    const val MATERIAL = "com.google.android.material:material:1.5.0-alpha01"

    const val GMS_WEARABLE = "com.google.android.gms:play-services-wearable:17.1.0"
    const val GSON = "com.google.code.gson:gson:2.8.7"
    const val WEAR = "androidx.wear:wear:1.2.0-alpha11"
    const val COMPILE_WEARABLE = "com.google.android.wearable:wearable:2.8.1"


    object Retrofit : DependenciesCollection {

        override fun invoke(): Collection<String> {
            return listOf(
                "com.squareup.retrofit2:retrofit:2.9.0",
                "com.squareup.retrofit2:converter-gson:2.9.0",
                "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0",
                "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2"
            )
        }

    }

    private val room_version = "2.4.0-alpha03"

    object Room : DependenciesCollection {
        override fun invoke(): Collection<String> {
            return listOf(
                "androidx.room:room-runtime:$room_version",
                "androidx.room:room-ktx:$room_version",
                "androidx.room:room-rxjava3:$room_version"
            )
        }
    }

    val RoomCompiler = "androidx.room:room-compiler:$room_version"

    object Tests {

        private const val JUNIT_VER = "5.8.0-M1"
        private const val SPEK_VER = "2.0.16"

        const val MOCKK = "io.mockk:mockk:1.12.0"
        const val STRIKT = "io.strikt:strikt-core:0.31.0"

        // It's required for Strikt.
        const val FILE_PEEK = "com.christophsturm:filepeek:0.1.3"
        const val ASSERTIONS = "org.jetbrains.kotlin:kotlin-test:$KOTLIN_VER"
        const val SPEK_JVM = "org.spekframework.spek2:spek-dsl-jvm:$SPEK_VER"
        const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:$KOTLIN_VER"
        const val SPEK_RUNNER = "org.spekframework.spek2:spek-runner-junit5:$SPEK_VER"

        const val JUPITER_API = "org.junit.jupiter:junit-jupiter-api:$JUNIT_VER"
        const val JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:$JUNIT_VER"
    }
}