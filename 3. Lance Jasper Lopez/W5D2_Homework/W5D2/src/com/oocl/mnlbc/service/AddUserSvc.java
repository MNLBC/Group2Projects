package com.oocl.mnlbc.service;

public class AddUserSvc {
	public boolean fieldEmpty(String field) {
		if(field != null && !field.equals("")){
			return false;
		}
		return true;
	}
}
