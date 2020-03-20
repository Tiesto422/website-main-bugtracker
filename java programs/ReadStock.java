import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ReadStock {

 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub
  while (true) {

   Scanner scanner = new Scanner(System.in);
   System.out.print("Enter Ticker Symbol: ");
   String SYM = scanner.nextLine();

   URL url = new URL("https://finance.yahoo.com/quote/" + SYM);
   URLConnection urlConn = url.openConnection();
   InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
   BufferedReader buff = new BufferedReader(inStream);
   String price = "not found";
   String line = buff.readLine();
   while (line != null) {
    if (line.contains("\"regularMarketPrice\":{\"raw\":")) {
     int target = line.indexOf("\"regularMarketPrice\":{\"raw\":");
     int deci = line.indexOf(".", target);
     int start = deci;
     while (line.charAt(start) != '\"') {
      start--;

     }
     price = line.substring(start + 2, deci + 3);
     System.out.println(price);

    }
    line = buff.readLine();
   }
  }
 }

}