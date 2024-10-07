package weather;

import coordinates.Coordinates;

/**
 * WeatherProvider
 */
public class WeatherProvider {

  private final String[] weather = {"SUN","RAIN","FOG","SNOW"};
  private static WeatherProvider wProvider;
  private WeatherProvider(){
  }
  public static WeatherProvider getInstance(){
    if (wProvider == null)
      wProvider = new WeatherProvider();
    return wProvider;
  }
  public String getCurrentWeather(Coordinates p_Coordinates) {
    return ("Nice Weather");
  }
}
