package com.oocl.mnlbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oocl.mnlbc.dao.inf.OrdersDAO;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.User;


/**
 * 
 * @author kalinwi2
 * DAO Implementation for ORDERS TABLE
 */
public class OrdersDAOImpl implements OrdersDAO {
	private static final Logger logger = LoggerFactory.getLogger(OrdersDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public int createOrder(Order o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(o);
		logger.info("Order saved successfully, Order details="+o);
		return 1;
	}

	@Override
	public int cancelOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order o = (Order) session.load(Order.class, new Integer(id));
		if(null != o){
			session.delete(o);
		}
		logger.info("Order deleted successfully, Order details="+o);
		return 1;
	}

//	@Override
//	public int finalOrder(Order order, String timestamp) {
//		
//	}
//
//	@Override
//	public Order getOrderId(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
