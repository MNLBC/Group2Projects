/**
 * 
 */
package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lance Jasper C. Lopez
 * @since 07-21-2016
 * @desc Hibernate Migration to JPA Order Products Model
 * 
 */

@Entity
@Table(name = "ORDERPRODUCT")
public class OrderProduct {
	
	@Id
	@Column(name = "ORDERPRODID")
	private long orderProdId;
	@Column(name = "ORDERID")
	private long orderId;
	@Column(name = "PRODID")
	private long prodId;
	@Column(name = "ORDERPRODQTY")
	private int orderProdQty;

	/**
	 * @return the orderProdId
	 */
	
	
	public long getOrderProdId() {
		return orderProdId;
	}

	/**
	 * @param orderProdId
	 *            the orderProdId to set
	 */
	public void setOrderProdId(long orderProdId) {
		this.orderProdId = orderProdId;
	}

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
	 * @return the prodId
	 */
	public long getProdId() {
		return prodId;
	}

	/**
	 * @param prodId
	 *            the prodId to set
	 */
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	/**
	 * @return the orderProdQty
	 */
	public int getOrderProdQty() {
		return orderProdQty;
	}

	/**
	 * @param orderProdQty
	 *            the orderProdQty to set
	 */
	public void setOrderProdQty(int orderProdQty) {
		this.orderProdQty = orderProdQty;
	}

}
