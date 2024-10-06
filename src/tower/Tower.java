import java.util.List;
import aircraft.Flyable;
public class Tower {

  private List<Flyable> observers;
  public void register(Flyable p_flyable){};
  public void unregister(Flyable p_flyable){};
  protected void conditionChanged(){};

  public List<Flyable> getObservers(){return (observers);};
}
