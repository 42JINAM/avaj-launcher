package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aircraft.Aircraft;
import aircraft.AircraftFactory;
import aircraft.Flyable;
import coordinates.Coordinates;
import weather.WeatherTower;
import util.LogWriter;

public class Simulator {
  int iteration;
  AircraftFactory aFactory;
  WeatherTower wTower;
  List<Flyable> aircrafts;
  String outputFile = "simulation.txt";

  public Simulator() {
    this.iteration = 0;
    this.aFactory = AircraftFactory.getInstance();
    this.wTower = new WeatherTower();
    this.aircrafts = new ArrayList<>();
  }

  void parsingAircrafts(String line) throws Exception {
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
    aircrafts.add(aircraft);
  }

  void parsingScenario(String file) throws Exception {

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
    } catch (IOException e) {
      throw e;
    } finally {
      if (reader != null)
        reader.close();
    }

  }

  void run() throws Exception {
    for (Flyable aircraft : this.aircrafts) {
      aircraft.registerTower(this.wTower);
      this.wTower.register(aircraft);
    }
    for (int i = 0; i != this.iteration; i++) {
      this.wTower.changeWeather();
    }
  }

  public static void main(String[] argv) throws Exception {
    if (argv.length < 1) {
      System.out.println("Usage: java simulator.Simulator [scenario.txt]\n");
      System.exit(1);
    }
    try {
      Simulator simulator = new Simulator();
      simulator.parsingScenario(argv[0]);
      simulator.run();
      return;
    } catch (Exception e) {
      System.err.println("ERROR: " + e.getMessage());
    } finally {
      LogWriter.getInstance().close();
    }

  }
}
