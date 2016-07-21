package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.OrderProductSVC;
import com.oocl.mnlbc.svc.inf.OrdersSVC;

/**
 * Handles web services for Checkout
 * 
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
@ResponseBody
public class CheckoutController {

   private OrdersSVC orderSVC;
   private OrderProductSVC orderprodSVC;

   @Autowired(required = true)
   @Qualifier(value = "orderService")
   public void setProdService(OrdersSVC orderSVC) {
      this.orderSVC = orderSVC;
   }

   @Autowired(required = true)
   @Qualifier(value = "orderProductService")
   public void setOrderProdService(OrderProductSVC orderprodSVC) {
      this.orderprodSVC = orderprodSVC;
   }
   
   /**
    * createOrder web service
    * 
    * @return boolean
    */
   @RequestMapping(value = "/checkout", method = RequestMethod.POST)
   public boolean createOrder(@RequestParam("userid") int userid, @RequestParam("orderproductlist") List<OrderProduct> orderproductlist) {
      int result = this.orderSVC.createOrder(userid, orderproductlist);
      this.addOrderProducts(orderproductlist);
      if (userid >= 0 && orderproductlist != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }
   
   /**
    * calls OrderProductSVCImpl to add Order Products to OrderProduct table
    * 
    * @return boolean
    */
   public boolean addOrderProducts(List<OrderProduct> orderproductlist) {
      int result = this.orderprodSVC.addOrderProducts(orderproductlist);
      if (orderproductlist != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

}
