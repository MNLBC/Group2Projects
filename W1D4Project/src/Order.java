import java.util.ArrayList;
import java.util.List;

public class Order {

   public long id;
   public List<String> product = new ArrayList<String>();
   public List<Integer> quantity = new ArrayList<Integer>();
   public List<Double> price = new ArrayList<Double>();
   public double total;
   public double payment;
   public double change;
   public String status;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public List<String> getProduct() {
      return product;
   }

   public void setProduct(List<String> product) {
      this.product = product;
   }

   public List<Integer> getQuantity() {
      return quantity;
   }

   public void setQuantity(List<Integer> quantity) {
      this.quantity = quantity;
   }

   public List<Double> getPrice() {
      return price;
   }

   public void setPrice(List<Double> price) {
      this.price = price;
   }

   public double getTotal() {
      return total;
   }

   public void setTotal(double total) {
      this.total = total;
   }

   public double getPayment() {
      return payment;
   }

   public void setPayment(double payment) {
      this.payment = payment;
   }

   public double getChange() {
      return change;
   }

   public void setChange(double change) {
      this.change = change;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public Order() {
      // TODO Auto-generated constructor stub
   }

   public void addProduct(String product, int quantity, double price) {
      this.product.add(product);
      this.quantity.add(quantity);
      this.price.add(price);
   }

   public void resetOrder() {
      product = new ArrayList<String>();
      quantity = new ArrayList<Integer>();
      price = new ArrayList<Double>();
      total = 0;
      change = 0;
      status = "";
   }

   public void payOrder() {
      status = "Delivery out of storage";
   }

   public void waitForDelivery() {
      status = "Ready to receive products for users";
   }

   public void claimOrder() {
      status = "Finished";
   }
}
