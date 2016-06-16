import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewOrder {

   public static List<String> product = new ArrayList<String>();
   public static List<Integer> quantity = new ArrayList<Integer>();
   public static List<Double> price = new ArrayList<Double>();
   public static double temptotal;
   public static int input; 
   public static Order order;
   static Store store;
   static Customer customer;
   
   public ViewOrder(Order order, Customer customer, Store store){
      this.order = order;
      this.store = store;
      this.customer = customer;
   }
   public ViewOrder(Order order){
      this.order = order;
   }
   
   
   public static Order generateTestOrder(){
      Order order = new Order();
      
      order.product.add("Pencil");
      order.quantity.add(3);
      order.price.add((double) 150.1);
      
      order.product.add("Notebook");
      order.quantity.add(3);
      order.price.add((double) 150.2);
      
      order.product.add("Shoes");
      order.quantity.add(3);
      order.price.add((double) 150.3);
      return order;
   }

   public static void main() {
      // TODO Auto-generated method stub
      viewOrder(order); //UI
      optionsMenu(); //OptionsMenu haha
   }

   private static void optionsMenu() {
      // TODO Auto-generated method stub
      Scanner scanner = new Scanner(System.in);
      System.out.println("[1] Save order");
      System.out.println("[2] Check out");
      System.out.println("[3] Back");
      System.out.print("Select Action: ");
      input = scanner.nextInt();
    
      switch(input){
         case 1:{
            order.setStatus("Order committed");
            order.setTotal(temptotal);
            List<Order> orderList = new ArrayList<Order>();
            orderList.add(order);
            customer.setOrders(orderList);
            MainMenu mm = new MainMenu(store);
            mm.displayMainMenu(customer);
            break;
         }
         case 2: {
            order.setTotal(temptotal);
            order.setStatus("Order committed");
            CheckoutUI checkout = new CheckoutUI(order, customer, true, store);
            checkout.displayCheckoutUI();
            break;
         }
         case 3:{
            ProductList productlist = new ProductList(order);
            productlist.displayProductList(order);
            break;
         }
         default:{
            System.out.println("Invalid option");
            break;
         }
      }
   }

   private static void viewOrder(Order order) {
      // TODO Auto-generated method stub
      String sample =    "                                  ";
      System.out.println("\t \t ORDERS");
      System.out.println("ITEM \t | \t QTY \t | \t PRICE");
      System.out.println("----------------------------------");
      product = order.getProduct();
      quantity = order.getQuantity();
      price = order.getPrice();
      for (int i = 0; i < product.size(); i++) {
         double tempPrice = 0;
         for(int j = 0; j < quantity.get(i); j++){
            tempPrice += price.get(i);
         }
         System.out.println(product.get(i) + "\t \t " + quantity.get(i) + "\t \t " + tempPrice);
         temptotal = temptotal + (price.get(i)*quantity.get(i));
      }
      System.out.println("TOTAL \t \t \t \t" + temptotal);
   }
   
}
