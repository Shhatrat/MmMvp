import org.gradle.api.artifacts.dsl.DependencyHandler

interface DependenciesCollection {
    operator fun invoke(): Collection<String>
}

fun DependencyHandler.implementation(
    collection: DependenciesCollection,
    configuration: (dependencyNotation: Any) -> Unit = { add("implementation", it) }
) {
    collection().forEach(configuration)
}