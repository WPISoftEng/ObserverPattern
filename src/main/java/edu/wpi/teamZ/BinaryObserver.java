package edu.wpi.teamZ;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Label;

public class BinaryObserver extends Observer implements PropertyChangeListener {

  public BinaryObserver(Label label) {
    super(label);
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    if ("state".equals(event.getPropertyName())) {
      label.setText(Integer.toBinaryString((int) event.getNewValue()));
    }
  }
}
