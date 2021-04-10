import org.gradle.api.artifacts.dsl.DependencyHandler

private const val IMPLEMENTATION = "implementation"
private const val PATH = "path"

fun DependencyHandler.moduleCoreBase() = project(":core:base")
fun DependencyHandler.moduleCoreApi() = project(":core:api")
fun DependencyHandler.moduleCoreRealm() = project(":core:database:realm")
fun DependencyHandler.moduleCoreRoom() = project(":core:database:room")
fun DependencyHandler.moduleCoreModel() = project(":core:model")
fun DependencyHandler.moduleCoreDatabase() = project(":core:database")
fun DependencyHandler.moduleExampleFeature() = project(":feature:examplefeature")
fun DependencyHandler.moduleExampleFeature2() = project(":feature:examplefeature2")
fun DependencyHandler.moduleCpp() = project(":cpp")

fun DependencyHandler.project(path: String) = add(IMPLEMENTATION, (project(mapOf(PATH to path))))