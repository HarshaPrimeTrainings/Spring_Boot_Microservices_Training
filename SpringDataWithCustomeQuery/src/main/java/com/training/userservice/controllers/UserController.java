package com.training.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.controllers.model.User;
import com.training.userservice.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService usrServ;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(usrServ.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUser(@PathVariable int id) {
		return new ResponseEntity<User>(usrServ.findUserById(id), HttpStatus.OK);
	}
	
	@GetMapping("/username/{name}")
	public ResponseEntity<User> findUserName(@PathVariable String name) {
		return new ResponseEntity<User>(usrServ.findUserByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/addr/{name}")
	public ResponseEntity<List<User>> findUserByaddr(@PathVariable String name) {
		return new ResponseEntity<List<User>>(usrServ.findUserByAdress(name), HttpStatus.OK);
	}
	
	@GetMapping("/ny/{addr}")
	public ResponseEntity<User> findUserByaddrNy(@PathVariable String addr) {
		return new ResponseEntity<User>(usrServ.getNewYorkuser(addr), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		return new ResponseEntity<User>(usrServ.saveUser(u), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User u) {
		return new ResponseEntity<User>(usrServ.updateUser(id, u),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteuser(@PathVariable int id) {
		return new ResponseEntity<String>(usrServ.deleteUser(id), HttpStatus.OK);
	}
}
