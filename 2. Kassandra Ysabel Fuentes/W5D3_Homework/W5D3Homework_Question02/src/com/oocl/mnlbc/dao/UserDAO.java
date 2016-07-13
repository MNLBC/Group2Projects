package com.oocl.mnlbc.dao;

import java.util.List;
import javax.sql.DataSource;

import com.oocl.mnlbc.model.User;

public interface UserDAO {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the User table.
    */
   public void create(User user);
   /** 
    * This is the method to be used to list down
    * a record from the User table corresponding
    * to a passed User id.
    */

   public List<User> listUsers();
   /** 
    * This is the method to be used to delete
    * a record from the User table corresponding
    * to a passed User id.
    */
   public void delete(Integer id);

}