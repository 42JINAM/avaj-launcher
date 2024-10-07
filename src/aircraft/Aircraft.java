package aircraft;

import coordinates.Coordinates;

/**
 * Aircraft
 */
public class Aircraft extends Flyable {
  protected long id;
  protected String name;
  protected Coordinates coordinates;

  public void updateConditions() {
    System.out.println("UPDATE CONDITIONS");
  };

  protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
    this.id = p_id;
    this.name = p_name;
    this.coordinates = p_coordinates;
  };

  public Boolean hasLanded() {
    return coordinates.getHeight() == 0;
  }
  protected void printAircraft(String type, String msg){
    System.out.printf("%s#%s(%d): %s\n", type, this.name, this.id, msg);
  }
  public void print(String str){
    System.out.println("this is an aircraft\n");
  };
}
