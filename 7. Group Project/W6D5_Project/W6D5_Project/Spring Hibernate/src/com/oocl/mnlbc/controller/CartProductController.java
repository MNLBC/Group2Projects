package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.svc.inf.CartProductSVC;

/**
 * Handles web services for CartProduct
 * 
 * @author DENOYME
 * @since 2016-07-22
 */
@RestController
public class CartProductController {

   private CartProductSVC cartProductSVC;

   @Autowired(required = true)
   @Qualifier(value = "cartProductService")
   public void setCartProductService(CartProductSVC cartProductSVC) {
      this.cartProductSVC = cartProductSVC;
   }

   /**
    * deleteCartProduct by user web service
    * 
    * @param userid
    * @return boolean
    */
   @RequestMapping(value = "/deleteCartByUser", method = RequestMethod.POST)
   public boolean deleteCart(@RequestParam("userid") long userid) {
      int result = this.cartProductSVC.deleteCartProductsByUser(userid);
      if (userid >= 0) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

   /**
    * deleteCartProduct by product web service
    * 
    * @param prodid
    * @param userid
    * @return boolean
    */
   @RequestMapping(value = "/deleteCartByProduct", method = RequestMethod.POST)
   public boolean deleteCartProductsByProduct(@RequestParam("prodid") long prodid,
      @RequestParam("userid") long userid) {
      int result = this.cartProductSVC.deleteCartProductsByProduct(prodid, userid);
      if (prodid >= 0) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

   /**
    * getCart by user web service
    * 
    * @param userid
    * @return List<CartProduct>
    */
   @RequestMapping(value = "/getCartByUser", method = RequestMethod.POST)
   public List<CartProduct> getCartProductsByUser(@RequestParam("userid") long userid) {
      if (userid >= 0) {
         return this.cartProductSVC.getCartProductsByUser(userid);
      }
      return null;
   }
}
