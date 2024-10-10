package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
  static LogWriter lWriter;
  private String outfile = "simulation.txt";
  private BufferedWriter writer;

  public LogWriter() throws Exception{
    try {
      this.writer = new BufferedWriter(new FileWriter(outfile, false));
    } catch (Exception e) {
      throw new IOException("can't create simulation.txt file.");
    }

  }
  
  public static LogWriter getInstance() throws Exception{
    if (lWriter == null)
     lWriter = new LogWriter();
    return lWriter;
  }
  public void log(String str) throws Exception{
    this.writer.write(str); 
    this.writer.newLine();
    this.writer.flush();
  }
  public void close() throws Exception{
    try {
      if (this.writer != null){
        writer.close();
      }
    } catch (Exception e) {
      throw new Exception("can't close the simulation.txt");
    }
  }
}
