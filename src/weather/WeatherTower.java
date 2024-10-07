package weather;

import coordinates.Coordinates;

/**
 * WeatherTower
 */
public class WeatherTower {
  public String getWeather(Coordinates p_Coordiates) {
    return WeatherProvider.getInstance().getCurrentWeather(p_Coordiates);
  };
}
