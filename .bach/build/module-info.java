import com.github.sormuras.bach.ProjectInfo;
import com.github.sormuras.bach.ProjectInfo.Library;
import com.github.sormuras.bach.ProjectInfo.Library.Searcher;
import com.github.sormuras.bach.ProjectInfo.Main;
import com.github.sormuras.bach.ProjectInfo.Tweak;
import com.github.sormuras.bach.module.ModuleSearcher.JavaFXSearcher;

@ProjectInfo(
    name = "bach-javafx",
    version = "1",
    library = @Library(searchers = {@Searcher(with = JavaFXSearcher.class, version = "16-ea+4")}),
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
            }))
module build {
  requires com.github.sormuras.bach;
}
