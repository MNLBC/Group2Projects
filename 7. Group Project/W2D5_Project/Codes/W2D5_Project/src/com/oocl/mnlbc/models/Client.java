package com.oocl.mnlbc.models;

/**
 * Base Client class
 * 
 * @author FLAMEZI2 Group 2
 *
 */
public class Client {

   private String id;
   private String fname;
   private String lname;
   private String username;
   private String password;

   /**
    * new Client Constructor
    * 
    * @param fname
    * @param lname
    * @param username
    * @param password
    */
   public Client(String username, String password, String fname, String lname) {
      super();
      this.fname = fname;
      this.lname = lname;
      this.username = username;
      this.password = password;
   }

   public Client(String id, String fname, String lname, String username, String password) {
      super();
      this.id = id;
      this.fname = fname;
      this.lname = lname;
      this.username = username;
      this.password = password;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getFname() {
      return fname;
   }

   public void setFname(String fname) {
      this.fname = fname;
   }

   public String getLname() {
      return lname;
   }

   public void setLname(String lname) {
      this.lname = lname;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

}
