package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.OnlineUser;

public interface OnlineUserDAO {

   public int addOnlineUser(OnlineUser onluser);

   public List<OnlineUser> getAllOnlineUser();

   public int deleteOnlineUser(String email);
}
