package com.oocl.mnlbc.item2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "W6D1_ORDER")
public class Orders implements Serializable{

	@Id
	@Column(name = "ORDER_ID")
	private int orderId;
	@Column(name = "ORDER_DESC")
	private String orderDesc;
	@JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
	private String username;
	
	public Orders(){
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
