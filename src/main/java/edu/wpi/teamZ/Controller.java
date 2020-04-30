package edu.wpi.teamZ;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

  @FXML Label hex, octal, binary;

  @FXML TextField number;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    Subject subject = new Subject();

    subject.addListener(new HexObserver(hex));
    subject.addListener(new BinaryObserver(binary));
    subject.addListener(new OctalObserver(octal));

    number
        .textProperty()
        .addListener(
            (observableValue, oldValue, newValue) -> {
              if (!newValue.isEmpty()) {
                subject.setState(Integer.parseInt(number.getText()));
              } else {
                subject.setState(0);
              }
            });
  }
}
