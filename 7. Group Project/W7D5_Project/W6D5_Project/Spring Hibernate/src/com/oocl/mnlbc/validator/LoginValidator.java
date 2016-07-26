
package com.oocl.mnlbc.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

/**
 * @author Kassandra Ysabel Fuentes
 * @since 07/20/2016
 *
 */
@Component
public class LoginValidator implements Validator {

	private static final String SIMPLE_EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
	private static final String SIMPLE_ADDRESS_REGEX = "[a-zA-Z0-9.-]+";

	@Override
	public boolean supports(Class userClass) {
		return User.class.isAssignableFrom(userClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User userCheck = (User) target;
		String password = userCheck.getUserPass();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "error.email.empty",
				"Enter an email address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPass", "error.password.empty", "Enter a password");

		if (StringUtils.hasText(userCheck.getUserEmail())
				&& !Pattern.matches(SIMPLE_EMAIL_REGEX, userCheck.getUserEmail().toUpperCase())) {
			errors.rejectValue("userEmail", "error.email.invalid", "Email address entered is invalid");
		}
		if (password.length() < 8) {
			errors.rejectValue("userPass", "error.pass.invalid", "Password must be at least 8 characters.");
		}
	
	}

}
