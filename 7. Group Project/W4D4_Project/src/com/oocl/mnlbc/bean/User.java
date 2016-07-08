/**
 * 
 */
package com.oocl.mnlbc.bean;

/**
 * @author Kassandra Fuentes
 *
 */
public class User {

   private long userId;
   private String userFname;
   private String userLname;
   private String userEmail;
   private String userStreet;
   private String userCity;
   private String userCountry;
   private String userPass;
   private String userType;

   public User(long userId, String userFname, String userLname, String userEmail, String userStreet, String userCity,
		String userCountry, String userPass, String userType) {
	super();
	this.userId = userId;
	this.userFname = userFname;
	this.userLname = userLname;
	this.userEmail = userEmail;
	this.userStreet = userStreet;
	this.userCity = userCity;
	this.userCountry = userCountry;
	this.userPass = userPass;
	this.userType = userType;
}
   
   public User(){
	   
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
    * @return the userFname
    */
   public String getUserFname() {
      return userFname;
   }

   /**
    * @param userFname
    *           the userFname to set
    */
   public void setUserFname(String userFname) {
      this.userFname = userFname;
   }

   /**
    * @return the userLname
    */
   public String getUserLname() {
      return userLname;
   }

   /**
    * @param userLname
    *           the userLname to set
    */
   public void setUserLname(String userLname) {
      this.userLname = userLname;
   }

   /**
    * @return the userEmail
    */
   public String getUserEmail() {
      return userEmail;
   }

   /**
    * @param userEmail
    *           the userEmail to set
    */
   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   /**
    * @return the userStreet
    */
   public String getUserStreet() {
      return userStreet;
   }

   /**
    * @param userStreet
    *           the userStreet to set
    */
   public void setUserStreet(String userStreet) {
      this.userStreet = userStreet;
   }

   /**
    * @return the userCity
    */
   public String getUserCity() {
      return userCity;
   }

   /**
    * @param userCity
    *           the userCity to set
    */
   public void setUserCity(String userCity) {
      this.userCity = userCity;
   }

   /**
    * @return the userCountry
    */
   public String getUserCountry() {
      return userCountry;
   }

   /**
    * @param userCountry
    *           the userCountry to set
    */
   public void setUserCountry(String userCountry) {
      this.userCountry = userCountry;
   }

   /**
    * @return the userPass
    */
   public String getUserPass() {
      return userPass;
   }

   /**
    * @param userPass
    *           the userPass to set
    */
   public void setUserPass(String userPass) {
      this.userPass = userPass;
   }

   /**
    * @return the userType
    */
   public String getUserType() {
      return userType;
   }

   /**
    * @param userType
    *           the userType to set
    */
   public void setUserType(String userType) {
      this.userType = userType;
   }

}
