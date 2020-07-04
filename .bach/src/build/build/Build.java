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

  // https://repo.maven.apache.org/maven2/org/openjfx
  static Link[] modulesOfJavaFX() {
    var version = "14.0.1";
    return new Link[] {
      linkJavaFX_14_0_1_BaseModuleWithSizeAndChecksumPerPlatform(),
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

  // https://repo.maven.apache.org/maven2/org/openjfx/javafx-base/14.0.1
  static Link linkJavaFX_14_0_1_BaseModuleWithSizeAndChecksumPerPlatform() {
    var md5Linux = "50505c5915076fde97f5d61b588e2481";
    var md5MacOS = "77501f1d68b7d8e1d6cf0f177fa8e5c9";
    var md5Windows = "47b5c7aef0cb9bffc7c5c5bf00e5c872";
    return linkModuleOfJavaFX("base", "14.0.1")
        .withSize(of(751228, 751229, 751229))
        .withDigest("md5", of(md5Linux, md5MacOS, md5Windows));
  }

  static <T> T of(T linux, T mac, T windows) {
    var os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    if (os.contains("win")) return windows;
    if (os.contains("mac")) return mac;
    return linux;
  }
}
