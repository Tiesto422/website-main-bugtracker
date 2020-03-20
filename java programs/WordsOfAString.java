import java.util.HashMap;
import java.util.Scanner;

public class WordsOfAString {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner scanner = new Scanner(System.in);
  System.out.print("Enter your string: ");
  String scan = scanner.nextLine();
  String[] split = scan.split(" ");
  HashMap<String, Integer> map = new HashMap<String, Integer>();
  for (int i = 0; i < split.length; i++) {
   if (map.containsKey(split[i])) {
    int count = map.get(split[i]);
    map.put(split[i], count + 1);
   } else {
    map.put(split[i], 1);
   }
  }
  System.out.println(map);
 }

}