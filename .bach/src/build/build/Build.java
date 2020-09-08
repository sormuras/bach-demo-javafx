package build;

import de.sormuras.bach.Bach;
import de.sormuras.bach.project.Library;
import de.sormuras.bach.project.Link;
import java.util.Locale;

public class Build {

  public static void main(String... args) {
    var library = Library.of().withRequires("org.junit.platform.console").with(modulesOfJavaFX());

    Bach.of(project -> project.library(library)).build();
  }

  // https://repo.maven.apache.org/maven2/org/openjfx
  static Link[] modulesOfJavaFX() {
    var version = "15";
    return new Link[] {
      linkJavaFX_15_BaseModuleWithSizeAndChecksumPerPlatform(),
      linkModuleOfJavaFX("controls", version),
      linkModuleOfJavaFX("graphics", version)
    };
  }

  static Link linkModuleOfJavaFX(String suffix, String version) {
    var group = "org.openjfx";
    var platform = of("linux", "mac", "win");
    var coordinates = String.join(":", group, "javafx-" + suffix, version, platform);
    return Link.ofCentral("javafx." + suffix, coordinates);
  }

  // https://repo.maven.apache.org/maven2/org/openjfx/javafx-base/15
  static Link linkJavaFX_15_BaseModuleWithSizeAndChecksumPerPlatform() {
    var md5Linux = "e5f060c68f8a0237fcad96f5a6691921";
    var md5MacOS = "478e81da78ce24efdc841dd78ed164e8";
    var md5Windows = "8afbd4ffb1d066c8c09788239ce93e31";
    return linkModuleOfJavaFX("base", "15")
        .withSize(of(745516, 745453, 745515))
        .withDigest("md5", of(md5Linux, md5MacOS, md5Windows));
  }

  static <T> T of(T linux, T mac, T windows) {
    var os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    if (os.contains("win")) return windows;
    if (os.contains("mac")) return mac;
    return linux;
  }
}
