package edu.wpi.teamZ;

import javafx.beans.property.SimpleIntegerProperty;

public class Subject {

  private final SimpleIntegerProperty state = new SimpleIntegerProperty();

  SimpleIntegerProperty stateProperty() {
    return state;
  }

  void setState(int newValue) {
    state.set(newValue);
  }
}
