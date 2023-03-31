package com.training.userservice.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.controllers.model.User;
import com.training.userservice.services.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	UserService usrServ;
	
	List<User> ul = new ArrayList<User>();
	
	public  UserController() {
		ul.add(new User(1,"JoeTribiany","NY","12345679"));
		ul.add(new User(2,"Chandler","Ohio","1234556"));
		ul.add(new User(3,"Monica","Texas","12345679"));
		ul.add(new User(4,"Rachel","IL","12345679"));
		ul.add(new User(5,"Ross","WDC","12345679"));
		ul.add(new User(6,"Pheebe","Macnhents","12345679"));
	}


	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(ul, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUser(@PathVariable int id) {
		
		return new ResponseEntity<User>(usrServ.findUser(id,ul), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> FIndUseByName(@RequestParam String username) {
		return new ResponseEntity<User>(usrServ.FindUserByName(username, ul), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		ul.add(u);
		return new ResponseEntity<User>(usrServ.findUser(u.getUid(),ul), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User u) {
		return new ResponseEntity<User>(usrServ.updateUser(id, u, ul),HttpStatus.CREATED);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteuser(@PathVariable int id) {
		User existingUser = usrServ.findUser(id, ul);
		ul.remove(existingUser);
		return new ResponseEntity<String>("User Deleted with id  :: "+ id, HttpStatus.OK);
		
	}
	
	
}
