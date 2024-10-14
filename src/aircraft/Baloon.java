package aircraft;

import coordinates.Coordinates;

/**
 * JetPlane
 */
public class Baloon extends Aircraft {
  public Baloon(long p_id, String p_name, Coordinates p_Coordinates) {
    super(p_id, p_name, p_Coordinates);

    this.sunMove.setLongitude(2).setLatitude(0).setHeight(4);
    this.rainMove.setLongitude(0).setLatitude(0).setHeight(-5);
    this.fogMove.setLongitude(0).setLatitude(0).setHeight(-3);
    this.snowMove.setLongitude(0).setLatitude(0).setHeight(-15);
    this.setSunWeather(
        "On a sunny day, my friend was eating ice cream and, as it melted, sadly said, 'This is truly my thriller movie!'");
    this.setRainWeather("It was raining so much that my dog boasted, 'Now I can swim in the water!'");
    this.setFogWeather("With the thick fog, my friend asked, 'Where are we right now? Is this a deserted island?'");
    this.setSnowWeather("A dog running in the snow shouted, 'This is my snowball party!'");

  }

    // String tmp = String.format("coordinates : %d, %d, %d ", this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight());
    // this.print(tmp);
    this.changeCoordinates("Baloon");

  };

  public void print(String msg) throws Exception{
    super.printAircraft("Baloon", msg);
  }
}
