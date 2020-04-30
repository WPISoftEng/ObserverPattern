package edu.wpi.teamZ;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Subject {

  private final PropertyChangeSupport support = new PropertyChangeSupport(this);
  private int state;

  public void setState(int newState) {
    int oldState = this.state;
    this.state = newState;
    this.support.firePropertyChange("state", oldState, newState);
  }

  public void addListener(PropertyChangeListener listener) {
    this.support.addPropertyChangeListener(listener);
  }
}
