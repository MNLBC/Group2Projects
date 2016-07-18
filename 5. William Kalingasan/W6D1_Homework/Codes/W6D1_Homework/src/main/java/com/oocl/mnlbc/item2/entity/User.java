package com.oocl.mnlbc.item2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "W6D1_USER")
public class User implements Serializable{
	
	@Id
	@Column(name = "USERNAME")
	private String username;
	@Column(name="USERFULLNAME")
	private String userFullName;
	
	public User(){
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
	
	
}
