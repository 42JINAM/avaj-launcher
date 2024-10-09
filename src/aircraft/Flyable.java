package aircraft;

import weather.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions() throws Exception;
    public void registerTower(WeatherTower p_WeatherTower){
      this.weatherTower = p_WeatherTower;
  }
}
