import com.github.sormuras.bach.project.Feature;
import com.github.sormuras.bach.project.ProjectInfo;

@ProjectInfo(
    version = "1",
    features = { Feature.GENERATE_CUSTOM_RUNTIME_IMAGE }
)
module build {
  requires com.github.sormuras.bach;
  provides com.github.sormuras.bach.project.ModuleLookup with build.JavaFX_16_ea_Modules;
}
