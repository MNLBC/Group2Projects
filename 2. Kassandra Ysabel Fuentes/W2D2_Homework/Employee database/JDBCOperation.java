package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOperation {
	public static Connection getConn() {
//	    String driver = "com.mysql.jdbc.Driver";
//	    String url = "jdbc:mysql://localhost:3306/samp_db";
//	    String username = "root";
//	    String password = "";
	    Connection conn = null;
	    try {
//	        Class.forName(driver); //classLoader,加载对应驱动
//	        conn = (Connection) DriverManager.getConnection(url, username, password);

	        //Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");  
            
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static int insert(Employee emp) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into employee (ID, first_name, last_name, mgr_Id, salary) values(?, ?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, emp.getId());
	        pstmt.setString(2, emp.getFirstName());
	        pstmt.setString(3, emp.getLastName());
	        pstmt.setString(4, emp.getMgrId());
	        pstmt.setString(5, emp.getSalary());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static int update(String param1, String param2) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update employee set last_name='" + param1 + "' where last_name='" + param2 + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static int delete(String firstname) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from employee where first_name='" + firstname + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}

	
	public static int deleteAll() {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from employee";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from employee order by id asc";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
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
	    return null;
	}
}
