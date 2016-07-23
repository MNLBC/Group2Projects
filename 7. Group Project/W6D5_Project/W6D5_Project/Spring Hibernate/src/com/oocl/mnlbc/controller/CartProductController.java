package com.oocl.mnlbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.svc.inf.CartProductSVC;
import com.oocl.mnlbc.svc.inf.OrdersSVC;

/**
 * Handles web services for CartProduct
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
}
