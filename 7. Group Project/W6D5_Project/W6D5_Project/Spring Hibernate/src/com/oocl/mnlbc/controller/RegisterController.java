package com.oocl.mnlbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.UserSVC;
import com.oocl.mnlbc.validator.RegisterValidator;

/**
 * Handles web services for Register
 * 
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
@ResponseBody
public class RegisterController {

	private UserSVC userSVC;
	@Autowired
	private RegisterValidator registerValidator;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserSVC userSVC) {
		this.userSVC = userSVC;
	}

	/**
	 * Bind Validator for Register
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators(registerValidator);
	}

	/**
	 * Register web service
	 * 
	 * @param User
	 * @return boolean
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Response createUser(@Validated(RegisterValidator.class) @RequestBody User user, BindingResult result) {
		Response response = new Response();

		if (!result.hasErrors()) {
			int save = userSVC.createUser(user);
			if (user != null) {
				if (save == 1) {
					response.setResponseCode(0);
				} else {
					response.setResponseCode(1);
				}
			} else {
				response.setResponseCode(2);
			}
		} else {
			response.setResponseCode(999);
			response.setErrors(result.getAllErrors());
		}
		return response;
	}
}
