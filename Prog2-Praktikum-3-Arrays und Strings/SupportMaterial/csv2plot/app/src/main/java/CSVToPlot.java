import java.nio.file.*;
import java.util.Arrays;
import java.io.IOException;
import java.net.URISyntaxException;

public class CSVToPlot {

  private static String csvToPlot(String csv){
    // TODO implement conversion
    return String.format("2008/04 8.181806%n2008/05 14.888575%n2008/06 17.763092%n2008/07 17.966353");
  }

  // Copy the following code snippet into the field 'Script' on 
  // https://hostcat.fhsu.edu/cdclark/static/apps/gnuplot/
  // Copy the content from `temperatures.txt` into the 'Data' field.
  /* 
  set title 'Temperaturentwicklung (Landshut Reithof)'
  set xlabel 'Monat [J/m]'
  set xdata time
  set timefmt "%Y/%m"
  set format x '%y/%m'
  set ylabel 'Durchschnittstemperatur monatlich'
  set autoscale
  f(x)=b*x+c
  fit f(x) 'data.txt' using 1:2 via b,c
  plot 'data.txt' using 1:2 w l title "Durchschnitt", f(x) w l title "Trend"
  */
    

  public static void main(String[] args) {

    // DON'T CHANGE

    try {
      String csv = Files.readString(
          Paths.get(
            ClassLoader.getSystemClassLoader()
            .getResource("produkt_tu_stunde_20080401_20231231_13710.txt")
            .toURI()));

      String plotData = csvToPlot(csv);
      Files.write(Paths.get("temperatures.txt"), Arrays.asList(plotData.split("\r\n")));
    } catch (IOException ioException){
      System.err.println(ioException.getMessage());
      System.exit(1);
    } catch (URISyntaxException ioException){
      System.err.println(ioException.getMessage());
      System.exit(1);
    }

  }

}
