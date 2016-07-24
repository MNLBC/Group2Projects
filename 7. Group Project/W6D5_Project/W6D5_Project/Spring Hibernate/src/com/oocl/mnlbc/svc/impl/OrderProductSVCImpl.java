package com.oocl.mnlbc.svc.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.OrderProductDAO;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.OrderProductSVC;

/**
 * 
 * @author LOPEZLA
 * @desc DAO Implementation for ORDERPRODUCT TABLE
 * @date 07-15-2016
 */
public class OrderProductSVCImpl implements OrderProductSVC {
	private OrderProductDAO orderProductDAO;

	public void setOrderProductDAO(OrderProductDAO orderProductDAO) {
		this.orderProductDAO = orderProductDAO;
	}

	@Override
	@Transactional
	public List<Product> getRelatedProducts(Order order) {
		return this.orderProductDAO.getRelatedProducts(order);
	}

	@Override
	@Transactional
	public List<CartProduct> getCartProducts(String orderId) {
		return this.orderProductDAO.getCartProducts(orderId);
	}

	@Override
	@Transactional
	public int addOrderProducts(List<CartProduct> cartProductList, int orderId, long userId) {
		return this.orderProductDAO.addOrderProducts(cartProductList, orderId, userId);
		// return 0;
	}

	@Override
	@Transactional
	public int updateOrderProduct(OrderProduct orderproduct) {
		return this.orderProductDAO.updateOrderProduct(orderproduct);

	}

	@Override
	@Transactional
	public List<Product> getOrderProductsByOrder(long id) {
		return null;

	}

	@Override
	@Transactional
	public List<CartProduct> getCartProductsByUserId(long userId) {
		return this.orderProductDAO.getCartProductByUserId(userId);
	}

}
