package com.oocl.mnlbc.util;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.mapper.UserMapper;
import com.oocl.mnlbc.model.User;

public class UserJDBCTemplate implements UserDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void create(User user) {
      String SQL = "insert into Users (id, fname, lname, address, email, password, uname, desc) values (?, ?)";
      
      jdbcTemplateObject.update( SQL, user.getUserFname(), user.getUserLname(), user.getUserEmail(), user.getRemarks(),
				user.getUserName(), user.getUserPassword(), user.getUserAddress());
      System.out.println("Created Record Name = " + user.getUserFname() + " " + user.getUserLname());
      return;
   }

  

   public List<User> listUsers() {
      String SQL = "select * from Users";
      List <User> Users = jdbcTemplateObject.query(SQL, new UserMapper());
      return Users;
   }

}