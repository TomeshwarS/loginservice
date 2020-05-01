package com.infobeans.loginservice.controller;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infobeans.loginservice.model.User;
import com.infobeans.loginservice.service.IUserService;

@RestController
@CrossOrigin("*")
public class UsersManagerController {

	@Autowired
	IUserService userServiceImpl;

	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {

		System.out.println("User >>>>>>>>>>>>>>" + user);
		ResponseEntity re = null;

		try {
			userServiceImpl.saveUser(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "User saved successfully.";
	}

	@RequestMapping("/app")
	public String hello() {

		return "This is hello message.";
	}

}
