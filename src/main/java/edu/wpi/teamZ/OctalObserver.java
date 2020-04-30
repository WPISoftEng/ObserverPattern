package edu.wpi.teamZ;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Label;

public class OctalObserver extends Observer implements PropertyChangeListener {

  public OctalObserver(Label label) {
    super(label);
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    if ("state".equals(event.getPropertyName())) {
      label.setText(Integer.toOctalString((int) event.getNewValue()));
    }
  }
}
