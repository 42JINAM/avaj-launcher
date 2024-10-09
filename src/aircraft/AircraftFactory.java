package aircraft;

import coordinates.Coordinates;
import java.lang.Exception;

public class AircraftFactory {
  int idx = 0;
  static AircraftFactory aFactory;

  public static AircraftFactory getInstance() {
    if (aFactory == null)
      aFactory = new AircraftFactory();
    return aFactory;
  } 
  public Flyable newAircraft(String type, String name, Coordinates coordinates) throws Exception {
    Flyable ret;

    switch (type) {
      case "JetPlane":
        ret = new JetPlane(idx, name, coordinates);
        break;
      case "Helicopter":
        ret = new Helicopter(idx, name, coordinates);
        break;
      case "Baloon":
        ret = new Baloon(idx, name, coordinates);
        break;
      default:
        throw new Exception("wrong type of aircraft");
    }
    idx++;
    return ret;
  }
}
