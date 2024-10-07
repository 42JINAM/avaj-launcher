package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import coordinates.Coordinates;

public class Simulator {
  int iteration;

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
      // TODO: handle exception
      throw new IllegalArgumentException("The arguments must be intergers");
    }
    Coordinates coordinate = new Coordinates(longitude, latitude, height);
    for (String part : st){
      System.out.println(part);
    }
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
        // try {

        //   parsingAircrafts(tmp);
        // } catch (Exception e) {
        //   // TODO: handle exception
        //   throw e;
        // }
        parsingAircrafts(tmp);
      }
    } catch (IOException e) {
      // TODO: handle exception
      throw new IOException(" Can not found file : " + file, e);
    } finally {
      if (reader != null)
        reader.close();
    }

  }

  public static void main(String[] argv) {
    if (argv.length < 1) {
      System.out.println("Usage: java simulator.Simulator [scenario.txt]\n");
      return;
    }
    try {
      Simulator simulator = new Simulator();
      simulator.parsingScenario(argv[0]);
      // System.out.println(argv);
      return;
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("ERROR: " + e.getMessage());
    }

  }
}
