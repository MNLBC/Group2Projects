import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
   public static int qty;
   public static Store store;
   static Scanner scanner = new Scanner(System.in);
   static List<String> products = new ArrayList<String>();
   static List<Integer> quantity = new ArrayList<Integer>();
   static List<Double> price = new ArrayList<Double>();
   static Customer cust;
   static Order order;
   static int itemqty;
   
   public ProductList(Order order){
      this.order = order;
   }
   
   public ProductList(Store store){
      this.store = store;
   }
   
   public static void displayProductList(Customer customer){
      cust = customer;
      List<Product> productlist = store.getProducts();
      
      System.out.println("\t \t PRODUCT LIST");
      System.out.println("ID/ITEM \t \t QTY \t \t PRICE");
      System.out.println("----------------------------------");
      
      for(int i = 0; i < productlist.size(); i++){
         System.out.println("(" +productlist.get(i).id+")" +productlist.get(i).name + "\t \t " + productlist.get(i).quantity + "\t \t " + productlist.get(i).price);
      }

      long itemno = 0;
      Product selecteditem = null;
      
      boolean validitem = false;
      validateItem:
      while(!validitem){
         itemno = selectedItem();
         selecteditem = store.getProduct(itemno);
         if(selecteditem != null){
            validitem = true;
         }
         else{
            System.out.println("Invalid item number");
            //continue validateItem;
         }
      }
      
      boolean validqty = false;
      validateQuantity:
      while(!validqty){
         
         itemqty = numberOfItems();
         selecteditem = store.getProduct(itemno);
         if(selecteditem.quantity >= itemqty){
            //selecteditem.quantity = selecteditem.quantity - itemqty;
            for(int i =0;i<store.getProducts().size();i++){
               if(selecteditem.name.equals(store.getProducts().get(i).getName())){
                  store.getProducts().get(i).setQuantity(store.getProducts().get(i).getQuantity()-itemqty);
               }
            }
            validqty = true;
         }
         else{
            System.out.println("Insufficient stocks!");
            continue validateQuantity;
         }
      }

      optionMenu(selecteditem);

      
   }
   
   public static int numberOfItems(){
      System.out.print("Number of items: ");
      int qty = scanner.nextInt();
      return qty;
   }
   
   public static long selectedItem() {
      System.out.print("Select an item by number or press [X] to go back: ");
      Scanner input = new Scanner(System.in);
      String answer = input.nextLine();
      if ("X".equals(answer.toUpperCase())) {
         MainMenu mm = new MainMenu(store);
         mm.displayMainMenu(cust);
      } else {
         try {
            long itemno = Long.parseLong(answer);
            return itemno;
         } catch (Exception e) {
            System.out.println("Invalid input");
         }
      }
      return 0l;
   }
      
   
   public static void optionMenu(Product selecteditem){
      System.out.println("[1] Order more");
      System.out.println("[2] View order");
      System.out.println("[3] Reset");
      System.out.println("[4] Back");
      System.out.print("Select Action: ");
      int option = scanner.nextInt();
      
      switch (option){
         case 1: {
            products.add(selecteditem.name);
            quantity.add(itemqty);
            price.add(selecteditem.price);
            displayProductList(cust);
            break;
         }
         case 2: {
            order = new Order();
            if(cust.getOrders() == null)
               order.setId(1);
            else{
               products.add(selecteditem.name);
               quantity.add(itemqty);
               price.add(selecteditem.price);
               order.setId(cust.getOrders().size());
               order.setProduct(products);
               order.setQuantity(quantity);
               order.setPrice(price);
               ViewOrder vOrder = new ViewOrder(order,cust,store);
               vOrder.main();
            }
            break;
         }
         case 3: {
            products = new ArrayList<String>();
            quantity = new ArrayList<Integer>();
            price = new ArrayList<Double>();
            displayProductList(cust);
            App.generateTestProducts();
            order.resetOrder();
            break;
         }
         case 4: {
            System.out.println("Case 4");
            products = new ArrayList<String>();
            quantity = new ArrayList<Integer>();
            price = new ArrayList<Double>();
            App.generateTestProducts();
            MainMenu mm = new MainMenu(store);
            mm.displayMainMenu(cust);
            order.resetOrder();
            break;
         }
      }
   }
   public static void displayProductList(Order order){
List<Product> productlist = store.getProducts();
      
      System.out.println("\t \t PRODUCT LIST");
      System.out.println("ID/ITEM \t \t QTY \t \t PRICE");
      System.out.println("----------------------------------");
      
      for(int i = 0; i < productlist.size(); i++){
         System.out.println("(" +productlist.get(i).id+")" +productlist.get(i).name + "\t \t " + productlist.get(i).quantity + "\t \t" + productlist.get(i).price);
      }

      long itemno = selectedItem();
      Product selecteditem = null;
      
      boolean validitem = false;
      validateItem:
      while(!validitem){
         selecteditem = store.getProduct(itemno);
         if(selecteditem != null){
            validitem = true;
         }
         else{
            System.out.println("Invalid item number");
            continue validateItem;
         }
      }
      
      boolean validqty = false;
      validateQuantity:
      while(!validqty){
         int itemqty = numberOfItems();
         selecteditem = store.getProduct(itemno);
         if(selecteditem.quantity >= itemqty){
            selecteditem.quantity = selecteditem.quantity - itemqty;
            for(int i =0;i<store.getProducts().size();i++){
               if(selecteditem.name.equals(store.getProducts().get(i).getName())){
                  store.getProducts().get(i).setQuantity(store.getProducts().get(i).getQuantity()-itemqty);
               }
            }
            validqty = true;
         }
         else{
            System.out.println("Insufficient stocks!");
            continue validateQuantity;
         }
      }

      optionMenu(selecteditem);

      
   }
}
