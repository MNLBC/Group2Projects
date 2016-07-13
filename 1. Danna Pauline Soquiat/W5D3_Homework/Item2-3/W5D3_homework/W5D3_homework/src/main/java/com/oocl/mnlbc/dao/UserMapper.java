package com.oocl.mnlbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.User;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setConfirmPassword(rs.getString("confirmPassword"));
		user.setFirstName(rs.getString("firstName"));
		user.setMiddleName(rs.getString("middleName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmail(rs.getString("email"));
		user.setContactNumber(rs.getString("contactNumber"));

		String userName;
		String password;
		String confirmPassword;
		String remark;
		String firstName;
		String middleName;
		String lastName;
		String email;
		String contactNumber;

		return user;
	}
}
