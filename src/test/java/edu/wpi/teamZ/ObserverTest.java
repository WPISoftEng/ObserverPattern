package edu.wpi.teamZ;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testfx.api.FxAssert.verifyThat;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class ObserverTest extends ApplicationTest {

  @Override
  public void start(Stage stage) throws IOException {
    Parent sceneRoot = FXMLLoader.load(getClass().getResource("observer.fxml"));
    Scene scene = new Scene(sceneRoot);
    stage.setScene(scene);
    stage.show();
  }

  @Test
  public void testObserver() {
    clickOn(".text");
    write("12345");
    assertAll(
        () ->
            verifyThat("#hex", node -> ((Label) node).getText().equals(Integer.toHexString(12345))),
        () ->
            verifyThat(
                "#binary", node -> ((Label) node).getText().equals(Integer.toBinaryString(12345))),
        () ->
            verifyThat(
                "#octal", node -> ((Label) node).getText().equals(Integer.toOctalString(12345))));
  }
}
