# Bach + JavaFX App

[Bach.java] demo based on [HelloFX/CLI](https://github.com/openjfx/samples/tree/master/HelloFX/CLI) by [OpenJFX].

## Prepare

- Download [JDK] 11 or later
- Clone this repository
- Open a command shell and ensure `jshell --version` is working correctly

## Build

Change into the base directory of your cloned project and call:

```shell script
jshell https://sormuras.de/bach/build
```

## Run via Java Launcher

- Linux/Mac
```shell script
java --module-path .bach/workspace/modules:lib --module com.github.sormuras.bach.javafx
```

- Windows
```shell script
java --module-path .bach\workspace\modules;lib --module com.github.sormuras.bach.javafx
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
