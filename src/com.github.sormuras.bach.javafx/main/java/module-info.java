// --main-class com.github.sormuras.bach.javafx.App
module com.github.sormuras.bach.javafx {
  requires javafx.base /*14-ea+4*/;
  requires javafx.controls /*14-ea+4*/;
  requires javafx.graphics /*14-ea+4*/;

  exports com.github.sormuras.bach.javafx to javafx.graphics;
}
