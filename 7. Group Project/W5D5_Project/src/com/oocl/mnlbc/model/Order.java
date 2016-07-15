/**
 * 
 */
package com.oocl.mnlbc.model;

/**
 * 
 * @author Kassandra Fuentes
 *
 */
public class Order {

   private long orderId;
   private long userId;
   private String orderDate;
   private double orderTotal;

   /**
    * @return the orderId
    */
   public long getOrderId() {
      return orderId;
   }

   /**
    * @param orderId
    *           the orderId to set
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
    *           the userId to set
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
    *           the orderDate to set
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
    *           the orderTotal to set
    */
   public void setOrderTotal(double orderTotal) {
      this.orderTotal = orderTotal;
   }

}
