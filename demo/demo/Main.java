package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {
    var javaVersion = SystemInfo.javaVersion();
    var javafxVersion = SystemInfo.javafxVersion();

    var label = new Label("Hello, JavaFX " + javafxVersion + "! (Java " + javaVersion + ")");
    var scene = new Scene(new StackPane(label), 640, 480);
    stage.setScene(scene);
    stage.show();
    stage.setTitle(Main.class.getModule().getDescriptor().toNameAndVersion());
  }

  public static void main(String[] args) {
    launch();
  }
}
