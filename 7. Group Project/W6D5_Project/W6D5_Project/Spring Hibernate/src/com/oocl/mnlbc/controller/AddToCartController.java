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

import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.svc.inf.OrdersSVC;

/**
 * Handles web services for AddToCart
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
@ResponseBody
public class AddToCartController {

   private CartProductSVC cartprodSVC;
   
   @Autowired(required = true)
   @Qualifier(value = "cartProductService")
   public void setProdService(CartProductSVC cartprodSVC) {
      this.cartprodSVC = cartprodSVC;
   }
   
   /**
    * createOrder web service
    * 
    * @return boolean
    */
   @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
   public boolean addToCart(@RequestBody Product product) {
      int result = this.cartprodSVC.addToCart(product);
      if (product != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }
}
