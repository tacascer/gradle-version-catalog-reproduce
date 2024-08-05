dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }
    versionCatalogs {
        create("libs") {
            from("com.example:catalog1:latest.release")
        }
        create("libs2") {
            from("com.example:catalog2:latest.release")
        }
    }
}