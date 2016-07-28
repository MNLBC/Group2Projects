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

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.OrderProductSVC;

/**
 * Handles web services for OrderProduct
 * 
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
public class OrderProductsController {

   private OrderProductSVC orderprodSVC;

   @Autowired(required = true)
   @Qualifier(value = "orderProductService")
   public void setOrderProdService(OrderProductSVC orderprodSVC) {
      this.orderprodSVC = orderprodSVC;
   }

   /**
    * updateOrderProduct web service
    * 
    * @param orderproduct
    * @return boolean
    */
   @RequestMapping(value = "/updateOrderProduct", method = RequestMethod.POST)
   public boolean updateOrderProduct(@RequestBody OrderProduct orderproduct) {
      int result = this.orderprodSVC.updateOrderProduct(orderproduct);
      if (orderproduct != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

   /**
    * getOrderProductsByOrder web service
    * 
    * @param id
    * @return List<Product>
    */
   @RequestMapping(value = "/getOrderProductsByOrder", method = RequestMethod.GET)
   public List<OrderProduct> getOrderProductsByOrder(@RequestParam long id) {
      if (id >= 0) {
         return this.orderprodSVC.getOrderProductsByOrder(id);
      }
      return null;
   }
}
