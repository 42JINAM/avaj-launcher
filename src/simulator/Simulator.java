package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import aircraft.Flyable;
import weather.WeatherTower;
import util.LogWriter;
import util.SimulationParser;

public class Simulator {
  WeatherTower wTower;
  List<Flyable> aircrafts;
  String outputFile = "simulation.txt";

  public Simulator() {
    this.wTower = new WeatherTower();
    this.aircrafts = new ArrayList<>();
  }

  void run() throws Exception {
    int iteration = SimulationParser.getInstance().getIteration();
    for (Flyable aircraft : this.aircrafts) {
      aircraft.registerTower(this.wTower);
      this.wTower.register(aircraft);
    }
    for (int i = 0; i != iteration; i++) {
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
      simulator.aircrafts = SimulationParser.getInstance().parsingScenario(argv[0]);
      simulator.run();
      return;
    } catch (Exception e) {
      System.err.println("ERROR: " + e.getMessage());
    } finally {
      LogWriter.getInstance().close();
    }

  }
}
