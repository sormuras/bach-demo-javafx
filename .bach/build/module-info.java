import com.github.sormuras.bach.ProjectInfo;
import com.github.sormuras.bach.ProjectInfo.Library;
import com.github.sormuras.bach.ProjectInfo.Library.Link;
import com.github.sormuras.bach.ProjectInfo.Library.Searcher;
import com.github.sormuras.bach.ProjectInfo.Main;
import com.github.sormuras.bach.ProjectInfo.Test;
import com.github.sormuras.bach.ProjectInfo.Tweak;
import com.github.sormuras.bach.module.ModuleSearcher.JavaFXSearcher;
import com.github.sormuras.bach.module.ModuleSearcher.JUnitJupiterSearcher;
import com.github.sormuras.bach.module.ModuleSearcher.JUnitPlatformSearcher;

@ProjectInfo(
    name = "bach-javafx",
    version = "1",
    library =
        @Library(
            requires = {"org.junit.platform.console"},
            links = {
              @Link(module = "org.apiguardian.api", target = "org.apiguardian:apiguardian-api:1.1.0"),
              @Link(module = "org.opentest4j", target = "org.opentest4j:opentest4j:1.2.0"),
            },
            searchers = {
              @Searcher(with = JavaFXSearcher.class, version = "16-ea+4"),
              @Searcher(with = JUnitJupiterSearcher.class, version = "5.7.0"),
              @Searcher(with = JUnitPlatformSearcher.class, version = "1.7.0"),
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
