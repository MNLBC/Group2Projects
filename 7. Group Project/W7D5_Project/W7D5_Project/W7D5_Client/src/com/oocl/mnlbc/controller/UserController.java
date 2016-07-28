package com.oocl.mnlbc.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.UserSVC;
import com.oocl.mnlbc.util.PasswordHash;

/**
 * Handles web services for User
 * 
 * @author DENOYME
 * @date 2016-07-21
 */
@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	private UserSVC userSVC;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserSVC us) {
		this.userSVC = us;
	}

	/**
	 * getAllUsers web service
	 * 
	 * @return List<User>
	 */
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return this.userSVC.getAllUsers();
	}

	/**
	 * getUserByEmail web service
	 * 
	 * @param email
	 * @return List<User>
	 */
	@RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
	public List<User> getUserByEmail(@RequestParam String email) {
		if (!email.isEmpty()) {
			return this.userSVC.getUserByEmail(email);
		}
		return null;
	}

	@RequestMapping(value = "/getPassByEmail", method = RequestMethod.POST)
	public String getPassByEmail(@RequestParam String email) {
		if (!email.isEmpty()) {
			return this.userSVC.getUserPass(email);
		}
		return null;
	}

	/**
	 * updateUser web service
	 * 
	 * @param user
	 * @return boolean
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) {
		String hashedpass = "";
		try {
			hashedpass = PasswordHash.createHash(user.getUserPass());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			logger.error(e.getMessage());
		}
		user.setUserPass(hashedpass);
		int result = this.userSVC.updateUser(user);
		if (user != null) {
			if (result != 1 || result == 0)
				return false;
			return true;
		}
		return false;
	}

	/**
	 * updateUserByAdmin web service
	 * 
	 * @param user
	 * @return boolean
	 */
	@RequestMapping(value = "/updateUserByAdmin", method = RequestMethod.POST)
	public boolean updateUserByAdmin(@RequestBody User user) {
		int result = this.userSVC.updateUserByAdmin(user);
		if (user != null) {
			if (result != 1 || result == 0)
				return false;
			return true;
		}
		return false;
	}

	/**
	 * deleteUser web service
	 * 
	 * @param id
	 * @return boolean
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public boolean deleteUser(@RequestParam long id) {
		int result = this.userSVC.deleteUser(id);
		if (id >= 0) {
			if (result != 1 || result == 0)
				return false;
			return true;
		}
		return false;
	}

	/**
	 * updateToPremium web service
	 * 
	 * @param email
	 * @return boolean
	 */
	@RequestMapping(value = "/updateToPremium", method = RequestMethod.POST)
	public boolean updateToPremium(@RequestParam String email) {
		int result = this.userSVC.updateToPremium(email);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/deleteUserByEmail", method = RequestMethod.POST)
	public boolean deleteUserByEmail(@RequestParam("email") String useremail) {
		int result = this.userSVC.deleteUserByEmail(useremail);

		if (!useremail.isEmpty()) {
			if (result != 1 || result == 0)
				return false;
			return true;
		}
		return false;
	}
}
