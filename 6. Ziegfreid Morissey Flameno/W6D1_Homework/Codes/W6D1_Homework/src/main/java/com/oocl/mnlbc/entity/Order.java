package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Orders entity
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

   @Id
   // (strategy = GenerationType.AUTO)
   @Column(name = "ORDER_ID")
   private String orderId;
   @Column(name = "ORDER_DATE")
   private String orderDate;
   @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   private User userId;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
   private List<OrderItem> orderItemList;

   public Order() {
   }

   public String getOrderId() {
      return orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }

   public String getOrderDate() {
      return orderDate;
   }

   public void setOrderDate(String orderDate) {
      this.orderDate = orderDate;
   }

   public User getUserId() {
      return userId;
   }

   public void setUserId(User userId) {
      this.userId = userId;
   }

   public List<OrderItem> getOrderItemList() {
      return orderItemList;
   }

   public void setOrderItemList(List<OrderItem> orderItemList) {
      this.orderItemList = orderItemList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (orderId != null ? orderId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Order)) {
         return false;
      }
      Order other = (Order) object;
      if ((this.orderId == null && other.orderId != null)
         || (this.orderId != null && !this.orderId.equals(other.orderId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      int size = orderItemList.size();
      return "Order{" + "orderId=" + orderId + ", orderName=" + orderDate + ", orderItemList=" + orderItemList + " }";
   }
}
