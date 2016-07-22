/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.model.User;

/**
 * @author Kassandra Ysabel Fuentes
 * @since 07-22-2016
 *
 */
public class ProductUserTest {

	Product product;
	private static final long productId = 4;
	private static final String productCategory = "No Category";

	/**
	 * @throws java.lang.Exception
	 *             Create Product
	 */
	@Before
	public void setUp() throws Exception {
		product = new Product(001, "Product Name", "Product Description", "Product Category", "Product Image", 350f,
				.75f, 100);
	}

	/**
	 * Test method for null create product
	 */
	@Test
	public void testCreateProd() {
		Product product = new Product();
		assertNotNull(product);
	}

	/**
	 * Test method for get products per category
	 */
	@Test
	public void testGetProductsByCategory() {
	boolean check = false;
		
		if (productCategory.equals(product.getProdCat())) {
			check = true;
		} else {
			check = false;
		}
		assertFalse(check);
	}

	/**
	 * Test method for remove product
	 */
	@Test
	public void testRemoveProduct() {
		boolean check = false;
		
		if (productId == product.getProdId()) {
			check = true;
		} else {
			check = false;
		}
		assertFalse(check);
	}

}
