package project;

import run.bach.ToolOperator;

public record BuildTool(String name) implements ToolOperator {
  public BuildTool() {
    this("build");
  }

  @Override
  public void run(Operation operation) {
    operation.run("run.bach/build");
    operation.run("link");
  }
}
