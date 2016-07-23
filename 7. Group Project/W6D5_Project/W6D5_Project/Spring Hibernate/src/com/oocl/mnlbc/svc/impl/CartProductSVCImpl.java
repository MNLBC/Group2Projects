package com.oocl.mnlbc.svc.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.CartProductDAO;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.svc.inf.CartProductSVC;

/**
 * SVC Implementation for CartProduct Table
 * 
 * @author DENOYME
 * @since 2016-07-22
 */
public class CartProductSVCImpl implements CartProductSVC {

   private CartProductDAO cartProductDAO;

   public void setCartProductDAO(CartProductDAO cartProductDAO) {
      this.cartProductDAO = cartProductDAO;
   }

   @Override
   @Transactional
   public int addCartProduct(CartProduct cartproduct) {
      List<CartProduct> result = this.cartProductDAO.checkCartProduct(cartproduct);
      if(result.isEmpty())
         return this.cartProductDAO.createCartProduct(cartproduct);
      return this.cartProductDAO.updateCartProduct(result.get(0).getCartprodId(), cartproduct);
   }

//   @Override
//   @Transactional
//   public int updateCartProduct(CartProduct cartproduct) {
//      return this.cartProductDAO.updateCartProduct(cartproduct);
//   }

   @Override
   @Transactional
   public int deleteCartProductsByUser(long userid) {
      return this.cartProductDAO.deleteCartProductsByUser(userid);
   }

   @Override
   @Transactional
   public List<CartProduct> getCartProductsByUser(long userid) {
      return this.cartProductDAO.getCartProductsByUser(userid);
   }

}
