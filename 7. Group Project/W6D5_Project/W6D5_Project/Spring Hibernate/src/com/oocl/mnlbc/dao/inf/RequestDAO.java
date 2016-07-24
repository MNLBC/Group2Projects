package com.oocl.mnlbc.dao.inf;

import java.util.List;

/**
 * @author SOQUIDA
 * @since 2016-07-22
 */

import com.oocl.mnlbc.model.Request;
/**
 * @author Danna Soquiat
 * @since 2016-07-22
 */
public interface RequestDAO {
	
	public int createRequest(Request request);
	public Request getRequestByUserEmail(String useremail);
	List<Request> getAllRequest();
	public int updateRequest(Request request);

}
