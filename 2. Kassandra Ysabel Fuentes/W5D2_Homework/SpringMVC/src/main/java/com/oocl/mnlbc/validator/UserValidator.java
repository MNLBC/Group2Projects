package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}
	
	//validate page 1, userName
	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userFname",
				"required.userFname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLname",
				"required.userLname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail",
				"required.userEmail", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAddress",
				"required.userAddress", "Field name is required.");
	}
	
	//validate page 2, password
	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword",
				"required.userPassword", "Field name is required.");
	}
	
	//validate page 3, remark
	public void validatePage3Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remark",
				"required.remark", "Field name is required.");
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
		validatePage3Form(target, errors);
	
	}
	
}