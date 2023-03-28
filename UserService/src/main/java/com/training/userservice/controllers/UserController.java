package com.training.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.controllers.model.User;

@RestController
public class UserController {
	List<User> ul = new ArrayList<User>();
	
	public  UserController() {
		ul.add(new User(1,"JoeTribiany","NY","12345679"));
		ul.add(new User(2,"Chandler","Ohio","1234556"));
		ul.add(new User(3,"Monica","Texas","12345679"));
		ul.add(new User(4,"Rachel","IL","12345679"));
		ul.add(new User(5,"Ross","WDC","12345679"));
		ul.add(new User(6,"Pheebe","Macnhents","12345679"));
	}

	@RequestMapping(value="/greet",method = RequestMethod.GET)
	public String greet() {
		return "Hello Iam From RestController";
	}

	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public User findUser(@PathVariable int id) {
		return ul.stream()
		.filter(u-> (u.getUid() == id))
		.findFirst()
		.orElseThrow(()->new RuntimeException("user Not found with id :: "+ id ));
		
	}
	
	@RequestMapping(value = "/username/{name}")
	public User FIndUseByName(@PathVariable String name) {
		return ul.stream()
				.filter(u-> u.getUname().equalsIgnoreCase(name))
				.findFirst()
				.orElseThrow(()->new RuntimeException("user Not found with name :: "+ name ));
	}

	@RequestMapping("/users")
	public List<User> getUsers(){
		return ul;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public User saveUser(@RequestBody User u) {
		ul.add(u);
		return ul.stream()
				.filter(usr-> usr.getUname().equalsIgnoreCase(u.getUname()))
				.findFirst()
				.orElseThrow(()->new RuntimeException("User Not Saved"));
	}
	
	
	@RequestMapping(value = "/update/{id}",method =  RequestMethod.PUT)
	public User updateUser(@PathVariable int id,@RequestBody User u) {
		User existingUser = ul.stream().filter(usr -> usr.getUid() == id)
							.findFirst()
							.orElseThrow(() -> new RuntimeException("User Not Found"));
		if(u.getUname()!=null)
			existingUser.setUname(u.getUname());
		if(u.getContact()!=null)
			existingUser.setContact(u.getContact());
		if(u.getAddress()!=null)
			existingUser.setAddress(u.getAddress());
	
		return existingUser;

	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public String deleteuser(@PathVariable int id) {
		User existingUser = ul.stream().filter(usr -> usr.getUid() == id)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		
		ul.remove(existingUser);
		
		return "User Deleted with id  :: "+ id;
		
	}
	
	
}
