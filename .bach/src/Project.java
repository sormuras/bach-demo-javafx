import run.bach.workflow.Builder;
import run.bach.workflow.Starter;
import run.bach.workflow.Workflow;
import run.info.bach.JavaFX;

record Project(Workflow workflow) implements Builder, Starter {
  static Project ofCurrentWorkingDirectory() {
    return new Project(
        Workflow.ofCurrentWorkingDirectory()
            .withName("bach-demo-javafx")
            .withVersion("99")
            .withMainSpace(
                main ->
                    main.withModule("demo", "demo/module-info.java")
                        .withLauncher("demo=demo/demo.Main")
                        .withCompileRuntimeImage())
            .withLibrary(JavaFX.version("21.0.3")));
  }

  @Override
  public boolean builderDoesCleanAtTheBeginning() {
    return true;
  }
}
