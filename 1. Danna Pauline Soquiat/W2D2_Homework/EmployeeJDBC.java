package com.oocl.mnlbc.homework.w2.d2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeJDBC {
	
	public static Connection getConn(){
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "fgh567FGH%^&");  
		}catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static int insert(Employee emp) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "INSERT INTO EMPLOYEE values(?, ?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setInt(1, emp.getId());
	        pstmt.setString(2, emp.getFname());
	        pstmt.setString(3, emp.getLname());
	        pstmt.setInt(4, emp.getMgrid());
	        pstmt.setInt(5, emp.getSalary());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static int update(Employee emp, String Lname) {
		
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "UPDATE EMPLOYEE set LAST_NAME='" + emp.getLname() + "' where LAST_NAME ='" + Lname + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("Updated" + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	    
	    
	}
	
	public static Integer getAll() {
	    Connection conn = getConn();
	    String sql = "SELECT * FROM EMPLOYEE ORDER BY ID ASC";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("=============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t \t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t \t");
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
