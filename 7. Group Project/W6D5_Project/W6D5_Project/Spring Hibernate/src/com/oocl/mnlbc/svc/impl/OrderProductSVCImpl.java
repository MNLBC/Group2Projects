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
   public int addOrderProducts(List<OrderProduct> orderproductlist) {
      return this.orderProductDAO.addOrderProduct(orderproductlist);
//	   return 0;
   }

	@Override
   @Transactional
   public int updateOrderProduct(OrderProduct orderproduct) {
       return this.orderProductDAO.updateOrderProduct(orderproduct);
//      return 0;
   }

   @Override
   @Transactional
   public List<Product> getOrderProductsByOrder(long id) {
      return null;
//      return this.orderProductDAO.getOrderProductsByOrder(id);
   }

}
