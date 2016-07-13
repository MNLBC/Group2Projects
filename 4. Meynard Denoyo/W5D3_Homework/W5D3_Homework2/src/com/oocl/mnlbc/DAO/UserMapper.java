package com.oocl.mnlbc.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.model.User;

public class UserMapper {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setFname(rs.getString("fname"));
		user.setLname(rs.getString("lname"));
		user.setUname(rs.getString("uname"));
		user.setPword(rs.getString("pword"));
		return user;
	}
}
