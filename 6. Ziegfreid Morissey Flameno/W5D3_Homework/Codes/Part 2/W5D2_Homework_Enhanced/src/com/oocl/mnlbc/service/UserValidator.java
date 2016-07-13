package com.oocl.mnlbc.service;
/**
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

/**
 * Class to validate user input
 * 
 * @author FLAMEZI2
 * @since 2016-07-12
 * 
 */
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class cls) {
		return User.class.isAssignableFrom(cls);
	}

	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
		User u = (User) target;

		if (u.getUsername().length() < 8) {
			errors.rejectValue("username", "tooshort.username");
		} else if (u.getUsername().length() > 20) {
			errors.rejectValue("username", "toolong.username");
		}
		if (u.getPassword().length() < 8) {
			errors.rejectValue("password", "tooshort.password");
		} else if (u.getPassword().length() > 20) {
			errors.rejectValue("password", "toolong.password");
		}
	}

	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "required.fname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "required.lname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required.phone", "Field name is required.");

		User u = (User) target;

		if (u.getFname().length() > 50) {
			errors.rejectValue("fname", "toolong.fname");
		}
		if (u.getLname().length() > 50) {
			errors.rejectValue("lname", "toolong.lname");
		}

		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(u.getEmail());
		
		if(!matcher.matches()){
			errors.rejectValue("email", "invalid.email");
		}
		
		if(!u.getPhone().matches("[0-9]+")){
			errors.rejectValue("phone", "invalid.phone");
		}
		
		if(!u.getFname().matches("[a-zA-Z_]+")){
			errors.rejectValue("fname", "invalid.fname");
		}
		
		if(!u.getLname().matches("[a-zA-Z_]+")){
			errors.rejectValue("lname", "invalid.lname");
		}
	}

	public void validatePage3Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Field name is required.");
	}

	@Override
	public void validate(Object target, Errors errors) {
		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
		validatePage3Form(target, errors);
	}

}
