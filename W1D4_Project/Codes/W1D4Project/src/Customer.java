import java.util.ArrayList;
import java.util.List;

public class Customer {

   public long id;
   public String fname;
   public String lname;
   public String username;
   public String password;
   public List<Order> orders = new ArrayList<Order>();

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getFname() {
      return fname;
   }

   public void setFname(String fname) {
      this.fname = fname;
   }

   public String getLname() {
      return lname;
   }

   public void setLname(String lname) {
      this.lname = lname;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public List<Order> getOrders() {
      return orders;
   }

   public void setOrders(List<Order> orders) {
      this.orders = orders;
   }

   public Customer() {
      // TODO Auto-generated constructor stub
   }
   
   public void addOrder(Order order){
      orders.add(order);
   }

}
