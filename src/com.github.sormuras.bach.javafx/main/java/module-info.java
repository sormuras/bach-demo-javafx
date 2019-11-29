// --main-class com.github.sormuras.bach.javafx.App
module com.github.sormuras.bach.javafx {
  requires javafx.base;
  requires javafx.controls;
  requires javafx.graphics;

  exports com.github.sormuras.bach.javafx to javafx.graphics;
}
