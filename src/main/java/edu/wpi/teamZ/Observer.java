package edu.wpi.teamZ;

import javafx.scene.control.Label;

public abstract class Observer {

  protected Label label;

  public Observer(Label label) {
    this.label = label;
  }
}
