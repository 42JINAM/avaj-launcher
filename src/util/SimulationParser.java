package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import coordinates.Coordinates;

public class SimulationParser {
  private static SimulationParser instance;
  List<Flyable> aircrafts;
  int iteration;
  AircraftFactory aFactory = AircraftFactory.getInstance();

  SimulationParser(){
    iteration = 0;
    this.aircrafts = new ArrayList<>();
  }
  public static SimulationParser getInstance() {
    if (instance == null)
      instance = new SimulationParser();
    return instance;
  }

  public List<Flyable> parsingScenario(String file) throws Exception {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(
          new FileReader(file));
      String tmp;
      if ((tmp = reader.readLine()) == null)
        throw new IOException("empty scenario file.");
      this.iteration = Integer.parseInt(tmp);
      if (this.iteration <= 0)
        throw new IOException("wrong input format : first line of the file should contain a positive integer number");
      while ((tmp = reader.readLine()) != null) {
        parsingAircrafts(tmp);
      }
      return this.aircrafts;
    } catch (IOException e) {
      throw e;
    } finally {
      if (reader != null)
        reader.close();
    }

  }
  public int getIteration(){
    return this.iteration;
  }

  public void parsingAircrafts(String line) throws Exception {
    int longitude;
    int latitude;
    int height;

    String[] st = line.split(" ");
    if (st.length != 5)
      throw new IllegalArgumentException("The format must be TYPE NAME LONGITUDE LATITUDE HEIGHT");
    try {
      longitude = Integer.parseInt(st[2]);
      latitude = Integer.parseInt(st[3]);
      height = Integer.parseInt(st[4]);
    } catch (Exception e) {
      throw new IllegalArgumentException("The arguments must be intergers");
    }
    Coordinates coordinate = new Coordinates(longitude, latitude, height);
    Flyable aircraft = aFactory.newAircraft(st[0], st[1], coordinate);
    this.aircrafts.add(aircraft);
  }
}
