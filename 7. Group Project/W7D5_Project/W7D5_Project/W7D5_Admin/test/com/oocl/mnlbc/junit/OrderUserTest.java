/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.User;

/**
 * @author Kassandra Ysabel Fuentes
 * @since 07-22-2016
 */
public class OrderUserTest {

	Order order;
	User user;
	private static final int nonUser = 8;

	/**
	 * @throws java.lang.Exception
	 *             Add an order
	 */
	@Before
	public void setUp() throws Exception {
		user = new User(001, "First Name", "Last Name", "sample@email.com", "Address 1", "Address 2", "State", 2,
				"Occupation", "City", "Country", "Password", "Type");
		order = new Order(001, "", 900f, user.getUserId());
	}

	/**
	 * Test method for Order by Existing User
	 * 
	 */
	@Test
	public void getOrderExistingUser() {
		assertEquals(order.getUserId(), user.getUserId());
	}

	/**
	 * Test method for Order by Non-existing User
	 * 
	 */
	@Test
	public void getOrderNonExistingUser() {
		assertNotSame(order.getUserId(), nonUser);
	}

}
