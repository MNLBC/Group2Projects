import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRecOperation {
	public static Connection getConn() {

		Connection conn = null;
		try {

			// Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static boolean create_table() throws SQLException {
		Connection conn = getConn();

		String sql = "CREATE TABLE EMPLOYEE (ID VARCHAR2(20) NOT NULL, FIRST_NAME VARCHAR2(20), LAST_NAME VARCHAR2(20) , MGRID VARCHAR2(20), SALARY VARCHAR2(20) , CONSTRAINT EMPLOYEE_PK PRIMARY KEY (ID ) ENABLE )";
		Statement state;

		DatabaseMetaData dbm = conn.getMetaData();

		ResultSet tables = dbm.getTables(null, null, "EMPLOYEE", null);

		int count = 0;
		while (tables.next()) {
			count++;
		}
		if (count == 0) {
			state = conn.createStatement();
			if (state.executeUpdate(sql) >= 0) {
				System.out.println("Successfully created table");
				return true;
			} else {
				System.out.println("Cannot create table");
			}
		} else {
			System.out.println("Table already exist");
		}

		return false;
	}

	public static int insert(Employee employee) {
		Connection conn = getConn();
		int i = 0;
		String sql = "insert into EMPLOYEE values(?, ?,?,?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, employee.getId());
			pstmt.setString(2, employee.getFirstName());
			pstmt.setString(3, employee.getLastName());
			pstmt.setString(4, employee.getMgrid());
			pstmt.setString(5, employee.getSalary());
			
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Record exists already.");
		}
		return i;
	}
	
	 public static int update(Employee employee) {
	 Connection conn = getConn();
	 int i = 0;
	 String sql = "update EMPLOYEE set mgrid='" + employee.getMgrid() + "', first_name ='" + employee.getFirstName() + "', last_name='"
			 + employee.getLastName() + "', salary='" + employee.getSalary()
			 +"' where ID ='" + employee.getId() + "'";
	 PreparedStatement pstmt;
	 try {
	 pstmt = (PreparedStatement) conn.prepareStatement(sql);
	 i = pstmt.executeUpdate();
	 System.out.println("result: " + i);
	 pstmt.close();
	 conn.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 return i;
	 }
	 
	 
	 public static int updateLastName(Employee employee, String lastName) {
		 Connection conn = getConn();
		 int i = 0;
		 String sql = "update EMPLOYEE set last_name='" + lastName 
				 +"' where last_name ='" + employee.getLastName() + "'";
		 PreparedStatement pstmt;
		 try {
		 pstmt = (PreparedStatement) conn.prepareStatement(sql);
		 i = pstmt.executeUpdate();
		 System.out.println("result: " + i);
		 pstmt.close();
		 conn.close();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return i;
		 }


	public static int delete(String first_name) {
		Connection conn = getConn();
		int i = 0;
		String sql = "delete from EMPLOYEE where first_name='" + first_name + "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("result: " + i);
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
		String sql = "delete from EMPLOYEE";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("result: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static Integer getAll() {
		Connection conn = getConn();
		String sql = "select * from EMPLOYEE ORDER BY ID";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println();
			System.out.println("Employees");
			System.out.println("============================");
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + '\t');
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
