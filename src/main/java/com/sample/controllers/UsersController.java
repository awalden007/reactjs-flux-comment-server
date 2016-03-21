package com.sample.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.users.User;
import com.sample.users.UsersUtil;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser() {
		return UsersUtil.getUser();
	}
	
}
