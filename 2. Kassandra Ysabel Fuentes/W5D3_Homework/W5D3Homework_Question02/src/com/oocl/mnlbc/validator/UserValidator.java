package com.oocl.mnlbc.validator;

/**
 * 
 * @author fuentka
 * 
 */

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
	
		return User.class.isAssignableFrom(clazz);
	}
	
	
	public void validateUserDetailsForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userFname",
				"required.userFname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLname",
				"required.userLname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail",
				"required.userEmail", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAddress",
				"required.userAddress", "Field name is required.");
	}
	
	
	public void validateAccountDetailsForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword",
				"required.userPassword", "Field name is required.");
	}
	

	public void validateProfileDetailsForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remark",
				"required.remark", "Field name is required.");
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		validateUserDetailsForm(target, errors);
		validateAccountDetailsForm(target, errors);
		validateProfileDetailsForm(target, errors);
	
	}
	
}