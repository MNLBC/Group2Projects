import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
   public static Connection getConn() {
      Connection conn = null;
      try {
           Class.forName("oracle.jdbc.driver.OracleDriver");  
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "august22");  
           
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return conn;
  }
   
   public static void insert(String[] empDetails){
      Connection conn = getConn();
      String sql = "INSERT INTO EMPLOYEE(ID,FIRST_NAME,LAST_NAME,MGRID,SALARY) VALUES(?,?,?,?,?)";
      PreparedStatement pStmt;
       try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         pStmt.setString(1, empDetails[0]);
         pStmt.setString(2, empDetails[1]);
         pStmt.setString(3, empDetails[2]);
         pStmt.setString(4, empDetails[3]);
         pStmt.setString(5, empDetails[4]);
         pStmt.executeUpdate();
         pStmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static ResultSet showAll() throws SQLException{
      Connection conn = getConn();
      Statement stmt = conn.createStatement();
      String sql = "SELECT * FROM EMPLOYEE ORDER BY ID";
      ResultSet rs = stmt.executeQuery(sql);
      //conn.close();
      return rs;
   }
   
   public static void updateLastName(String criteria, String newValue){
      Connection conn = getConn();
      String sql = "UPDATE EMPLOYEE SET LAST_NAME ='" + newValue + "' WHERE LAST_NAME ='" + criteria + "'";
      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         pStmt.executeUpdate();
         pStmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void deleteAll(){
      Connection conn = getConn();
      String sql = "DELETE FROM EMPLOYEE";
      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         pStmt.executeUpdate();
         pStmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
