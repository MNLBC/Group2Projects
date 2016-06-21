package com.oocl.mnlbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOperations {

   /**
    * Gets database connection
    * @return
    */
   public static Connection getConn() {
      Connection conn = null;
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin123");

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return conn;
   }

   /**
    * Creates Employee Table
    * @return
    */
   public static int createTable() {
      Connection conn = getConn();
      int i = 0;
      String sql =
         "CREATE TABLE SYSTEM.EMPLOYEE ( ID NUMBER NOT NULL ENABLE, FIRST_NAME VARCHAR2(20 BYTE), LAST_NAME VARCHAR2(20 BYTE), MGRID VARCHAR2(20 BYTE), SALARY FLOAT(126), CONSTRAINT EMPLOYEE_PK PRIMARY KEY (ID))";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         i = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return i;
   }
   
   /**
    * Drops Employee Table
    * @return
    */
   public static int dropTable(){
      Connection conn = getConn();
      int i = 0;
      String sql =
         "drop table employee";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         i = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return i;
   }

   /**
    * Insert Employee to table
    * @param employee
    * @return
    */
   public static int insertEmployee(Employee employee) {
      Connection conn = getConn();
      int i = 0;
      String sql = "insert into employee values(?,?,?,?,?)";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         pstmt.setString(1, employee.getId());
         pstmt.setString(2, employee.getFirstName());
         pstmt.setString(3, employee.getLastName());
         pstmt.setString(4, employee.getMgrId());
         pstmt.setString(5, employee.getSalary());
         i = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return i;
   }

   /**
    * Updates last name of record 
    * @param oldLastName
    * @param newLastName
    * @return
    */
   public static int updateLastName(String oldLastName, String newLastName) {
      Connection conn = getConn();
      int i = 0;
      String sql = "update employee set last_name='" + newLastName + "'where last_name like '%" + oldLastName + "%'";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         i = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return i;
   }

   /**
    * Prints out all the records
    * @return
    */
   public static Integer getAll() {
      Connection conn = getConn();
      String sql = "select * from employee order by id";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         int col = rs.getMetaData().getColumnCount();
         while (rs.next()) {
            for (int i = 1; i <= col; i++) {
               System.out.print(rs.getString(i) + "\t");
               if ((i == 2) && (rs.getString(i).length() < 8)) {
                  System.out.print("\t");
               }
            }
            System.out.println("");
         }
         System.out.println("============================");
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;
   }

}
