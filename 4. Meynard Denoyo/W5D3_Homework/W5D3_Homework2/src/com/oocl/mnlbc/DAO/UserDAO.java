package com.oocl.mnlbc.DAO;

import javax.sql.DataSource;

public interface UserDAO {

	public void setDataSource(DataSource ds);

	public void create(String fname, String lname, String uname, String pword);
}
