open /*test*/ module com.github.sormuras.bach.javafx /*extends "main" module*/ {

  // test

  requires org.junit.jupiter;

  // main

  requires javafx.base;
  requires javafx.controls;
  requires javafx.graphics;

  exports com.github.sormuras.bach.javafx to javafx.graphics;
}
