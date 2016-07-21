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
	
	@RequestMapping("/visitorCount")
	public @ResponseBody int getVisitorCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int count = 0;
		HttpSession session = request.getSession();

		count = (int) session.getServletContext().getAttribute("ctr");
		return count;

	}
	
	@RequestMapping("/onlineUserCount")
	public @ResponseBody int getOnlineUserCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int count = 0;
		HttpSession session = request.getSession();

		count = (int) session.getServletContext().getAttribute("online");
		return count;

	}

}
