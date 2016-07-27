package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OnlineUser Model
 * 
 * @author DENOYME
 * @since 2016-07-27
 */
@Entity
@Table(name = "ONLINEUSERS")
public class OnlineUser {

   @Id
   @Column(name = "USEREMAIL")
   private String userEmail;
   @Column(name = "ONLINEDATE")
   private String onlineDate;

   public String getUserEmail() {
      return userEmail;
   }

   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   public String getOnlineDate() {
      return onlineDate;
   }

   public void setOnlineDate(String onlineDate) {
      this.onlineDate = onlineDate;
   }
}
