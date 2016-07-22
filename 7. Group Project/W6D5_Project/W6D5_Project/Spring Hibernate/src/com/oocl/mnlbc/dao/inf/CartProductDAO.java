package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.CartProduct;

public interface CartProductDAO {

   public int createCartProduct(CartProduct cartproduct);

   public int updateCartProduct(CartProduct cartproduct);

   public int deleteCartProductsByUser(long userid);

   public List<CartProduct> getCartProductsByUser(long userid);
}
