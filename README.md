# gradle-version-catalog-reproduce

The goal is to reproduce an issue in the version catalog publishing and lock
files.

The issue is that version catalogs added in `buildSrc/settings.gradle.kts` will generate a lockfile at the root level
called `settings-gradle.lockfile`. This lock file will then be used by the root project's build scripts, overriding
whatever version catalog is specified in the root `settings.gradle.kts`.

## Project structure

The `catalog1` and `catalog2` projects are two different version catalogs.

The `lock` project consumes both catalogs as remote dependencies.

`lock/buildSrc` consumes `catalog1` and the root `lock` consumes `catalog2`

## Steps to reproduce

```shell
(
    cd catalog1
    ./gradlew publishToMavenLocal
)

(
    cd ../catalog2
    ./gradlew publishToMavenLocal
)
  
(
    cd lock
    ./gradlew dependencies --write-locks
)
```

This should create a file settings.lockfile with only the a line for `catalog1`.
