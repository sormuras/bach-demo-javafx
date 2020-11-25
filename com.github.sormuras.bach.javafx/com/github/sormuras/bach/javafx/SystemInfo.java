package com.github.sormuras.bach.javafx;

class SystemInfo {

  static String javaVersion() {
    return System.getProperty("java.version");
  }

  static String javafxVersion() {
    return System.getProperty("javafx.version");
  }
}
