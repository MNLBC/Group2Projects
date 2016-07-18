package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "H_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERID")
	private int orderId;
	@Column(name = "USER_USERID")
	private int user_userId;
	@Column(name = "DATEOFORDER")
	private String dateOfOrder;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUser_userId() {
		return user_userId;
	}

	public void setUser_userId(int user_userId) {
		this.user_userId = user_userId;
	}

	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	
}
