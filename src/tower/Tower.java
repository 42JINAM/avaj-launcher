package tower;

import java.util.ArrayList;
import java.util.List;

import aircraft.*;

public class Tower {
  private List<Flyable> observers;
  protected List<Flyable> landed;

  public Tower() {
    observers = new ArrayList<>();
    landed = new ArrayList<>();
  }

  public void register(Flyable p_flyable) {
    Aircraft aircraft = (Aircraft) p_flyable;
    this.observers.add(p_flyable);
    aircraft.print(" registered to weather tower.");
  };

  public void unregister(Flyable p_flyable) {
    Aircraft aircraft = (Aircraft) p_flyable;
    this.observers.remove(p_flyable);
    aircraft.print(" unregistered from weather tower.");
  };

  protected void conditionChanged() {
    for (Flyable ele : observers) {
      Aircraft aircraft = (Aircraft) ele;
      aircraft.updateConditions();
      if(aircraft.hasLanded() == true)
        landed.add(ele);
    }
  };

  public List<Flyable> getObservers() {
    return (observers);
  };
}
