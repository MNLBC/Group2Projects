package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.OrdersSVC;

/**
 * Handles web services for Order
 * 
 * @author DENOYME
 * @date 07-15-2016
 */
@RestController
public class OrderController {

   private OrdersSVC orderSVC;

   @Autowired(required = true)
   @Qualifier(value = "ordersService")
   public void setOrderService(OrdersSVC orderSVC) {
      this.orderSVC = orderSVC;
   }

   /**
    * getOrdersByUser web service
    * 
    * @param userid
    * @return List<Order>
    */
   @RequestMapping(value = "/GET/user/items/{userid}", method = RequestMethod.GET)
   public List<Order> getOrdersByUser(@PathVariable("userid") long userid) {
      if (userid > 0) {
         return this.orderSVC.getOrdersByUser(userid);
      }
      return null;
   }
   
   @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
   public List<Order> getOrders(){
	   return this.orderSVC.getOrders();
   }
   
   @RequestMapping(value="/deleteOrderById", method= RequestMethod.POST)
   public boolean deleteOrderById(@RequestParam long orderId){
	   int result = this.orderSVC.deleteOrderById(orderId);
	   if (orderId >= 0){
		   if(result != 1 || result == 0)
			   return false;
		   	return true;
	   }
	   return false;
   }
   
   @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
   public boolean createOrders(@RequestBody Order order){
	   int result = this.orderSVC.createOrders(order);
	      if (order != null) {
	         if (result != 1 || result == 0)
	            return false;
	         return true;
	      }
	      return false;
	   }

   @RequestMapping(value="/updateOrder", method = RequestMethod.POST)
   public boolean updateOrder(@RequestBody Order order){
   int result = this.orderSVC.updateOrder(order);
   if (order != null) {
      if (result != 1 || result == 0)
         return false;
      return true;
   }
   return false;
   }
   
   
 }
   
   
   

