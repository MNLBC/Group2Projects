import java.util.Scanner;

public class w1d3_2 {

   public w1d3_2() {
      // TODO Auto-generated constructor stub
   }

   @SuppressWarnings("resource")
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input1 = new Scanner(System.in);

      System.out.print("Enter n: ");
      try {
         int n = input1.nextInt();
         System.out.println("The factorial of n is : " + getFactorial(n));

      } catch (Exception e) {
         System.out.println("Invalid Input!");
      }

   }

   public static int getFactorial(int n) {
      int result = 1;
      for (int i = 1; i <= n; i++) {
         result *= i;
      }
      return result;
   }

}
