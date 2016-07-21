package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
@ResponseBody
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
    * @return List<Order>
    */
   @RequestMapping(value = "/getOrdersByUser", method = RequestMethod.GET)
   public List<Order> getOrdersByUser(@RequestParam int id) {
      if (id > 0) {
         return this.orderSVC.getOrdersByUser(id);
      }
      return null;
   }
}
