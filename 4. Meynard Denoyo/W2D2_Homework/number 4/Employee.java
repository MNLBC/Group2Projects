package w2d2hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Employee {

//   private String Id;
   private String FirstName;
   private String LastName;
   private String Mgrid;
   private String Salary;
   
   public Employee(String firstname, String lastname, String mgrid, String salary){
      this.FirstName = firstname;
      this.LastName = lastname;
      this.Mgrid = mgrid;
      this.Salary = salary;
   }

   
   public String getFirstName() {
      return FirstName;
   }

   
   public void setFirstName(String firstName) {
      FirstName = firstName;
   }

   
   public String getLastName() {
      return LastName;
   }

   
   public void setLastName(String lastName) {
      LastName = lastName;
   }

   
   public String getMgrid() {
      return Mgrid;
   }

   
   public void setMgrid(String mgrid) {
      Mgrid = mgrid;
   }

   
   public String getSalary() {
      return Salary;
   }

   
   public void setSalary(String salary) {
      Salary = salary;
   }
   
   
}
