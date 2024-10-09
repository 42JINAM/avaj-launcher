package aircraft;

import coordinates.Coordinates;

/**
 * JetPlane
 */
public class Baloon extends Aircraft {
  public Baloon(long p_id, String p_name, Coordinates p_Coordinates) {
    super(p_id, p_name, p_Coordinates);
  }

  public void updateConditions() throws Exception{
    int[]sun = {2, 0, 4};
    int[]rain = {0, 0, -5};
    int[]fog = {0, 0, -3};
    int[]snow = {0, 0, -15};

    this.setSunWeather(sun, "On a sunny day, my friend was eating ice cream and, as it melted, sadly said, 'This is truly my thriller movie!'");
    this.setRainWeather(rain,"It was raining so much that my dog boasted, 'Now I can swim in the water!'");
    this.setFogWeather(fog,"With the thick fog, my friend asked, 'Where are we right now? Is this a deserted island?'");
    this.setSnowWeather(snow,"A dog running in the snow shouted, 'This is my snowball party!'");

    String tmp = String.format("coordinates : %d, %d, %d ", this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight());
    this.print(tmp);
    
    this.changeCoordinates("Baloon");

  };

  public void print(String msg) throws Exception{
    super.printAircraft("Baloon", msg);
  }
}
