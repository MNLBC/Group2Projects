package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ProductSVC;
import com.oocl.mnlbc.dao.UserSVC;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.model.User;

@Controller
public class UserController {

	private UserSVC userSVC;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserSVC us) {
		this.userSVC = us;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam String email, @RequestParam String password) {
		return this.userSVC.getUser(email, password);
	}

	@RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserByEmail(@RequestParam String email) {
		return this.userSVC.getUserByEmail(email);
	}

	@RequestMapping(value = "/getBlacklist", method = RequestMethod.GET)
	public @ResponseBody List<User> getBlackList() {
		return this.userSVC.getBlackList();
	}

	@RequestMapping(value = "/validateUser", method = RequestMethod.GET)
	public @ResponseBody boolean validateUser(@RequestParam String email) {
		return this.userSVC.validateUser(email);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody int createUser(@RequestBody User user) {
		return this.userSVC.createUser(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody int updateUser(@RequestBody User user) {
		return this.userSVC.updateUser(user);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody int deleteUser(@RequestParam long id) {
		return this.userSVC.deleteUser(id);
	}

}
