package aircraft;

import coordinates.Coordinates;
import util.LogWriter;

/**
 * Aircraft
 */
public class Aircraft extends Flyable {
  protected long id;
  protected String name;
  protected Coordinates coordinates;

  protected int[] sunMove;
  protected int[] rainMove;
  protected int[] fogMove;
  protected int[] snowMove;

  protected String sunMsg;
  protected String rainMsg;
  protected String fogMsg;
  protected String snowMsg;

  protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
    this.id = p_id;
    this.name = p_name;
    this.coordinates = p_coordinates;
    this.sunMove = null;
    this.rainMove = null;
    this.fogMove = null;
    this.snowMove = null;
  };

  public void setSunWeather(int[] sunMove, String str) {
    this.sunMove = sunMove;
    this.sunMsg = str;
  }

  public void setRainWeather(int[] rainMove, String str) {
    this.rainMove = rainMove;
    this.rainMsg = str;
  }

  public void setFogWeather(int[] fogMove, String str) {
    this.fogMove = fogMove;
    this.fogMsg = str;
  }

  public void setSnowWeather(int[] snowMove, String str) {
    this.snowMove = snowMove;
    this.snowMsg = str;
  }

  public void updateConditions() throws Exception{
  };

  public Boolean hasLanded() {
    return coordinates.getHeight() == 0;
  }

  protected void printAircraft(String type, String msg) throws Exception{
    
    // System.out.printf("%s#%s(%d): %s\n", type, this.name, this.id, msg);
    String ret = String.format("%s#%s(%d): %s\n", type, this.name, this.id, msg);
    LogWriter myLog = LogWriter.getInstance();
    myLog.log(ret);
  }

  public void print(String str) throws Exception{
  };

  protected void changeCoordinates(String type) throws Exception {
    String currentWeather = this.weatherTower.getWeather(this.coordinates);

    switch (currentWeather) {
      case "SUN":
        this.coordinates.changeCoordinates(this.sunMove[0], this.sunMove[1], this.sunMove[2]);
        this.printAircraft( type, this.sunMsg);
        break;
      case "RAIN":
        this.coordinates.changeCoordinates(this.rainMove[0], this.rainMove[1], this.rainMove[2]);
        this.printAircraft( type, this.rainMsg);
        break;
      case "FOG":
        this.coordinates.changeCoordinates(this.fogMove[0], this.fogMove[1], this.fogMove[2]);
        this.printAircraft( type, this.fogMsg);
        break;
      case "SNOW":
        this.coordinates.changeCoordinates(this.snowMove[0], this.snowMove[1], this.snowMove[2]);
        this.printAircraft( type, this.snowMsg);
        break;
      default:
        break;
    }
  }
}
