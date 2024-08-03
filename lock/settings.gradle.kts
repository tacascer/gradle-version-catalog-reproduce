/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.9/userguide/multi_project_builds.html in the Gradle documentation.
 */

rootProject.name = "lock"

dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }
    versionCatalogs {
        create("libs") {
            from("com.example:catalog1:1.0.0")
        }
        create("libs2") {
            from("com.example:catalog2:1.0.0")
        }
    }
    defaultLibrariesExtensionName = "projectLibs"
}
