package aircraft;

import coordinates.Coordinates;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft {

  public Helicopter(long p_id, String p_name, Coordinates p_Coordinates) {
    super(p_id, p_name, p_Coordinates);

    this.sunMove.setLongitude(10).setLatitude(0).setHeight(2);
    this.rainMove.setLongitude(5).setLatitude(0).setHeight(0);
    this.fogMove.setLongitude(1).setLatitude(0).setHeight(0);
    this.snowMove.setLongitude(0).setLatitude(0).setHeight(-12);
    this.setSunWeather("The sun was so bright that it said to me, 'Hello! You should go to the shade!'");
    this.setRainWeather("On a rainy day, my shoes shouted, 'Now I can go swimming in the pool!'");
    this.setFogWeather(
        "The fog was so thick that when I was having my morning coffee, I asked my cup, 'Hello, who are you?'");
    this.setSnowWeather("It snowed so much that my friend asked, 'Did winter wonderland just move into my house?'");

    // String tmp = String.format("coordinates : %d, %d, %d ", this.coordinates.getLongitude(),
    //     this.coordinates.getLatitude(), this.coordinates.getHeight());
    // this.print(tmp);
    this.changeCoordinates("Helicopter");

  };

  public void print(String msg) throws Exception {
    super.printAircraft("Helicopter", msg);
  }
}
