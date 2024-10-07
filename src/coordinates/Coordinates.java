package coordinates;

/**
 * Coordiates
 */
public class Coordinates {

    int longitude;
    int latitude;
    int height;
    public Coordinates(int p_longitude, int p_latitude, int p_height) throws IllegalArgumentException {
    //TODO: checking and normalize longitude and latitude ?
      if (p_longitude < 0 || p_latitude <0 || p_height < 0)
        throw new IllegalArgumentException("Coordinates must be greater than zero");
      if (p_height > 100) p_height = 100;
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    };
    public int getLongitude(){
        return (this.longitude);
    }
    public int getLatitude(){
        return (this.latitude);
    }
    public int getHeight(){
        return (this.height);
    }
}
