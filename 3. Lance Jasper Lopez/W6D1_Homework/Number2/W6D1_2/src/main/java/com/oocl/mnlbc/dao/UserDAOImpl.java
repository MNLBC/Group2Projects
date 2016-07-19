package com.oocl.mnlbc.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import com.oocl.mnlbc.model.User;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

	public long countAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User create(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	public User find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public User loadUser(String id) {
		Query query = this.em.createQuery("select u FROM Users u where u.user_id= :user_id");
		query.setParameter("user_id", id);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;

	}

}
