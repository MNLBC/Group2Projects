package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class UserValidator implements Validator {

	public boolean supports(Class clazz) {
		// just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}

	// validate page 1, userName
	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "Username is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.confirmPassword",
				"Confirm password is required.");
		System.out.println(errors.getFieldValue("password"));
		System.out.println(errors.getFieldValue("confirmPassword"));
		if (!errors.getFieldValue("password").equals(errors.getFieldValue("confirmPassword"))) {
			errors.rejectValue("confirmPassword", null, "Password does not match");

		}

	}

	// validate page 2, password
	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName", "First Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.lastName", "Last Name is required.");
	}

	// validate page 3, remark
	public void validatePage3Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "required.contactNumber",
				"Contact Number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email is required.");
	}

	public void validate(Object target, Errors errors) {

		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
		validatePage3Form(target, errors);

	}

}