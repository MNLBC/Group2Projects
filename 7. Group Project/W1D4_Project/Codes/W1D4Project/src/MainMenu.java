import java.util.Scanner;

public class MainMenu {

   public static Customer customer;
   public static Store store;
   
   public MainMenu(Store store){
      this.store = store;
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner console = new Scanner(System.in);

      int selection = 0;
      boolean valid = false;

      while (!valid) {
         try {
            showUI();
            selection = console.nextInt();
            if (selection == 1) {
               valid = true;
               ShowPending showPending = new ShowPending(store);
               showPending.showPend(customer);
            } else if (selection == 2) {
               valid = true;
            } else {
               System.out.println("Wrong selection. Please select from the given choices only.");
            }
         }

         catch (Exception e) {

         }
      }
   }
   
   public void displayMainMenu(Customer customer){
      Scanner console = new Scanner(System.in);
      this.customer = customer;
      int selection = 0;
      boolean valid = false;

      while (!valid) {
         try {
            showUI();
            selection = console.nextInt();
            if (selection == 1) {
               valid = true;
               ShowPending showPending = new ShowPending(store);
               showPending.showPend(this.customer);
            } else if (selection == 2) {
               valid = true;
               ProductList productList = new ProductList(store);
               productList.displayProductList(customer);
            } else if (selection == 3) {
               valid = true;
//               System.out.println("Are you sure? [Y|N]: ");
               App app = new App();
               app.startTransaction(store);
            } else {
               System.out.println("Wrong selection. Please select from the given choices only.");
            }
            System.out.println("====================");
         }

         catch (Exception e) {

         }
      }
   }

   private static void showUI() {
      // clearScreen();
      System.out.println("====================");
      System.out.println("Actions:");
      System.out.println("1. Pending Orders");
      System.out.println("2. Browse Products");
      System.out.println("3. Log Out");
      System.out.print("Please select action: ");
   }

}
