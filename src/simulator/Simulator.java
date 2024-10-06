package simulator;

import java.io.File;
import java.io.IOException;

public class Simulator {
  private void parsingScenario(String file) {
    try {

    } catch (Exception e) {
      // TODO: handle exception
      throw new IOException(" Can not found file : " + file, e);
    }

  }

  public static void main(String[] argv) {
    if (argv.length != 1) {
      System.out.println("Usage: java simulator.Simulator [scenario.txt]\n");
      return;
    }
    try {
      Simulator simulator = new Simulator();
      simulator.parsingScenario(argv[1]);
      return;
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("ERROR : " + e.getMessage());
    }

  }
}
