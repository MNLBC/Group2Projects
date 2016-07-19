package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "USER_ID")
   private String userId;
   @Column(name = "FIRST_NAME")
   private String firstName;
   @Column(name = "LAST_NAME")
   private String lastName;

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
   
   public User() {
   }

   public User(String userId, String firstName, String lastName) {
      super();
      this.userId = userId;
      this.firstName = firstName;
      this.lastName = lastName;
   }

}
