package com.oocl.mnlbc.dao.inf;

import java.util.List;

/**
 * @author SOQUIDA
 * @since 2016-07-22
 */

import com.oocl.mnlbc.model.Request;

public interface RequestDAO {
	
	public int createRequest(Request request);
	public List<Request> getRequestByUserEmail(String useremail);
	List<Request> getAllRequest();
	public int updateRequest(Request request);

}
