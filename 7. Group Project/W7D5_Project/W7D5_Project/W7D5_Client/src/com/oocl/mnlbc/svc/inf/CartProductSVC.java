package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.CartProduct;

public interface CartProductSVC {

	public int addCartProduct(CartProduct cartproduct);

	public int deleteCartProductsByUser(long userid);

	public int deleteCartProductsByProduct(long prodid, long userid);

	public List<CartProduct> getCartProductsByUser(long userid);
}
