package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Users entity
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "USER_ID")
   private String userId;
   @Column(name = "FIRST_NAME")
   private String firstName;
   @Column(name = "LAST_NAME")
   private String lastName;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
   private List<Order> orderList;

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public List<Order> getOrderList() {
      return orderList;
   }

   public void setOrderList(List<Order> orderList) {
      this.orderList = orderList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (userId != null ? userId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof User)) {
         return false;
      }
      User other = (User) object;
      if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      int size = orderList.size();
      return "com.oocl.mnlbc.entity.User[ userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
         + ", orderList=" + orderList + " ]";
   }
}
