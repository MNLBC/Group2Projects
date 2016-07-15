package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.dao.ProductDAOImpl;

public class ProductDAOImplTest {
	ProductDAOImpl prodDAO = new ProductDAOImpl();

	@Test
	public void testGetProducts() {
		assert(prodDAO.getProducts()!=null);
	}

	@Test
	public void testUpdateStock() {
		String[] sample = {"1","2"};
		int result = prodDAO.updateStock(sample);
		assert(result>0);
		
	}

	@Test
	public void testGetProductsByCategory() {
		assert(prodDAO.getProductsByCategory("Dress")!=null);
	}

	@Test
	public void testGetProduct() {
		assert(prodDAO.getProduct("1")!=null);
	}

	@Test
	public void testCountProductByCat() {
		assert(prodDAO.countProductByCat().contains(":"));
	}

	@Test
	public void testGetOrderProd() {
		User user = new User();
		user.setUserId(1);
		assert(prodDAO.getOrderProd(user)!=null);
	}

}
