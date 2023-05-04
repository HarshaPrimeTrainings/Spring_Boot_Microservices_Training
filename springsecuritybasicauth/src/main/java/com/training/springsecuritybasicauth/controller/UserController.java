package com.training.springsecuritybasicauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecuritybasicauth.dao.User;
import com.training.springsecuritybasicauth.dao.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserRepository repo;
	
	
	@PostMapping("/save")
	public User save(@RequestBody User u) {
		u.setPassword(encoder.encode(u.getPassword()));
		return repo.save(u);	
	}
}
