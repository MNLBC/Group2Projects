package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.interfaces.UserDao;

@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> {

    public User loadUserByUsername(String username) {
        Query query = this.em
                .createQuery("select u FROM User u where u.username= :username");
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        if (users != null && users.size() == 1) {
            return users.get(0);
        }
        return null;
    }
}
