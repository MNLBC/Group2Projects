import java.util.List;
import java.util.Scanner;

public class CheckoutUI {

   public static Order ord;
   public static Customer cust;
   public static Store store;
   public static boolean dir;

   public CheckoutUI() {
      // TODO Auto-generated constructor stub
   }

   public static Order generateTestOrder() {
      Order order = new Order();
      order.product.add("Pencil");
      order.quantity.add(3);
      order.price.add((double) 150);
      order.setTotal(150);
      order.setPayment(0);
      order.setChange(0);
      order.setStatus("Order committed");
      order.setId(0);

      return order;
   }

   public static void main(String[] args) {

//      ord = generateTestOrder();
      displayCheckoutUI();
   }
   
   @SuppressWarnings("resource")
   public static void displayCheckoutUI(){

      // TODO Auto-generated method stub

      Scanner input1 = new Scanner(System.in);
      Scanner input2 = new Scanner(System.in);
      Scanner input3 = new Scanner(System.in);
      boolean proceed = false;
      if(ord==null){
         return;
      }

      while (!proceed) {
         System.out.println("=====================");
         System.out.println("Total: " + ord.getTotal());
         try {
            System.out.print("Enter payment amount: ");
            double payment = input1.nextDouble();
            if (payment < ord.getTotal()) {
               System.out.println("You do not have enough money");
            } else {
               System.out.print("Confirm payment [Y|N]: ");
               String confirm = input2.nextLine();
               if ("Y".equals(confirm.toUpperCase())) {
                  double change = payment - ord.getTotal();
                  processPayment(payment,change, dir);
                  proceed = true;
                  System.out.println("Payment successful!");
                  System.out.println("Your change is: " + change);
                  MainMenu mm = new MainMenu(store);
                  mm.displayMainMenu(cust);
                  System.out.println("=====================");
               } else {
                  System.out.print("Do you want to go back to Order Screen? [Y|N]: ");
                  String confirm2 = input3.nextLine();
                  if ("Y".equals(confirm2.toUpperCase())) {
                     proceed = true;
                     ViewOrder vo = new ViewOrder(ord);
                     vo.main();
                     System.out.println("=====================");
                  }
               }
            }

         } catch (Exception e) {
            System.out.println("Invalid cash amount");
            System.out.println("=====================");
         }
      }

   
   }
   
   public CheckoutUI(Order order, Customer customer, Boolean direct,Store storeNew){
      ord = order;
      cust = customer;
      dir = direct;
      store = storeNew;
   }

   public static void processPayment(double payment, double change, boolean direct) {
//      List<Product> products = store.getProducts();
//      for (int i = 0; i < ord.getProduct().size(); i++) {
//         for (Product prod : products) {
//            if (ord.getProduct().get(i).equals(prod.name)) {
//               prod.setQuantity(prod.getQuantity()-ord.getQuantity().get(i));
//            }
//         }
//
//      }
      ord.setPayment(payment);
      ord.setChange(change);
      ord.setStatus("Delivery out of storage");
      if(direct){
         cust.getOrders().add(ord);
      }
   }

}
