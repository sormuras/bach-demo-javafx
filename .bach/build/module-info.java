import com.github.sormuras.bach.project.Feature;
import com.github.sormuras.bach.project.ProjectInfo;
import com.github.sormuras.bach.project.ProjectInfo.Tweak;

@ProjectInfo(
    name = "bach-javafx",
    version = "1",
    features = Feature.GENERATE_CUSTOM_RUNTIME_IMAGE,
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
    })
module build {
  requires com.github.sormuras.bach;
  provides com.github.sormuras.bach.project.ModuleLookup with build.JavaFX_16_ea_Modules;
}
