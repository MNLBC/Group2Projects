package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.User;

/**
 * User Mapper (used for list)
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUserFname(rs.getString("fname"));
		user.setUserLname(rs.getString("lname"));
		user.setUserEmail(rs.getString("email"));
		user.setRemarks(rs.getString("remarks"));
		user.setUserName(rs.getString("username"));
		user.setUserPassword(rs.getString("password"));
		user.setUserAddress(rs.getString("address"));

		return user;
	}
}