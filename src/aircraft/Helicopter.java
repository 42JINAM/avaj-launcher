package aircraft;

import coordinates.Coordinates;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_Coordinates){
        super(p_id, p_name, p_Coordinates);
    }
    public void updateConditions(){};
}