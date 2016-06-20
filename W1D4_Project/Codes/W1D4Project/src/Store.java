import java.util.ArrayList;
import java.util.List;

public class Store {

   public List<Customer> customers = new ArrayList<Customer>();
   public List<Product> products = new ArrayList<Product>();
   public int custId = 0;
   public int prodId = 0;

   public Store() {
      // TODO Auto-generated constructor stub
   }

   public Customer addCustomer(String fname, String lname, String username, String password) {
      custId++;
      Customer customer = new Customer();
      customer.setFname(fname);
      customer.setLname(lname);
      customer.setUsername(username);
      customer.setPassword(password);
      customer.setId(custId);
      customer.setOrders(new ArrayList<Order>());
      customers.add(customer);
      return customer;
   }

   public void addProduct(String name, int quantity, double price) {
      prodId++;
      Product product = new Product();
      product.setName(name);
      product.setQuantity(quantity);
      product.setPrice(price);
      product.setId(prodId);
      products.add(product);
   }

   public Customer getCustomerByLogin(String username, String password) {
      for (Customer customer : customers) {
         if (username.equals(customer.username) && password.equals(customer.password)) {
            return customer;
         }
      }
      return null;
   }

   public Product getProduct(long id) {
      for (Product product : products) {
         if (product.id == id) {
            return product;
         }
      }
      return null;
   }

   public List<Customer> getCustomers() {
      return customers;
   }

   public void setCustomers(List<Customer> customers) {
      this.customers = customers;
   }

   public List<Product> getProducts() {
      return products;
   }

   public void setProducts(List<Product> products) {
      this.products = products;
   }

}
