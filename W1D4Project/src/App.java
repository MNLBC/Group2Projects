import java.util.ArrayList;

public class App {

   public static Customer customer;
   public static Store store;

   public App() {
      // TODO Auto-generated constructor stub
   }

   public Customer generateTestCustomer() {
      Customer cust = new Customer();
      cust.setFname("Test");
      cust.setLname("Test");
      cust.setId(0);
      cust.setUsername("Test");
      cust.setPassword("Test");

      Order order = new Order();
      order.product.add("Pencil");
      order.quantity.add(3);
      order.price.add((double) 150);
      order.setTotal(150);
      order.setPayment(0);
      order.setChange(0);
      order.setStatus("Order committed");
      order.setId(0);

      cust.orders.add(order);
      return cust;
   }

   public Order generateTestOrder() {
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

   public static void generateTestProducts(){
      store.products = new ArrayList<Product>();
      store.prodId = 0;
      store.addProduct("Vessel", 10, 50);
      store.addProduct("Container", 20, 10);
      store.addProduct("Barge", 30, 25);
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      store = new Store();
      generateTestProducts();
      startTransaction(store);

   }
   
   public static void startTransaction(Store store){
      DefaultPage dp = new DefaultPage(store);
      MainMenu mm = new MainMenu(store);
      customer = dp.displayDefaultPage();
      if(customer!=null){
         mm.displayMainMenu(customer);
      }
   }
   
   public static boolean testTransaction(){
      
      return false;
   }

}
