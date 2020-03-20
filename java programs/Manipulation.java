import java.util.Scanner;

public class Manipulation {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner scanner = new Scanner(System.in);
  System.out.print("Number: ");
  int number = scanner.nextInt();
  int fizz = number % 5;
  int buzz = number % 3;
  if (fizz == 0 && buzz == 0)
   System.out.print("FizzBuzz");
  else if (buzz == 0)
   System.out.print("Buzz");
  else if (fizz == 0)
   System.out.print("Fizz");
  else
   System.out.print(number);
 }

}