
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowPending {
   public static Customer customer;
   public static Store store;
   
   public ShowPending(Store store){
      this.store = store;
   }

	public static void showPend(Customer cust) {
		// TODO Auto-generated method stub
		customer = cust;
		boolean orderValid = false;
		System.out.println("====================");
		System.out.println("Pending Orders:");
		System.out.println("ID\t | \t Products \t | \t  Status ");
		if(getOrders().isEmpty()){
		   System.out.println("====================");
		   System.out.println("No pending orders");
		   System.out.println("====================");
		   MainMenu mm = new MainMenu(store);
		   mm.displayMainMenu(cust);
		}else{
		   orderStart:
		      while(!orderValid){
		         printOrders(getOrders());
		         int order = 0;
		         System.out.print("Select order number or press [X] to go back: ");
		         Scanner input= new Scanner(System.in);
		         String answer = input.nextLine();
            if ("X".equals(answer.toUpperCase())) {
               MainMenu mm = new MainMenu(store);
               mm.displayMainMenu(cust);
            } else {
               try {
                  order = Integer.parseInt(answer);
               } catch (Exception e) {
                  System.out.println("Wrong Order");
                  continue orderStart;
               }
            }
		         String status = getStatusOnOrder(order);
		         if(!status.equals("")){
		      
		            boolean statusActionValid = false;
		            beforeCheckStatus:
		            while(!statusActionValid){
		            int action = 0;
		         //"Order committed", "", "", "", “Finished”.
		            if(status == "Order committed"){
		               System.out.println("(1) Pay / (2) Back");
		            }
		            else if(status == "Delivery out of storage"){
		               System.out.println("(1) Wait For Delivery / (2) Back");
		            }
		            else if(status == "Ready to receive products for users"){
		               System.out.println("(1) Claim / (2) Back");
		            }
		            System.out.print("Action: ");
		            try{
		            action = input.nextInt();
		            Order selectedOrder = new Order();
		            selectedOrder = getOrder(order);
		            if(status == "Order committed"){
		               if(action == 1){
		                  orderValid = true;
		                  statusActionValid = true;
		                  CheckoutUI checkoutpage = new CheckoutUI(selectedOrder, customer, false, store);
		                  checkoutpage.displayCheckoutUI();
		               
		               }
		               else if(action == 2){
		                  statusActionValid = true;
		                  continue orderStart;
		               }
		               else{
		                  System.out.println("Wrong action");
		                  continue beforeCheckStatus;
		               }
		            }
		            else if(status == "Delivery out of storage"){
		               if(action == 1){
		                  orderValid = true;
		                  statusActionValid = true;
		                  System.out.println("Wait for your delivery..");
		            
		                  selectedOrder.setStatus("Ready to receive products for users");
		                  System.out.println("Status: Ready to receive products for users");
		                  MainMenu mm = new MainMenu(store);
		                  mm.displayMainMenu(cust);
		               }
		               else if(action == 2){
		                  statusActionValid = true;
		                  continue orderStart;
		               }
		               else{
		                  System.out.println("Wrong action");
		                  continue beforeCheckStatus;
		               }
		            }
		            else if(status == "Ready to receive products for users"){
		               if(action == 1){
		                  orderValid = true;
		                  statusActionValid = true;
		                  System.out.println("Claimed Order");
		                  Order orderUpdate = new Order();
		                  orderUpdate = getOrder(order);
		                  orderUpdate.setStatus("Finished");
		                  removeOrder(orderUpdate);
		                  System.out.println("Status: Finished");
		                  MainMenu mm = new MainMenu(store);
		                  mm.displayMainMenu(cust);
		               }
		               else if(action == 2){
		                  statusActionValid = true;
		                  continue orderStart;
		               }
		               else{
		                  System.out.println("Wrong action");
		                  continue beforeCheckStatus;
		               }
		            }
		            else{
		               System.out.println("Wrong action");
		               continue beforeCheckStatus;
		            }
		            }
		            catch(Exception e){
		               System.out.println("Wrong action");
		               continue beforeCheckStatus;
		            }
		            }
		         }
		         else{
		         
		         }
		      }
		}

	}
	
	public static void printOrderStatus(){
		
	}
	
	public static List<Order> getOrders(){
		return customer.getOrders();
	}
	
	private static void printOrders(List<Order> orderList){
		for (int i = 0; i<orderList.size(); i++){
			List<String> productList = new ArrayList<String>();
			productList = orderList.get(i).getProduct();
			List<Integer> quantityList = new ArrayList<Integer>();
			quantityList = orderList.get(i).getQuantity();
			String finalOrder = "";
			for(int j = 0; j < productList.size(); j++){
				String productName = productList.get(j);
				int quantity = quantityList.get(j);
				if(j == productList.size() - 1){
					finalOrder = finalOrder + productName + "("+quantity +")";
				}
				else{
					finalOrder = finalOrder + productName + "("+quantity +"), ";
				}
			}
			finalOrder = orderList.get(i).getId() + "\t\t" + finalOrder + "\t\t" + orderList.get(i).getStatus();
			System.out.println(finalOrder);
		}
	}
	
	public static void removeOrder(Order order){
	   List<Order> orders = new ArrayList<Order>();
	   orders = customer.getOrders();
	   for(int i = 0; i<orders.size(); i++){
	      if(order.id==orders.get(i).id){
	         orders.remove(i);
	      }
	   }
	}
	
	public static Order getOrder(int orderId){
		List<Order> orders = new ArrayList<Order>();
		orders = getOrders();
		Order order = new Order();
		for(int i = 0; i < orders.size(); i++){
			if(orders.get(i).getId() == orderId){
				order = orders.get(i);
			}
		}
		
		return order;
	}
	
	public static String getStatusOnOrder(int order){
		List<Order> orders = new ArrayList<Order>();
		orders = getOrders();
		String status = "";
		for(int i = 0; i < orders.size(); i++){
			if(orders.get(i).getId() == order){
				status = orders.get(i).getStatus();
			}
		}
		return status;
	}
	public static Customer generateTest(){
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

}
