import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.external.JavaFX;

class build {
  public static void main(String... args) {
    try (var bach = new Bach(args)) {
      var grabber = bach.grabber(JavaFX.version("18-ea+3"));
      grabber.grabExternalModules("javafx.base", "javafx.controls");
      grabber.grabMissingExternalModules();

      var builder = bach.builder().conventional("com.github.sormuras.bach.javafx");
      builder.compile(javac -> javac.with("--module-version", "1"));
      builder.link(link -> link.with("--launcher", "bach-javafx=com.github.sormuras.bach.javafx"));
    }
  }
}
