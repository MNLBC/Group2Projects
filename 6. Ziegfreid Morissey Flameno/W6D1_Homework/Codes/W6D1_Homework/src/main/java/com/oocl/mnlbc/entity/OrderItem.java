package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Order Item entity
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {

   @Id
   // (strategy = GenerationType.AUTO)
   @Column(name = "ORDER_ITEM_ID")
   private String orderItemId;
   @Column(name = "ORDER_ITEM_NAME")
   private String orderItemName;
   @Column(name = "ORDER_ITEM_QUANTITY")
   private String orderItemQuantity;
   @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   private Order orderId;

   public OrderItem() {
   }

   public String getOrderItemId() {
      return orderItemId;
   }

   public void setOrderItemId(String orderItemId) {
      this.orderItemId = orderItemId;
   }

   public String getOrderItemName() {
      return orderItemName;
   }

   public void setOrderItemName(String orderItemName) {
      this.orderItemName = orderItemName;
   }

   public String getOrderItemQuantity() {
      return orderItemQuantity;
   }

   public void setOrderItemQuantity(String orderItemQuantity) {
      this.orderItemQuantity = orderItemQuantity;
   }

   public Order getOrder() {
      return orderId;
   }

   public void setOrder(Order orderId) {
      this.orderId = orderId;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (orderItemId != null ? orderItemId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof OrderItem)) {
         return false;
      }
      OrderItem other = (OrderItem) object;
      if ((this.orderItemId == null && other.orderItemId != null)
         || (this.orderItemId != null && !this.orderItemId.equals(other.orderItemId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "OrderItem{" + "orderItemId=" + orderItemId + ", orderItemName=" + orderItemName + ", orderItemQuantity"
         + orderItemQuantity + "}";
   }
}
