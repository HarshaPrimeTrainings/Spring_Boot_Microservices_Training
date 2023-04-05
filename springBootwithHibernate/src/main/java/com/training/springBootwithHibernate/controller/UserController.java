package com.training.springBootwithHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springBootwithHibernate.dao.MyUsers;
import com.training.springBootwithHibernate.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService serv;

	@PostMapping("/save")
	public String saveuser(@RequestBody MyUsers u) {
		return serv.saveUser(u);
	}
	
	@GetMapping("/user/{id}")
	public MyUsers getUser(@PathVariable Integer id) {
		return serv.getUser(id);
	}
	
	
}
