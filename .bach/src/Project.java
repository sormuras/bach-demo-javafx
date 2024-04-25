import run.bach.workflow.Builder;
import run.bach.workflow.Workflow;

record Project(Workflow workflow) implements Builder {
  static Project ofCurrentWorkingDirectory() {
    return new Project(
        Workflow.ofCurrentWorkingDirectory()
            .withName("bach-demo-javafx")
            .withVersion("99")
            .withMainSpace(
                main ->
                    main.withModule("demo", "demo/module-info.java")
                        .withLauncher("demo=demo/demo.Main")
                        .withCompileRuntimeImage()));
  }

  @Override
  public boolean builderDoesCleanAtTheBeginning() {
    return true;
  }
}
