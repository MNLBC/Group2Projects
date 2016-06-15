import java.util.*;


public class calculateFactorial 
{
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      int number;
      
      System.out.print("Input a number: ");
      number = scanner.nextInt();
      
        System.out.println( "Number " + number + " factorial is " +  factorial(number));
   }
   
   public static  int factorial(int j)
   {
      int answer=1;
      for (int k=1; k<=j; k++)
      {
        answer*=k;
      }
      return answer;
   }
}