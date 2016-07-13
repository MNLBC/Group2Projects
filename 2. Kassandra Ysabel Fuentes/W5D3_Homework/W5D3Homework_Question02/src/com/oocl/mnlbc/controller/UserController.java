package com.oocl.mnlbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.util.UserJDBCTemplate;
import com.oocl.mnlbc.validator.UserValidator;

/**
 * 
 * @author fuentka
 * 
 */

public class UserController extends AbstractWizardFormController{

	public UserController(){
		setCommandName("userForm");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		 ApplicationContext context = 
	             new ClassPathXmlApplicationContext("com/oocl/mnlbc/util/beans.xml");

	      UserJDBCTemplate UserJDBCTemplate = 
	      (UserJDBCTemplate)context.getBean("UserJDBCTemplate");
	      
		return new User();
		
	}
	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {ApplicationContext context = new ClassPathXmlApplicationContext("com/oocl/mnlbc/bean/beans.xml");

			User user = (User)command;
			UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");

			System.out.println("------Records Creation--------");
			userJDBCTemplate.create(user);
		
	
		
		return new ModelAndView("ResultForm", "user", user);
		
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		return new ModelAndView("WelcomePage");
	}
	
	
	@Override
	protected void validatePage(Object command, Errors errors, int page) {
		
		UserValidator validator = (UserValidator) getValidator();
		
		//page is 0-indexed
		switch (page) {
			case 0: //if page 1 , go validate with validatePage1Form
				validator.validateUserDetailsForm(command, errors);
				break;
			case 1: //if page 2 , go validate with validatePage2Form
				validator.validateAccountDetailsForm(command, errors);
				break;
			case 2: //if page 3 , go validate with validatePage3Form
				validator.validateProfileDetailsForm(command, errors);
				break;
		}
			
	}
}