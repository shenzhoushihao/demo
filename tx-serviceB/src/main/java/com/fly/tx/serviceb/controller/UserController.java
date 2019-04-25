package com.fly.tx.serviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fly.tx.serviceb.entity.UserInfo;
import com.fly.tx.serviceb.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/v9/test1")
	public UserInfo saveUserAndOrder(@RequestParam(value = "exType", defaultValue = "0") String exType) {
		return userService.saveUserAndOrder(exType);
	}

	@GetMapping(value = "/v9/test2")
	public UserInfo saveOrderAndUser(@RequestParam(value = "exType", defaultValue = "0") String exType) {
		return userService.saveOrderAndUser(exType);
	}

	@PostMapping(value = "/v0/user")
	public boolean saveUser(@RequestParam(value = "exType", defaultValue = "0") String exType) {
		return userService.saveUser(exType);
	}

}
