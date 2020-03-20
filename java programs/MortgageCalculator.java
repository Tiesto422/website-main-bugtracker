import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

 public static void main(String[] args) {

  Scanner scanner = new Scanner(System.in);
  long principle;
  int period;
  double air1;

  while (true) {
   System.out.print("Principle ($1K - $1M): ");
   principle = scanner.nextLong();
   if (principle >= 1000 && principle <= 1000000) {
    break;
   }
   System.out.println("Enter a number between 1,000 and 1,000,000");
  }

  while (true) {
   System.out.print("Annual Interest Rate: ");
   air1 = scanner.nextDouble();
   if (air1 > 0 && air1 <= 30) {
    break;
   }
   System.out.println("Enter a value greater than 0 and less than 30");
  }

  while (true) {
   System.out.print("Period (Years): ");
   period = scanner.nextInt();
   if (period >= 1 && period <= 30) {
    break;
   }
   System.out.println("Enter a value between 1 and 30");
  }

  double air2 = air1 / 1200;
  double a = Math.pow(1 + air2, period * 12);
  double mortgage = (principle * ((air2 * a) / (a - 1)));
  System.out.print("Mortgage: ");
  NumberFormat currency = NumberFormat.getCurrencyInstance();
  String result = currency.format(mortgage);
  System.out.println(result);

 }
}