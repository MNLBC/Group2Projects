package com.oocl.mnlbc.item2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "W6D1_ORDERITEM")
public class OrderItem implements Serializable{

	@Id
	@Column(name = "ORDERITEM_ID")
	private int orderItem_Id;
	@Column(name = "ORDERITEM_DESC")
	private String orderItem_Desc;
	@JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")
	private int orderId;
	
	public OrderItem(){
		
	}

	public int getOrderItem_Id() {
		return orderItem_Id;
	}

	public void setOrderItem_Id(int orderItem_Id) {
		this.orderItem_Id = orderItem_Id;
	}

	public String getOrderItem_Desc() {
		return orderItem_Desc;
	}

	public void setOrderItem_Desc(String orderItem_Desc) {
		this.orderItem_Desc = orderItem_Desc;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
}
