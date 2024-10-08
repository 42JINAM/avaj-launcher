package aircraft;

import coordinates.Coordinates;

/**
 * JetPlane
 */
public class JetPlane extends Aircraft {
  public JetPlane(long p_id, String p_name, Coordinates p_Coordinates) {
    super(p_id, p_name, p_Coordinates);
  }

  public void updateConditions() {
    int[]sun = {0, 10, 2};
    int[]rain = {0, 5, 0};
    int[]fog = {0, 1, 0};
    int[]snow = {0, 0, -7};

    this.setSunWeather(sun, "The sunlight is so strong that even my drink is wearing sunglasses!");
    this.setRainWeather(rain, "It was raining, so I took an umbrella, but it said to me, 'Aren't you expecting a bit too much today?");
    this.setFogWeather(fog, "The fog was so thick that when I was having my morning coffee, I asked my cup, 'Hello, who are you?'");
    this.setSnowWeather(snow, "On a snowy day, my cat thought, 'Now I'm a snowboarding champion!'");

    this.changeCoordinates("JetPlane");
  };

  public void print(String msg) {
    super.printAircraft("JetPlane", msg);
  }

}
