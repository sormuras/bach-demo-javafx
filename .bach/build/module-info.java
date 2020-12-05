import build.JavaFX_16_ea_Modules;
import com.github.sormuras.bach.project.Feature;
import com.github.sormuras.bach.project.ProjectInfo;
import com.github.sormuras.bach.project.ProjectInfo.ExternalModules;
import com.github.sormuras.bach.project.ProjectInfo.Tweak;

@ProjectInfo(
    name = "bach-javafx",
    version = "1",
    features = Feature.GENERATE_CUSTOM_RUNTIME_IMAGE,
    externalModules = @ExternalModules( lookups = JavaFX_16_ea_Modules.class ),
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
open module build {
  requires com.github.sormuras.bach;
}
