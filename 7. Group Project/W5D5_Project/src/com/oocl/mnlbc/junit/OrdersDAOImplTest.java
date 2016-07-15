package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mnlbc.util.Timestamp;
import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.OrdersDAOImpl;

public class OrdersDAOImplTest {
	OrdersDAOImpl orderDAO = new OrdersDAOImpl();
	
	@Test
	public void testCreateOrder() {
		User user = new User();
		user.setUserId(1);
		int result = orderDAO.createOrder(user);
		assert(result > 0);
	}

	@Test
	public void testGetOrderId() {
		User user = new User();
		user.setUserId(1);
		assert(orderDAO.getOrderId(user)!=null);
	}

	@Test
	public void testGetOrder() {
		User user = new User();
		user.setUserId(1);
		assert(orderDAO.getOrder(user)!=null);
	}
	
	@Test
	public void testFinalOrder() {
		User user = new User();
		user.setUserId(1);
		int result = orderDAO.finalOrder(orderDAO.getOrder(user), Timestamp.getTimestamp());
		assert(result>0);
	}
	
	@Test
	public void testCancelOrder() {
		User user = new User();
		user.setUserId(1);
		int result = orderDAO.cancelOrder(orderDAO.getOrder(user));
		assert(result>0);
	}

}
