package coordinates;

/**
 * Coordiates
 */
public class Coordinates {

  int longitude;
  int latitude;
  int height;

  public Coordinates() {
    this.longitude = 0;
    this.latitude = 0;
    this.height = 0;
  }

  public Coordinates(int p_longitude, int p_latitude, int p_height) throws IllegalArgumentException {
    if (p_longitude < 0 || p_latitude < 0 || p_height < 0)
      throw new IllegalArgumentException("Coordinates must be greater than zero");
    if (p_height > 100)
      p_height = 100;
    this.longitude = p_longitude;
    this.latitude = p_latitude;
    this.height = p_height;
  };

  public void changeCoordinates(Coordinates change) {
    this.longitude += change.longitude;
    this.latitude += change.latitude;
    this.height += change.height;
    if (this.height > 100)
      this.height = 100;
    if (this.height < 0)
      this.height = 0;
  }

  public int getLongitude() {
    return (this.longitude);
  }

  public int getLatitude() {
    return (this.latitude);
  }

  public int getHeight() {
    return (this.height);
  }

  public Coordinates setLongitude(int longitude) {
    this.longitude = longitude;
    return this;
  }

  public Coordinates setLatitude(int latitude) {
    this.latitude = latitude;
    return this;
  }

  public Coordinates setHeight(int height) {
    this.height = height;
    return this;
  }
}
