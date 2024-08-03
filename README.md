# gradle-version-catalog-reproduce

The goal was to reproduce an issue in the version catalog publishing and lock
files

## Project structure

The `catalog1` and `catalog2` projects are two different version catalogs.

The `lock` project consumes both catalogs as remote dependencies.

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

This should create a file settings.lockfile with only the first version catalog
locked.
