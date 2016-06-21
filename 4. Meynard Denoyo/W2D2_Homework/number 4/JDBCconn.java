package w2d2hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCconn {

   public static void main(String[] args){
      
   }
   
   public static void insert(Employee employee){
      Connection conn = getConn();
      PreparedStatement pstmt;
      String sql = "insert into employee (first_name, last_name, mgrid, salary) values (?,?,?,?)";
      
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         pstmt.setString(1, employee.getFirstName());
         pstmt.setString(2, employee.getLastName());
         pstmt.setString(3, employee.getMgrid());
         pstmt.setString(4, employee.getSalary());
         pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public static void modify(String criterianame, String value, String columnnameset, String valueset){
      Connection conn = getConn();
      PreparedStatement pstmt;
      String sql = "update employee set " + columnnameset + "='" + valueset + "' where "+ criterianame +"='" + value + "'";
      
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   private static Connection getConn() {
      // TODO Auto-generated method stub
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String username = "system";
      String password = "Zenf0ne2";
      Connection conn = null;
      
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return conn;
   }

   public static void getAll() {
      // TODO Auto-generated method stub
      Connection conn = getConn();
      String sql = "select * from employee ORDER BY ID";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         int col = rs.getMetaData().getColumnCount();
         System.out.println("============================");
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
   }
}
