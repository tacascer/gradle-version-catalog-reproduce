dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }
    versionCatalogs {
        create("libs3") {
            from("com.example:catalog1:latest.release")
        }
    }
}