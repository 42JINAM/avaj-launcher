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
    int idx = p_Coordinates.getHeight() + p_Coordinates.getLatitude() + p_Coordinates.getLongitude();
    idx  = idx % 4;
    return weather[idx];
  }
}
