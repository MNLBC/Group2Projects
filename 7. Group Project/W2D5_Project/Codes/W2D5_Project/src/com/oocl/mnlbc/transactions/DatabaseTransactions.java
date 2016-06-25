package com.oocl.mnlbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;

/**
 * 
 * @author KALINWI2
 *
 */

public class DatabaseTransactions {
	
	// Creates a connection object for DB
	private static Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "admin"; // change password of your database system
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return Client
	 * getChatUser selects a specific user from the DB for LoginClient.java
	 */
	public static Client getChatUser(String username, String password) {
		Connection conn = getConn();
		Client client = null;

		String sql = "SELECT * FROM CHAT_USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("USER_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				if (!id.equals("")) {
					client = new Client(id, firstName, lastName, username, password);
					pstmt.close();
					conn.close();
					return client;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	/**
	 * 
	 * @return List<Client>
	 * getOnlineUsers selects all users that are online in the session
	 */
	public static List<Client> getOnlineUsers() {
		Connection conn = getConn();
		ResultSet rs = null;
		List<Client> clients = new ArrayList<Client>();

		String sql = "SELECT * FROM CHAT_USERS WHERE CONN_TIMESTAMP IS NOT NULL ORDER BY CONN_TIMESTAMP";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("USER_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				if (!id.equals("")) {
					Client client = new Client(id, username, password, firstName, lastName);
					clients.add(client);

				}
			}
			pstmt.close();
			conn.close();
			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	/**
	 * 
	 * @param client
	 * @param connTimestamp
	 * @return int
	 * declareOnline updates a specific user with a connection timestamp to show that
	 * the user is online
	 */
	public static int declareOnline(Client client, String connTimestamp) {
		Connection conn = getConn();
		int result = 0;
		String userID = client.getId();
		String sql = "UPDATE CHAT_USERS SET CONN_TIMESTAMP='" + connTimestamp + "' WHERE USER_ID ='" + userID + "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @param client
	 * @param connTimestamp
	 * @return int
	 * declareOffline updates a specific user with NULL connection timestamp to show that
	 * the user is offline
	 */
	public static int declareOffline(Client client, String connTimestamp) {
		Connection conn = getConn();
		int result = 0;
		String userID = client.getId();
		String sql = "UPDATE CHAT_USERS SET CONN_TIMESTAMP = NULL WHERE USER_ID ='" + userID + "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @param username
	 * @return boolean
	 * verifyChatUser selects user records from DB using a given username
	 * If at least one record is found, it will return true
	 * This is used for validating if there is already an existing username in the DB
	 */
	public static boolean verifyChatUser(String username) {
		Connection conn = getConn();
		Client client = null;

		String sql = "SELECT * FROM CHAT_USERS WHERE USERNAME='" + username + "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("USER_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String password = rs.getString("PASSWORD");
				if (!id.equals("")) {
					client = new Client(id, firstName, lastName, username, password);
					pstmt.close();
					conn.close();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param client
	 * @return int
	 * createUser creates a record in the DB for a new user
	 */
	public static int createUser(Client client) {
		Connection conn = getConn();
		int result = 0;

		String username = client.getUsername();
		String password = client.getPassword();
		String fname = client.getFname();
		String lname = client.getLname();

		String sql = "INSERT INTO CHAT_USERS(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,ACTIVE) VALUES('" + username + "','"
				+ password + "','" + fname + "','" + lname + "','1')";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @param timestamp
	 * @return int
	 * createSession creates a new record for a session in the DB
	 */
	public static int createSession(String timestamp) {
		Connection conn = getConn();
		int result = 0;

		String sql = "INSERT INTO CHAT_SESSION(START_DT,ACTIVE) VALUES('" + timestamp + "','1')";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @param message
	 * @return int
	 * saveMessage inserts the details of a message object into the DB
	 */
	public static int saveMessage(Message message) {
		Connection conn = getConn();
		int result = 0;
		long sender = message.getClientId();
		String messageData = message.getMessage();
		long sessionID = message.getSessionId();
		String dateTime = message.getTimestamp();

		String sql = "INSERT INTO CHAT_MESSAGE(MESSAGE_SENDER,MESSAGE,SESSION_ID,MESSAGE_DT) VALUES('" + sender + "','"
				+ messageData + "','" + sessionID + "','" + dateTime + "')";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @param sessionID
	 * @param endDT
	 * @return int
	 * endSession updates a session with an end connection timestamp and active status to 0
	 * to show the session has been ended
	 */
	public static int endSession(long sessionID, String endDT) {
		Connection conn = getConn();
		int result = 0;

		String sql = "UPDATE CHAT_SESSION SET END_DT ='" + endDT + "' ACTIVE ='0' WHERE SESSION_ID='" + sessionID + "'";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @return long
	 * getActiveSessionID returns the session ID of the current active session
	 */
	public static long getActiveSessionID() {
		Connection conn = getConn();
		long sessionID = 0;
		String sql = "SELECT SESSION_ID FROM CHAT_SESSION WHERE ACTIVE='1'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("SESSION_ID");
				if (!id.equals("")) {
					sessionID = Integer.parseInt(id);
					return sessionID;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sessionID;
	}

}
