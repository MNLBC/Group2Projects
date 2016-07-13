package com.oocl.mnlbc.DAO;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String fname, String lname, String uname, String pword) {
		String SQL = "insert into Users (fname, lname, uname, pword) values (?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, fname, lname, uname, pword);
		System.out.println("Created Record Firstname = " + fname + " Lastname = " + lname + " Username = " + uname
				+ " Password = " + pword);
		return;
	}
}
