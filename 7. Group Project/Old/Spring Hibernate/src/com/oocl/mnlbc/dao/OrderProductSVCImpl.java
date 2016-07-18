package com.oocl.mnlbc.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
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
		OrderProduct orderProd = new OrderProduct();
		orderProd.setOrderId(order.getOrderId());
		orderProd.setProdId(prod.getProdId());
		orderProd.setOrderProdQty(qty);
		return this.orderProductDAO.addOrderProduct(orderProd);
	}

//	@Override
//	@Transactional
//	public int removeProduct(String orderId, String prodId, int qty) {
//		OrderProduct orderProd = new OrderProduct();
//		orderProd.setOrderId(Long.parseLong(orderId));
//		orderProd.setProdId(Long.parseLong(prodId));
//		orderProd.setOrderProdQty(qty);
//		return this.orderProductDAO.removeOrderProduct(orderProd);
//	}

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
		OrderProduct orderProd = new OrderProduct();
		orderProd.setOrderId(Long.parseLong(orderId));
		orderProd.setProdId(Long.parseLong(productId));
		orderProd.setOrderProdQty(qty);
		
		return this.orderProductDAO.updateOrderProduct(orderProd);
	}

}
