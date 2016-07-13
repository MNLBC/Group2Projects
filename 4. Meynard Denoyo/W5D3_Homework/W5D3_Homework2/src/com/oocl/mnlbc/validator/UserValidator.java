package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}

	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "required.fname", "Field name is required.");
	}

	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "required.lname", "Field name is required.");
	}

	public void validatePage3Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uname", "required.uname", "Field name is required.");
	}

	public void validatePage4Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pword", "required.pword", "Field name is required.");
	}

	@Override
	public void validate(Object target, Errors errors) {
		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
		validatePage3Form(target, errors);
		validatePage4Form(target, errors);
	}
}
