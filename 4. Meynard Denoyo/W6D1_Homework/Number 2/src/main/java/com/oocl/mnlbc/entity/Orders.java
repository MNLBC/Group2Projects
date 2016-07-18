package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@Column(name = "order_id")
	private int id;
	@JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrderItem itemid;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Users userid;
	@Column(name = "order_qty")
	private int qty;
	@Column(name = "order_subtotal")
	private double subtotal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrderItem getItemid() {
		return itemid;
	}
	public void setItemid(OrderItem itemid) {
		this.itemid = itemid;
	}
	public Users getUserid() {
		return userid;
	}
	public void setUserid(Users userid) {
		this.userid = userid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
