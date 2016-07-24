/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.Request;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.svc.inf.RequestSVC;

/**
 * @author SOQUIDA
 * @since 2016-07-22
 *
 * Methods to handle webservice request for User Requests 
 *
 */

@RestController
@ResponseBody
public class RequestController {

	private RequestSVC requestSVC;

	@Autowired(required = true)
	@Qualifier(value = "requestService")
	public void setRequestService(RequestSVC requestSVC) {
		this.requestSVC = requestSVC;
	}
		/**
	    * addRequest web service
	    * adds a user request
	    * 
	    * @return boolean
	    * 
	    */
	@RequestMapping(value = "/addRequest", method = RequestMethod.POST)
	public boolean createRequest(@RequestParam("email") String useremail) {
		int result = this.requestSVC.createRequest(useremail);

		if (useremail != null) {
			if (result != 1 || result == 0)
				return false;
			return true;
		}
		return false;

	}
	
		/**
	    * getRequestByUserEmail web service
	    * gets the latest request of any email parameter requested 
	    * 
	    * @return Request Object
	    */

	@RequestMapping(value = "/getRequestByUserEmail", method = RequestMethod.GET)
	public Request getRequestByUserEmail(@RequestParam("email") String useremail) {
		if (!useremail.isEmpty()) {
			return this.requestSVC.getRequestByUserEmail(useremail);
		}
		return null;
	}
	
	
	/**
	    * updateRequest web service
	    * updates the any pending request
	    * 
	    * @return boolean
	    */
	
	@RequestMapping(value = "/updateRequest", method = RequestMethod.POST)
	public boolean updateRequest(@RequestParam("id") String id, @RequestParam("email") String email, @RequestParam("date") 
	String date, @RequestParam("status") String status) {
		long reqId = Long.parseLong(id);
		Request request = new Request();
		request.setRequestId(reqId);
		request.setUserEmail(email);
		request.setUserDate(date);
		request.setRequestStatus(status);
		int result = this.requestSVC.updateRequest(request);
		if (result != 1 || result == 0) {
			return false;
		} else {
			return true;
		}

	}
	
	/**
	    * getAllRequest web service
	    * gets All data from Request table
	    * 
	    * @return Request Object
	    */
	@RequestMapping(value = "/getAllRequest", method = RequestMethod.GET)
	public List<Request> getAllRequest() {
		return this.requestSVC.getAllRequest();
	}
}
