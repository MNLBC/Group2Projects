package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.UserSVC;
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;
import com.oocl.mnlbc.validator.ErrorMessage;
import com.oocl.mnlbc.validator.LoginValidator;
import com.oocl.mnlbc.validator.RegisterValidator;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc User Controller
 * @date 07-15-2016
 */
@Controller
public class UserController {

	private UserSVC userSVC;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserSVC us) {
		this.userSVC = us;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RegisterValidator());
		binder.setValidator(new LoginValidator());
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam String email, @RequestParam String password) {
		if (!email.isEmpty() && !password.isEmpty()) {
			return this.userSVC.getUser(email, password);
		}
		return null;
	}

	@RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserByEmail(@RequestParam String email) {
		if (!email.isEmpty()) {
			return this.userSVC.getUserByEmail(email);
		}
		return null;
	}

	@RequestMapping(value = "/getBlacklist", method = RequestMethod.GET)
	public @ResponseBody List<User> getBlackList() {
		return this.userSVC.getBlackList();
	}

	@RequestMapping(value = "/validateUser", method = RequestMethod.GET)
	public @ResponseBody boolean validateUser(@Validated @RequestParam String email, @RequestParam String pass) {
		if (!email.isEmpty()) {
			return this.userSVC.validateUser(email);
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody int createUser(@Validated @RequestBody User user, BindingResult binding) {
		if (!binding.hasErrors()) {
			if (user != null) {
				return this.userSVC.createUser(user);
			} else {
				LogUtil.logMsg(LogType.INFO, "Error creating user");
				return 0;
			}
		}else {
			LogUtil.logMsg(LogType.INFO, "Spring Validator Error - Error creating user");
			return 0;
		}

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody int updateUser(@RequestBody User user) {
		if (user != null) {
			return this.userSVC.updateUser(user);
		}
		return 0;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody int deleteUser(@RequestParam long id) {
		if (id > 0) {
			return this.userSVC.deleteUser(id);
		}
		return 0;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ErrorMessage handleException(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
		List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
		String error;
		for (FieldError fieldError : fieldErrors) {
			error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
			errors.add(error);
		}
		for (ObjectError objectError : globalErrors) {
			error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
			errors.add(error);
		}
		return new ErrorMessage(errors);
	}

}
