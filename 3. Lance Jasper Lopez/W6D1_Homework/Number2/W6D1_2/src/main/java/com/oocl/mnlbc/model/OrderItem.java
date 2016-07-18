package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "H_ORDERITEM")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERITEMID")
	private int orderItemId;
	@Column(name = "ORDER_ORDERID")
	private int order_orderId;
	@Column(name = "ORDER_USER_USERID")
	private int order_user_userId;
	@Column(name = "PRODUCTID")
	private String productId;

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrder_orderId() {
		return order_orderId;
	}

	public void setOrder_orderId(int order_orderId) {
		this.order_orderId = order_orderId;
	}

	public int getOrder_user_userId() {
		return order_user_userId;
	}

	public void setOrder_user_userId(int order_user_userId) {
		this.order_user_userId = order_user_userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
}
