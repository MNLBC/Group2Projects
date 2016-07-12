package com.oocl.mnlbc.service;
/**
 * 
 */

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
		// just validate the User instances
		return User.class.isAssignableFrom(cls);
	}

	// validate page 1, userName
	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
	}

	// validate page 2, password
	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "required.fname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "required.lname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required.phone", "Field name is required.");
	}

	// validate page 3, remark
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
