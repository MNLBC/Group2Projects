/**
 * 
 */
package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Danna Soquiat
 *@since 2016-07-15
 */

@Entity
@Table(name="ORDER")
public class Order {
	
   @Id	
   @Column(name="orderId")
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
