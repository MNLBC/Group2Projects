package com.oocl.mnlbc.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.model.User;

public class UserDAOImpl implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub

		String SQL = "insert into W5D3_USERS values (?, ?, ?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, new Object[] { user.getName(), user.getUsername(), user.getPassword(),
				user.getMobile(), user.getDob(), user.getEmail() });
		System.out.println("Created Record Name = " + user.getName() + " with email = " + user.getEmail());
		return;
	}

}
