package aircraft;

import coordinates.Coordinates;

/**
 * JetPlane
 */
public class JetPlane extends Aircraft{
    public JetPlane(long p_id, String p_name, Coordinates p_Coordinates){
        super(p_id, p_name, p_Coordinates);
    }
    public void updateConditions(){};

  public void print(String msg) {
    super.printAircraft("JetPlane", msg);
  }

}
