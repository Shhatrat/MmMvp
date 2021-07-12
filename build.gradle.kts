import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.BuildType
import com.shhatrat.mmmvp.config.AppConfig
import com.shhatrat.mmmvp.config.AppConfig.BUILD_TOOLS_VERSION
import com.shhatrat.mmmvp.config.INJECTION_TYPE
import com.vanniktech.dependency.graph.generator.DependencyGraphGeneratorExtension
import de.mannodermaus.gradle.plugins.junit5.junitPlatform
import guru.nidi.graphviz.attribute.Color
import guru.nidi.graphviz.attribute.Style
import guru.nidi.graphviz.model.MutableNode
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    benManesGradleVersion()
    graphGenerator()
}

buildscript {
    val kotlin_version by extra("1.5.0")
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(BuildScript.Plugins.GMS)
        classpath(BuildScript.Plugins.KOTLIN)
        classpath(BuildScript.Plugins.JUNIT5)
        classpath(BuildScript.Plugins.ANDROID)
        classpath(BuildScript.Plugins.NAVIGATION)
        classpath(BuildScript.Plugins.GRAPH_VISUALIZER)
        classpath(BuildScript.Plugins.PROGUARD_GENERATOR)
        classpath(BuildScript.Plugins.REALM)
        classpath(BuildScript.Plugins.VERSIONS)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("http://jitpack.io/")
    }
}

subprojects {
    addKotlinCompilerFlags()
    forceDependencyVersions()
    afterEvaluate {
        extensions
            .findByType(TestedExtension::class.java)
            ?.apply {
                enableExperimentalKotlinExtensions()
                defaultConfig {
                    versionCode = AppConfig.VERSION_CODE
                    versionName = AppConfig.VERSION_NAME
                    minSdkVersion(AppConfig.MIN_SDK)
                    targetSdkVersion(AppConfig.TARGET_SDK)
                }
                configureBuildTypes()
                configureFlavors()
                buildFeatures.viewBinding = true

                compileSdkVersion(AppConfig.TARGET_SDK)
                buildToolsVersion(BUILD_TOOLS_VERSION)

                sourceSets.forEach { sourceSet ->
                    sourceSet.java.srcDir("src/${sourceSet.name}/kotlin")
                }

                with(compileOptions) {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
                packagingOptions {
                    exclude("META-INF/DEPENDENCIES")
                    exclude("META-INF/AL2.0")
                    exclude("META-INF/LGPL2.1")
                }
                configureSpek(this)
                enableDesugaring(this)

                if (group.toString().contains("feature", ignoreCase = true)) {
                    dependencies.add("implementation", Libraries.EDGE_TO_EDGE)
                }
            }
    }
}

// Task name is generateDependencyGraphModules.
dependencyGraphGenerator {
    generators = listOf(DependencyGraphGeneratorExtension.Generator(
        name = "Modules",
        children = { false },
        include = { dependency ->
            dependency.moduleGroup.startsWith(
                "finances",
                ignoreCase = true
            )
        },
        dependencyNode = { node: MutableNode, _: ResolvedDependency ->
            node.add(Style.FILLED, Color.rgb("#FFCB2B"))
        }

    ))
}

fun Project.enableDesugaring(testedExtension: TestedExtension) {
    testedExtension.compileOptions.isCoreLibraryDesugaringEnabled = true
    dependencies.add(
        "coreLibraryDesugaring",
        "com.android.tools:desugar_jdk_libs:1.1.1"
    )
}

/**
 * Configure test options required for running Spek on android and add tests dependencies.
 */
fun Project.configureSpek(testedExtension: TestedExtension) {
    plugins.apply("de.mannodermaus.android-junit5")
    with(testedExtension) {
        testOptions {
            junitPlatform.filters.includeEngines("spek2")
            unitTests {
                all { test ->
                    test.apply {
                        systemProperty("kotlinx.coroutines.debug", "on")
                        testLogging.setEvents(setOf("passed", "skipped", "failed"))
                    }
                }
            }
        }
    }
    dependencies {
        add("testImplementation", Libraries.Tests.JUPITER_API)
        add("testRuntimeOnly", Libraries.Tests.JUPITER_ENGINE)

        add("testImplementation", Libraries.Tests.SPEK_JVM)
        add("testImplementation", Libraries.Tests.SPEK_RUNNER)
        add("testImplementation", Libraries.Tests.KOTLIN_REFLECT)

        add("testImplementation", Libraries.Tests.MOCKK)
        add("testImplementation", Libraries.Tests.STRIKT)
        add("testImplementation", Libraries.Tests.FILE_PEEK)
        add("testImplementation", Libraries.Tests.ASSERTIONS)
    }
}

fun TestedExtension.configureFlavors() {
    flavorDimensions("version")
    productFlavors {
        com.shhatrat.mmmvp.config.FlavorTypes.values().forEach { type ->
            create("${type.name}_") {
                addBuildConfigField(
                    com.android.builder.internal.ClassFieldImpl(
                        "String",
                        INJECTION_TYPE,
                        "\"${type.name}\""
                    )
                )
            }
        }
    }
}

// Set build types for android module.
fun TestedExtension.configureBuildTypes() {

    fun BuildType.configProguard(isLibrary: Boolean): BuildType {
        return if (isLibrary) {
            consumerProguardFile(file("proguard-rules.pro"))
        } else {
            proguardFiles(
                file("proguard-rules.pro"),
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }
    }

    val isLibrary = this is LibraryExtension

    buildTypes {
        maybeCreate(AppConfig.BuildTypes.RELEASE.name).apply {
            isMinifyEnabled = true
            isDebuggable = false
            configProguard(isLibrary)
        }
        maybeCreate(AppConfig.BuildTypes.DEBUG.name).apply {
            isMinifyEnabled = false
            isDebuggable = true
            configProguard(isLibrary)
        }
        maybeCreate(AppConfig.BuildTypes.DEV.name).apply {
            isDebuggable = false
        }
    }
}

fun Project.addKotlinCompilerFlags() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
            kotlinOptions.freeCompilerArgs += listOf(
                "-XXLanguage:+InlineClasses",
                "-Xallow-result-return-type",
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
            )
        }
    }
}

fun Project.enableExperimentalKotlinExtensions() {
    extensions.findByType(AndroidExtensionsExtension::class)?.isExperimental = true
}

fun Project.forceDependencyVersions() {
    configurations.all {
        resolutionStrategy {
            force(Libraries.KOTLIN)
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}