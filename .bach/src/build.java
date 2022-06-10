import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.ToolCall;

class build {
  public static void main(String... args) {
    System.out.println(">>");

    var bach = Bach.ofSystem(args);
    bach.run("com.github.sormuras.bach/build");

    linkCustomRuntimeImage(bach);

    System.out.println("<<");
  }

  static void linkCustomRuntimeImage(Bach bach) {
    var main = bach.project().spaces().main();
    var test = bach.project().spaces().test();
    var paths = bach.configuration().paths();
    var image = paths.out(main.name(), "image");
    bach.run("tree", "--mode", "CLEAN", image);
    bach.run(
        ToolCall.of("jlink")
            .with("--output", image)
            .with("--add-modules", main.modules().names(","))
            .with("--module-path", test.toModulePath(paths).orElseThrow()));
  }
}
