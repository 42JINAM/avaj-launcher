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

  protected Coordinates sunMove;
  protected Coordinates rainMove;
  protected Coordinates fogMove;
  protected Coordinates snowMove;

  protected String sunMsg;
  protected String rainMsg;
  protected String fogMsg;
  protected String snowMsg;

  protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
    this.id = p_id;
    this.name = p_name;
    this.coordinates = p_coordinates;
    this.sunMove = new Coordinates();
    this.rainMove = new Coordinates();
    this.fogMove = new Coordinates();
    this.snowMove = new Coordinates();
  };

  public void setSunWeather(String str) {
    this.sunMsg = str;
  }

  public void setRainWeather(String str) {
    this.rainMsg = str;
  }

  public void setFogWeather(String str) {
    this.fogMsg = str;
  }

  public void setSnowWeather(String str) {
    this.snowMsg = str;
  }

  public void updateConditions() throws Exception{
  };

  public Boolean hasLanded() {
    return coordinates.getHeight() == 0;
  }

  protected void printAircraft(String type, String msg) throws Exception{
    
    String ret = String.format("%s#%s(%d): %s", type, this.name, this.id, msg);
    LogWriter myLog = LogWriter.getInstance();
    myLog.log(ret);
  }

  public void print(String str) throws Exception{
  };

  protected void changeCoordinates(String type) throws Exception {
    String currentWeather = this.weatherTower.getWeather(this.coordinates);

    switch (currentWeather) {
      case "SUN":
        this.coordinates.changeCoordinates(this.sunMove);
        this.printAircraft( type, this.sunMsg);
        break;
      case "RAIN":
        this.coordinates.changeCoordinates(this.rainMove);
        this.printAircraft( type, this.rainMsg);
        break;
      case "FOG":
        this.coordinates.changeCoordinates(this.fogMove);
        this.printAircraft( type, this.fogMsg);
        break;
      case "SNOW":
        this.coordinates.changeCoordinates(this.snowMove);
        this.printAircraft( type, this.snowMsg);
        break;
      default:
        break;
    }
  }
}
