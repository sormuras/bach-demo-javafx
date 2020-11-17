import com.github.sormuras.bach.ProjectInfo;
import com.github.sormuras.bach.ProjectInfo.Library;
import com.github.sormuras.bach.ProjectInfo.Library.Link;
import com.github.sormuras.bach.ProjectInfo.Main;
import com.github.sormuras.bach.ProjectInfo.Test;
import com.github.sormuras.bach.ProjectInfo.Tweak;

@ProjectInfo(
    name = "bach-javafx",
    version = "1",
    library =
        @Library(
            requires = {"org.junit.jupiter", "org.junit.platform.console"},
            links = {
              @Link(
                  module = "javafx.base",
                  target = "org.openjfx:javafx-base:16-ea+4:${JAVAFX-PLATFORM}"),
              @Link(
                  module = "javafx.controls",
                  target = "org.openjfx:javafx-controls:16-ea+4:${JAVAFX-PLATFORM}"),
              @Link(
                  module = "javafx.graphics",
                  target = "org.openjfx:javafx-graphics:16-ea+4:${JAVAFX-PLATFORM}"),
            }),
    main =
        @Main(
            generateCustomRuntimeImage = true,
            tweaks = {
              @Tweak(
                  tool = "jar(com.github.sormuras.bach.javafx)",
                  args = {"--main-class", "com.github.sormuras.bach.javafx.Main"}),
              @Tweak(
                  tool = "jlink",
                  args = {
                    "--launcher",
                    "bach-javafx=com.github.sormuras.bach.javafx/com.github.sormuras.bach.javafx.Main",
                    "--no-header-files",
                    "--no-man-pages",
                    "--strip-debug"
                  }),
            }),
    test =
        @Test(
            tweaks =
                @Tweak(
                    tool = "javac",
                    args = {
                      "--patch-module",
                      "com.github.sormuras.bach.javafx=com.github.sormuras.bach.javafx/main/java"
                    })))
module build {
  requires com.github.sormuras.bach;
}
