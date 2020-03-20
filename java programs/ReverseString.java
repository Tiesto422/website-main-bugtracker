import java.util.Scanner;

public class ReverseString {

 public static void main(String[] args) {
  iteration();
 }

 public static void iteration() {
  String userstring;
  char reversedchar;
  String reversedstring = "";
  Scanner scanner = new Scanner(System.in);
  System.out.print("String you would like to reverse: ");
  userstring = scanner.nextLine();
  for (int i = userstring.length(); i > 0; i--) {
   reversedchar = userstring.charAt(i - 1);
   reversedstring = reversedstring + reversedchar;
  }
  System.out.println(reversedstring);
 }

}
