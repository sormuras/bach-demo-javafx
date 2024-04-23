import run.bach.Bach;
import run.bach.ToolRunner;
import run.bach.workflow.Builder;
import run.bach.workflow.Structure;
import run.bach.workflow.Workflow;

record Project(Workflow workflow) implements Builder {
  static final String VERSION = System.getProperty("--project-version", "0-ea");

  static Project ofCurrentWorkingDirectory() {
    var basics = new Structure.Basics("bach-demo-javafx", VERSION);
    var folders = Bach.Folders.ofCurrentWorkingDirectory();
    var main =
        new Structure.Space(
                "main",
                0,
                "demo=demo/demo.Main",
                new Structure.DeclaredModule(
                    folders.root("demo"), folders.root("demo", "module-info.java")))
            .with(Structure.Space.Flag.IMAGE);
    var runner = ToolRunner.ofSystem();
    var spaces = new Structure.Spaces(main);
    var workflow = new Workflow(folders, new Structure(basics, spaces), runner);
    return new Project(workflow);
  }

  @Override
  public boolean builderShouldInvokeCleanBeforeCompile() {
    return true;
  }
}
