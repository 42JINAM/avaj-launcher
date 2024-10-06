package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
  private void parsingScenario(String file) throws IOException {
    try {
      BufferedReader reader = new BufferedReader(
        new FileReader(file)
      );
      String tmp;
      if ((tmp = reader.readLine()) == null)
        throw new IOException(" wrong scenario.txt");
      while ((tmp = reader.readLine()) != null) {
        System.out.println(tmp);
      }
    } catch (IOException e) {
      // TODO: handle exception
      throw new IOException(" Can not found file : " + file, e);
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
    } catch (IOException e) {
      // TODO: handle exception
      System.err.println("ERROR : " + e.getMessage());
    }

  }
}
