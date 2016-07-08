/**
 * 
 */
package com.oocl.mnlbc.bean;


/**
 * @author Kassandra Fuentes
 *
 */
public class Order {
   private long orderId;
   private long userId;
   private long orderProductId;
   private double totalOrder;
public long getOrderId() {
	return orderId;
}
public void setOrderId(long orderId) {
	this.orderId = orderId;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public long getOrderProductId() {
	return orderProductId;
}
public void setOrderProductId(long orderProductId) {
	this.orderProductId = orderProductId;
}
public double getTotalOrder() {
	return totalOrder;
}
public void setTotalOrder(double totalOrder) {
	this.totalOrder = totalOrder;
}

}
