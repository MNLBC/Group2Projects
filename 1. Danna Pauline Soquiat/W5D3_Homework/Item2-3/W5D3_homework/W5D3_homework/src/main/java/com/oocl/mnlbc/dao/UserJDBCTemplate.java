package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String username, String password, String firstName, String middleName, String lastName,
			String email, String contactNumber) {
		String SQL = "insert into W5D3users (USERNAME, PASSWORD, FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, CONTACT_NUMBER) values (?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, username, password, firstName, middleName, lastName, email, contactNumber);
		System.out.println(username + " Successfully Registered in our System!");
		return;
	}

}