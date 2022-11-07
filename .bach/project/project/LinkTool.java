package project;

import run.bach.ToolOperator;

import java.nio.file.Files;

public record LinkTool(String name) implements ToolOperator {
  public LinkTool() {
    this("link");
  }

  @Override
  public void run(Operation operation) {
    var bach = operation.bach();
    var main = bach.project().spaces().main();
    var test = bach.project().spaces().test();
    var paths = bach.paths();
    var image = paths.out(main.name(), "image");
    if (Files.exists(image)) {
      bach.run("tree", tree -> tree.with("--mode", "delete").with(image));
    }
    bach.run(
        "jlink",
        link ->
            link.with("--output", image)
                .with("--launcher", "bach-demo-javafx=com.github.sormuras.bach.javafx")
                .with("--add-modules", main.modules().names(","))
                .with("--module-path", test.toModulePath(paths).orElseThrow()));
  }
}
