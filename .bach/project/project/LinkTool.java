package project;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.spi.ToolProvider;
import run.bach.ProjectTool;
import run.duke.Workbench;

public class LinkTool extends ProjectTool {
  public LinkTool() {}

  public LinkTool(Workbench workbench) {
    super(workbench);
  }

  @Override
  public String name() {
    return "link";
  }

  @Override
  public ToolProvider provider(Workbench workbench) {
    return new LinkTool(workbench);
  }

  @Override
  public int run(PrintWriter out, PrintWriter err, String... args) {
    var main = project().spaces().space("main");
    var image = folders().out(main.name(), "image");
    if (Files.exists(image)) run("duke", duke -> duke.with("tree", "--mode", "delete").with(image));
    run(
        "jlink",
        link ->
            link.with("--output", image)
                .with("--launcher", "demo=demo")
                .with("--add-modules", main.modules().names(","))
                .with("--module-path", main.toRuntimeSpace().toModulePath(folders()).orElse(".")));
    return 0;
  }
}
