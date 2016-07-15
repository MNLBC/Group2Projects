package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.dao.OrderProductDAOImpl;

public class OrderProductDAOImplTest {
	OrderProductDAOImpl orderProdDAO = new OrderProductDAOImpl();

	@Test
	public void testAddProduct() {
		Order order = new Order();
		Product prod = new Product();
		order.setOrderId(3);
		prod.setProdId(1);
		int result = orderProdDAO.addProduct(order, prod, 1);
		assert(result > 0);
	}

	@Test
	public void testRemoveProduct() {
		int result = orderProdDAO.removeProduct("3", "1", 1);
		assert(result>0);
	}

	@Test
	public void testGetRelatedProducts() {
		Order order = new Order();
		order.setOrderId(1);
		assert(orderProdDAO.getRelatedProducts(order)!=null);
	}

	@Test
	public void testGetCartProducts() {
		Order order = new Order();
		order.setOrderId(1);
		assert(orderProdDAO.getCartProducts("1")!=null);
	}

}
