/**
 * 
 */
package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Lance Jasper C. Lopez
 * @since 07-21-2016
 * @desc Hibernate Migration to JPA Order Model
 * 
 */

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ORDERID")
	@SequenceGenerator(name = "order_seq", sequenceName = "ORDERS_SEQ3", allocationSize = 1)
	@GeneratedValue(generator = "order_seq", strategy = GenerationType.SEQUENCE)
	private long orderId;

	@Column(name = "ORDERDATE")
	private String orderDate;
	@Column(name = "ORDERTOTAL")
	private float orderTotal;
	@Column(name = "USERID")
	private long userId;

	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderTotal
	 */
	public double getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal
	 *            the orderTotal to set
	 */
	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @param orderId
	 * @param orderDate
	 * @param orderTotal
	 * @param userId
	 */
	public Order(long orderId, String orderDate, float orderTotal, long userId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.userId = userId;
	}
	
	public Order() {
		
	}

}
