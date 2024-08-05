dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }
    versionCatalogs {
        create("libs") {
            from("com.example:catalog1:latest.release")
        }
    }
}