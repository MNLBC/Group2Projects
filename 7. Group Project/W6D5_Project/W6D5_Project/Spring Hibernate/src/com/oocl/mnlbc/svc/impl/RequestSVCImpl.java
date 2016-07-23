package com.oocl.mnlbc.svc.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.RequestDAO;
import com.oocl.mnlbc.dao.inf.UserDAO;
import com.oocl.mnlbc.model.Request;
import com.oocl.mnlbc.svc.inf.RequestSVC;
import com.oocl.mnlbc.util.Timestamp;


/**
 * @author SOQUIDA
 * @since 2016-07-22
 */

public class RequestSVCImpl implements RequestSVC {
	
	private RequestDAO requestDAO;
	public void setRequestDAO(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}
	
	@Override
	@Transactional
	public int createRequest(String useremail){
		Request request = new Request();
		request.setUserEmail(useremail);
		request.setUserDate(Timestamp.getTimestamp());
		request.setRequestStatus("PENDING");
		return this.requestDAO.createRequest(request);
	}
	
	@Override
	@Transactional
	public Request getRequestByUserEmail(String useremail){
		return this.requestDAO.getRequestByUserEmail(useremail);
		
	}
	@Override
	@Transactional
	public List<Request> getAllRequest(){
		return this.requestDAO.getAllRequest();
		
	}
	@Override
	@Transactional
	public int updateRequest(Request request){
		return this.requestDAO.updateRequest(request);
		
	}

}
