package build;

import de.sormuras.bach.Bach;
import de.sormuras.bach.project.Library;
import de.sormuras.bach.project.Link;
import java.util.Locale;

class Build {

  public static void main(String... args) {
    var library = Library.of().withRequires("org.junit.platform.console").with(modulesOfJavaFX());

    Bach.of(project -> project.with(library)).buildProject();
  }

  static <T> T of(T linux, T mac, T windows) {
    var os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    if (os.contains("win")) return windows;
    if (os.contains("mac")) return mac;
    return linux;
  }

  static Link[] modulesOfJavaFX() {
    return new Link[] {linkJavaFxBase(), linkJavaFxControls(), linkJavaFxGraphics()};
  }

  static Link linkJavaFxBase() {
    var platform = of("linux", "mac", "win");
    var checksum =
        of(
            "50505c5915076fde97f5d61b588e2481",
            "77501f1d68b7d8e1d6cf0f177fa8e5c9",
            "47b5c7aef0cb9bffc7c5c5bf00e5c872");
    return Link.ofCentral("javafx.base", "org.openjfx:javafx-base:14.0.1:" + platform)
        .withSize(of(751228, 751229, 751229))
        .withDigest("md5", checksum);
  }

  static Link linkJavaFxControls() {
    var platform = of("linux", "mac", "win");
    return Link.ofCentral("javafx.controls", "org.openjfx:javafx-controls:14.0.1:" + platform);
  }

  static Link linkJavaFxGraphics() {
    var platform = of("linux", "mac", "win");
    return Link.ofCentral("javafx.graphics", "org.openjfx:javafx-graphics:14.0.1:" + platform);
  }
}
