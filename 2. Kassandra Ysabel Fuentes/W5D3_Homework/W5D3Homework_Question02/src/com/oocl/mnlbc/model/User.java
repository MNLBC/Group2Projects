package com.oocl.mnlbc.model;

import java.util.List;
import javax.sql.DataSource;

public class User {
	private String userFname;
	private String userLname;
	private String userEmail;
	private String userAddress;
	private String userName;
	private String userPassword;
	private String remarks;
	private Integer id;

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}