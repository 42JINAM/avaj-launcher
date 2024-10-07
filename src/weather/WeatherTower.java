package weather;

import aircraft.Aircraft;
import aircraft.Flyable;
import coordinates.Coordinates;
import tower.Tower;

/**
 * WeatherTower
 */
public class WeatherTower extends Tower{

  public String getWeather(Coordinates p_Coordiates) {
    return WeatherProvider.getInstance().getCurrentWeather(p_Coordiates);
  };
  void unregisterLanded(){
    for (Flyable ele: this.landed){
      this.unregister(ele);
    }
    this.landed.clear();
  }
  public void changeWeather(){
    this.conditionChanged();
    this.unregisterLanded();
  }
}
