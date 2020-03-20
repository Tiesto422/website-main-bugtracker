import java.util.Scanner;

public class CountVowels {

 public static void main(String[] args) {
  int a = 0;
  int e = 0;
  int i = 0;
  int o = 0;
  int u = 0;
  // TODO Auto-generated method stub
  Scanner scanner = new Scanner(System.in);
  System.out.print("Enter your sentence: ");
  String entervowel = scanner.nextLine();
  for (int z = entervowel.length() - 1; z > 0; z--) {
   if (entervowel.charAt(z) == 'a') {
    a++;
   }
   if (entervowel.charAt(z) == 'e') {
    e++;
   }
   if (entervowel.charAt(z) == 'i') {
    i++;
   }
   if (entervowel.charAt(z) == 'o') {
    o++;
   }
   if (entervowel.charAt(z) == 'u') {
    u++;
   }
  }
  System.out.println("a: " + a);
  System.out.println("e: " + e);
  System.out.println("i: " + i);
  System.out.println("o: " + o);
  System.out.println("u: " + u);
 }

}
