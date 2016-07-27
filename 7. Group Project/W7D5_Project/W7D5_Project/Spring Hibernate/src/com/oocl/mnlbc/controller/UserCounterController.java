package com.oocl.mnlbc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SOQUIDA
 * @since 2016-07-21
 */

@Controller
public class UserCounterController extends HttpServlet {
	
	/**
	    * visitorCount web service
	    * counts session as 1 user
	    * 
	    * @return count
	    */
	
	@RequestMapping("/visitorCount")
	public @ResponseBody int getVisitorCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int count = 1;
		HttpSession session = request.getSession();
		if(session.getServletContext().getAttribute("ctr")!=null){
		   count = (int) session.getServletContext().getAttribute("ctr");
		}
		return count;

	}
	

}
