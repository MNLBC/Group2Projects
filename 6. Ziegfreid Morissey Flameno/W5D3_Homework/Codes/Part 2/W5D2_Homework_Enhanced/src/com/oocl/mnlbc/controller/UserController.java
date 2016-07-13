/**
 * 
 */
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
import com.oocl.mnlbc.service.UserValidator;
import com.oocl.mnlbc.template.UserJDBCTemplate;

/**
 * User Controller
 * 
 * @author FLAMEZI2
 * @since 2016-07-12
 * 
 */

@SuppressWarnings("deprecation")
public class UserController extends AbstractWizardFormController {

	public UserController() {
		setCommandName("userForm");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {

		return new User();
	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		User user = (User) command;
		System.out.println(user);

		ApplicationContext context = new ClassPathXmlApplicationContext("com/oocl/mnlbc/bean/beans.xml");

		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");

		System.out.println("------Records Creation--------");
		userJDBCTemplate.create(user);
		return new ModelAndView("ResultForm", "user", user);
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		return new ModelAndView("WelcomePage");
	}

	@Override
	protected void validatePage(Object command, Errors errors, int page) {

		UserValidator validator = (UserValidator) getValidator();

		switch (page) {
		case 0:
			validator.validatePage1Form(command, errors);
			break;
		case 1:
			validator.validatePage2Form(command, errors);
			break;
		case 2:
			validator.validatePage3Form(command, errors);
			break;
		}
	}
}
