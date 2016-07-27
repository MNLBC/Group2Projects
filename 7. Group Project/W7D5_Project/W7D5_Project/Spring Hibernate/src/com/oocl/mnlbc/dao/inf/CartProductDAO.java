package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.CartProduct;

public interface CartProductDAO {

   public int createCartProduct(CartProduct cartproduct);

   public int updateCartProduct(long cartprodid, CartProduct cartproduct);

   public int deleteCartProductsByUser(long userid);

   public List<CartProduct> getCartProductsByUser(long userid);

   public List<CartProduct> checkCartProduct(CartProduct cartproduct);

   public int deleteCartProductsByProduct(long prodid, long userid);
}
