# Bach + JavaFX App

A demo of building a modular application with [Bach] based on [HelloFX/CLI](https://github.com/openjfx/samples/tree/master/HelloFX/CLI) by [OpenJFX].

## Prepare

- Download [JDK] 22 or later
- Clone this repository with submodules

## Build

Change into the base directory of your cloned project and call:

```shell script
java @build
```

## Run via Java Launcher


- Linux/Mac
```shell script
java --module-path .bach/out/main/modules:lib --module demo
```

- Windows
```shell script
java --module-path .bach\out\main\modules;lib --module demo
```

## Run via custom runtime image

- Linux/Mac
```shell script
.bach/out/main/image/bin/demo
```

- Windows
```shell script
.bach\out\main\image\bin\demo
```


[Bach]: https://github.com/sormuras/bach
[JDK]: https://jdk.java.net
[OpenJFX]: https://openjfx.io
