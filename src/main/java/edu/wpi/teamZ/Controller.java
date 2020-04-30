package edu.wpi.teamZ;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
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

    hex.textProperty()
        .bind(
            Bindings.createStringBinding(
                () -> Integer.toHexString(subject.stateProperty().getValue()),
                subject.stateProperty()));

    octal
        .textProperty()
        .bind(
            Bindings.createStringBinding(
                () -> Integer.toOctalString(subject.stateProperty().getValue()),
                subject.stateProperty()));

    binary
        .textProperty()
        .bind(
            Bindings.createStringBinding(
                () -> Integer.toBinaryString(subject.stateProperty().getValue()),
                subject.stateProperty()));

    number
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              if (newValue.isEmpty()) {
                subject.setState(0);
              } else {
                subject.setState(Integer.parseInt(newValue));
              }
            });
  }
}
