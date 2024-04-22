import run.bach.Bach;
import run.bach.ToolCall;
import run.bach.ToolRunner;
import run.bach.workflow.Builder;
import run.bach.workflow.Cleaner;
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
            "demo/demo.Main",
            new Structure.DeclaredModule(
                folders.root("demo"), folders.root("demo", "module-info.java")));
    var runner = ToolRunner.ofSystem();
    var spaces = new Structure.Spaces(main);
    var workflow = new Workflow(folders, new Structure(basics, spaces), runner);
    return new Project(workflow);
  }

  @Override
  public boolean builderShouldInvokeCleanBeforeCompile() {
    return true;
  }

  @Override
  public void build() {
    Builder.super.build();
    link();
  }

  void link() {
    var folders = workflow.folders();
    var main = workflow.structure().spaces().space("main");
    var image = folders.out(main.name(), "image");
    var link =
        ToolCall.of("jlink")
            .add("--output", image)
            .add("--launcher", "demo=demo")
            .add("--add-modules", main.modules().names(","))
            .add("--module-path", main.toRuntimeSpace().toModulePath(folders).orElse("."));
    run(link);
  }
}
