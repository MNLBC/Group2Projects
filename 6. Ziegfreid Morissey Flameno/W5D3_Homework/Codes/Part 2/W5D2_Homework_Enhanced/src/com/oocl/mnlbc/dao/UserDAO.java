package com.oocl.mnlbc.dao;

import java.util.List;
import javax.sql.DataSource;

import com.oocl.mnlbc.model.User;

/**
 * User DAO Interface
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public interface UserDAO {

	public void setDataSource(DataSource ds);

	public void create(User user);

	public List<User> listUsers();
}