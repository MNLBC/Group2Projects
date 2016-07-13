package com.oocl.mnlbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.oocl.mnlbc.impl.UserDAOImpl;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.service.AddUserSvc;

@SuppressWarnings("deprecation")
public class AddUserController extends AbstractWizardFormController {

	private AddUserSvc userSvc = new AddUserSvc();

	public AddUserController() {
		setCommandClass(User.class);
		setCommandName("user");
	}

	protected void validatePage(Object command, Errors errors, int page) {

		User user = (User) command;

		switch (page) {

		case 0:

			if (userSvc.fieldEmpty(user.getName())) {
				errors.rejectValue("name", "name.required");
			}
			if (userSvc.fieldEmpty(user.getUsername())) {
				errors.rejectValue("username", "username.required");
			}

			break;

		case 1:

			if (userSvc.fieldEmpty(user.getPassword())) {
				errors.rejectValue("password", "password.required");
			}
			if (!(user.getRpassword().equals(user.getPassword()))) {
				errors.rejectValue("rpassword", "rpassword.required");
			}
			if (userSvc.fieldEmpty(user.getDob())) {
				errors.rejectValue("dob", "dob.required");
			}
			break;

		case 2:

			if (userSvc.fieldEmpty(user.getMobile())) {
				errors.rejectValue("mobile", "mobile.required");
			}
			if (userSvc.fieldEmpty(user.getEmail())) {
				errors.rejectValue("email", "email.required");
			}
			break;
		}
	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		User user = (User) command;
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		UserDAOImpl userDBTemplate = (UserDAOImpl) context.getBean("userTemplate");
		
		userDBTemplate.insertUser(user);
		
		

		ModelAndView mav = new ModelAndView("UserAddedSuccess", "user", user);

		return mav;
	}
}
