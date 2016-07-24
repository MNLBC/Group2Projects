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

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.svc.inf.CartProductSVC;
import com.oocl.mnlbc.svc.inf.OrdersSVC;

/**
 * Handles web services for AddToCart
 * 
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
public class AddToCartController {

   private CartProductSVC cartProductSVC;

   @Autowired(required = true)
   @Qualifier(value = "cartProductService")
   public void setCartProductService(CartProductSVC cartProductSVC) {
      this.cartProductSVC = cartProductSVC;
   }

   /**
    * createOrder web service
    *
    * @return boolean
    */
   @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
   public boolean addToCart(@RequestParam("userId") long userId, @RequestParam("prodId") long prodId,
      @RequestParam("prodName") String prodName, @RequestParam("prodCat") String prodCat,
      @RequestParam("prodDesc") String prodDesc, @RequestParam("prodPrice") float prodPrice,
      @RequestParam("prodSale") float prodSale, @RequestParam("prodStock") int prodStock,
      @RequestParam("prodImg") String prodImg, @RequestParam("prodQty") int prodQty,
      @RequestParam("prodSubtotal") float prodSubtotal) {
      CartProduct cartproduct = new CartProduct();
      cartproduct.setUserId(userId);
      cartproduct.setProdId(prodId);
      cartproduct.setProdName(prodName);
      cartproduct.setProdCat(prodCat);
      cartproduct.setProdDesc(prodDesc);
      cartproduct.setProdPrice(prodPrice);
      cartproduct.setProdSale(prodSale);
      cartproduct.setProdStock(prodStock);
      cartproduct.setProdImg(prodImg);
      cartproduct.setProdQty(prodQty);
      cartproduct.setProdSubtotal(prodSubtotal);
      int result = this.cartProductSVC.addCartProduct(cartproduct);
      if (cartproduct != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }
}
