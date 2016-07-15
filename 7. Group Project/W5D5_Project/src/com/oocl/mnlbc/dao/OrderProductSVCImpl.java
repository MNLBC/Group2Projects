package com.oocl.mnlbc.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;

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
	public int addProduct(Order order, Product prod, int qty) {
		return this.orderProductDAO.addProduct(order, prod, qty);
	}

	@Override
	@Transactional
	public int removeProduct(String orderId, String prodId, int qty) {
		return this.orderProductDAO.removeProduct(orderId, prodId, qty);
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
	public int updateProduct(String orderId, String productId, int qty) {
		return this.orderProductDAO.updateProduct(orderId, productId, qty);
	}

}
