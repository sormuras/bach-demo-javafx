# Bach + JavaFX App

A demo of building a modular application with [Bach.java] based on [HelloFX/CLI](https://github.com/openjfx/samples/tree/master/HelloFX/CLI) by [OpenJFX].

## Prepare

- Download [JDK] 16 or later
- Clone this repository

## Build

Change into the base directory of your cloned project and call:

```shell script
java --module-path .bach/cache --module com.github.sormuras.bach build
```

## Run via custom runtime image

- Linux/Mac
```shell script
.bach/workspace/image/bin/bach-javafx
```

- Windows
```shell script
.bach\workspace\image\bin\bach-javafx[.bat]
```


[Bach.java]: https://github.com/sormuras/bach
[JDK]: https://jdk.java.net
[OpenJFX]: https://openjfx.io
