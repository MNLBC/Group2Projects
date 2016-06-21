package com.oocl.mnlbc;

public class TestJDBC {

   /**
    * Main test method
    * @param args
    */
   public static void main(String[] args) {
//      JDBCOperations.dropTable();
      JDBCOperations.createTable();

      JDBCOperations.getAll();

      JDBCOperations.insertEmployee(new Employee("1", "rose", "Tyler", "4", "1500"));
      JDBCOperations.insertEmployee(new Employee("2", "Matha", "Jones", "4", "2200"));
      JDBCOperations.insertEmployee(new Employee("3", "Donna", "Noble", "4", "1300"));
      JDBCOperations.insertEmployee(new Employee("4", "Doctor", "Who", " ", "5500"));
      JDBCOperations.insertEmployee(new Employee("5", "Jack", "Harkness", "1", "3500"));

      JDBCOperations.getAll();

      JDBCOperations.insertEmployee(new Employee("6", "Alex", "Lee", "1", "4500"));

      JDBCOperations.getAll();

      JDBCOperations.updateLastName("Jones", "Tate");

      JDBCOperations.getAll();

   }

}
