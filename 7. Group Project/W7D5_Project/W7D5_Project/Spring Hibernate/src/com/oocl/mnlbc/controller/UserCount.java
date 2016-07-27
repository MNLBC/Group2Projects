package com.oocl.mnlbc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserCount extends HttpServlet {

	@RequestMapping("/userCount")
	public @ResponseBody int getUserCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int count = 0;
		HttpSession session = request.getSession();
      if(session.getServletContext().getAttribute("ctr")!=null){
         count = (int) session.getServletContext().getAttribute("ctr");
      }
		return count;

	}

}
