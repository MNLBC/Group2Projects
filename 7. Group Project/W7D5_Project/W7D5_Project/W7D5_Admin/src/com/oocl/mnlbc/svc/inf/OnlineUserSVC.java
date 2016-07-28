package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.OnlineUser;

public interface OnlineUserSVC {

   public int addOnlineUser(OnlineUser onluser);

   public List<OnlineUser> getAllOnlineUser();

   public int deleteOnlineUser(String email);
}
