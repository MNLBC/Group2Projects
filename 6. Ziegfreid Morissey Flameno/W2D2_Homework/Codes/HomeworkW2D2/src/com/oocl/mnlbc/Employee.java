package com.oocl.mnlbc;

/**
 * Main Employee Class
 * @author FLAMEZI2
 *
 */
public class Employee {

   private String id;
   private String firstName;
   private String lastName;
   private String mgrId;
   private String salary;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
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

   public String getMgrId() {
      return mgrId;
   }

   public void setMgrId(String mgrId) {
      this.mgrId = mgrId;
   }

   public String getSalary() {
      return salary;
   }

   public void setSalary(String salary) {
      this.salary = salary;
   }

   public Employee() {
      // TODO Auto-generated constructor stub
   }

   public Employee(String id, String firstName, String lastName, String mgrId, String salary) {
      super();
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.mgrId = mgrId;
      this.salary = salary;
   }
}
