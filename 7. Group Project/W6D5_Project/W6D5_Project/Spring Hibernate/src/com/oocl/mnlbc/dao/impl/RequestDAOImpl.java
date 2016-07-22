package com.oocl.mnlbc.dao.impl;

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
		String sql = "SELECT request FROM Request request";
		List<Request> allRequestList = manager.createQuery(sql).getResultList();
		for (Request allRequest : allRequestList) {
			logger.info("All Request List:" + allRequest);
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
	public List<Request> getRequestByUserEmail(String useremail) {
		List<Request> userRequestList = new ArrayList<Request>();
		String query = "SELECT userReq FROM REQUEST userReq WHERE userReq.USEREMAIL =" + useremail;
		userRequestList = manager.createQuery(query, Request.class).getResultList();
		for (Request userReq : userRequestList) {
			logger.info("User Request" + userReq);
		}
		return userRequestList;
	}

	@Override
	public int updateRequest(Request request) {
		Request updateRequest = manager.find(Request.class, request.getRequestId());
		updateRequest = request;
		logger.info("Request updated successfully!=" + updateRequest);
		return 1;
	}
	
	
	
}
