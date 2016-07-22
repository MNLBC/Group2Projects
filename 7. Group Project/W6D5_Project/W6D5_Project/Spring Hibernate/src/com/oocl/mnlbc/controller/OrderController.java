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

import com.oocl.mnlbc.model.Order;
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
   
   //http://localhost:port/GET/userr/items/{userid}

   /**
    * getOrdersByUser web service
    * 
    * @return List<Order>
    */
   @RequestMapping(value = "/GET/order/getOrdersByUser/{userid}", method = RequestMethod.GET)
   public List<Order> getOrdersByUser(@PathVariable("userid") long userid) {
      if (userid > 0) {
         return this.orderSVC.getOrdersByUser(userid);
      }
      return null;
   }
}
