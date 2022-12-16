package project;

import java.nio.file.Path;
import java.util.List;

import run.bach.Composer;
import run.bach.Project;
import run.duke.ToolOperator;

public class DemoComposer extends Composer {
  @Override
  public Project composeProject() {
    return new Project(
        new Project.Name("bach-demo-javafx"),
        new Project.Version("0-ea"),
        new Project.Space(
            "main", 0, "demo/demo.Main", new Project.DeclaredModule(Path.of("demo"))));
  }

  @Override
  public List<ToolOperator> composeOperators() {
    return List.of(new LinkTool());
  }
}
