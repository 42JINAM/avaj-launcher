package aircraft;

import coordinates.Coordinates;

/**
 * JetPlane
 */
public class JetPlane extends Aircraft {
  public JetPlane(long p_id, String p_name, Coordinates p_Coordinates) {
    super(p_id, p_name, p_Coordinates);

    this.sunMove.setLongitude(0).setLatitude(10).setHeight(2);
    this.rainMove.setLongitude(0).setLatitude(5).setHeight(0);
    this.fogMove.setLongitude(0).setLatitude(1).setHeight(0);
    this.snowMove.setLongitude(0).setLatitude(0).setHeight(-7);
    this.setSunWeather("The sunlight is so strong that even my drink is wearing sunglasses!");
    this.setRainWeather(
        "It was raining, so I took an umbrella, but it said to me, 'Aren't you expecting a bit too much today?");
    this.setFogWeather(
        "The fog was so thick that when I was having my morning coffee, I asked my cup, 'Hello, who are you?'");
    this.setSnowWeather("On a snowy day, my cat thought, 'Now I'm a snowboarding champion!'");

  }

    // String tmp = String.format("coordinates : %d, %d, %d ", this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight());
    // this.print(tmp);
    this.changeCoordinates("JetPlane");
  };

  public void print(String msg) throws Exception{
    super.printAircraft("JetPlane", msg);
  }

}
