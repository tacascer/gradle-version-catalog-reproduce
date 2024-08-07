# gradle-version-catalog-reproduce

The goal is to reproduce an issue in the version catalog publishing and lock
files.

The issue is that version catalogs added in `buildSrc/settings.gradle.kts` will generate a lockfile at the root level
called `settings-gradle.lockfile`. This lock file will then be used by the root project's build scripts, overriding
whatever version catalog is specified in the root `settings.gradle.kts`.

## Project structure

The `catalog1` and `catalog2` projects are two different version catalogs.

`lock/buildSrc/settings.gradle.kts` consumes `catalog1` and `lock/settings.gradle.kts` consumes `catalog2`

## Steps to reproduce

```shell
(
    cd catalog1
    ./gradlew publishToMavenLocal
)

(
    cd catalog2
    ./gradlew publishToMavenLocal
)
  
(
    cd lock
    rm -f settings-gradle.lockfile
    ./gradlew dependencies --write-locks
)
```

This should create a `lock/settings.lockfile` with only a line for `catalog1`:

```text
# This is a Gradle generated file for dependency locking.
# Manual edits can break the build and are not advised.
# This file is expected to be part of source control.
com.example:catalog1:1.0.0=incomingCatalogForLibs0
empty=
```

The expected behavior is that `lock/settings.lockfile` would contain a line for `catalog2`, since that's what `lock/settings.gradle.kts` is using
