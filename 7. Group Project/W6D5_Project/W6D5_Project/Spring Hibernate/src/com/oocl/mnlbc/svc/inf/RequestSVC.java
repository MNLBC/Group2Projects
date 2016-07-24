package com.oocl.mnlbc.svc.inf;

import java.util.List;


/**
 * @author SOQUIDA
 * @since 2016-07-22
 */

import com.oocl.mnlbc.model.Request;
/**
 * @author Danna Soquiat
 * @since 2016-07-21
 */
public interface RequestSVC {
	
	public int createRequest(String useremail);
	public Request getRequestByUserEmail(String useremail);
	public List<Request> getAllRequest();
	public int updateRequest(Request request);

}
