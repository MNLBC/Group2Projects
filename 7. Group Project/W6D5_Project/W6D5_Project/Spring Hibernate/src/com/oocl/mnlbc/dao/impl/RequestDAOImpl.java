package com.oocl.mnlbc.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.RequestDAO;
import com.oocl.mnlbc.model.Request;
import com.oocl.mnlbc.model.User;


/**
 * @author SOQUIDA
 * @since 2016-07-22
 */

@Repository
@Transactional
public class RequestDAOImpl implements RequestDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestDAOImpl.class);
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Request> getAllRequest() {
		String sql = "SELECT request FROM Request request"
		   + " WHERE request.requestStatus='PENDING'";
		List<Request> allRequestList = manager.createQuery(sql).getResultList();
		for (Request allRequest : allRequestList) {
			logger.info("Request List:" + allRequest);
		}
		return allRequestList;
	}
	
	@Override
	public int createRequest(Request request) {
		manager.persist(request);
		logger.info("Request saved successfully! User Details=" + request);
		return 1;
	}

	@Override
	public Request getRequestByUserEmail(String useremail) {
		Request requestUserEmail = new Request();
		String query = "SELECT * FROM REQUESTS WHERE USEREMAIL ='"+ useremail + "'AND REQID IN (SELECT MAX(REQID) FROM REQUESTS WHERE USEREMAIL = '"+useremail +"')";
//		userRequestList = manager.createNativeQuery(query, Request.class).getResultList();
//		for (Request userReq : userRequestList) {
//			logger.info("User Request" + userReq);
//		}
		List<Object[]> userRequests = manager.createNativeQuery(query).getResultList();
		for(int i= 0; i < userRequests.size(); i++){
			BigDecimal d = (BigDecimal) userRequests.get(i)[0];
			requestUserEmail.setRequestId(d.longValue());
			requestUserEmail.setUserEmail((String)userRequests.get(i)[1]);
			requestUserEmail.setUserDate((String)userRequests.get(i)[2]);
			requestUserEmail.setRequestStatus((String) userRequests.get(i)[3]);
		}
		return requestUserEmail;
	}

	@Override
	public int updateRequest(Request request) {
		Request updateRequest = manager.find(Request.class, request.getRequestId());
		updateRequest.setRequestId(request.getRequestId());
		updateRequest.setUserEmail(request.getUserEmail());
		updateRequest.setUserDate(request.getUserDate());
		updateRequest.setRequestStatus(request.getRequestStatus());
		logger.info("Request updated successfully!=" + updateRequest);
		return 1;
	}
	
	
	
}
