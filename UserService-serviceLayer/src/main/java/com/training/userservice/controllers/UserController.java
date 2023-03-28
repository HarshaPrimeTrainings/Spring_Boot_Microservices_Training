package com.training.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


	@RequestMapping("/users")
	public List<User> getUsers(){
		return ul;
	}
	
	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public User findUser(@PathVariable int id) {
		return usrServ.findUser(id,ul);
	}
	
	@RequestMapping(value = "/username/{name}")
	public User FIndUseByName(@PathVariable String name) {
		return usrServ.FindUserByName(name, ul);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public User saveUser(@RequestBody User u) {
		ul.add(u);
		return usrServ.findUser(u.getUid(),ul);
	}
	
	@RequestMapping(value = "/update/{id}",method =  RequestMethod.PUT)
	public User updateUser(@PathVariable int id,@RequestBody User u) {
		return usrServ.updateUser(id, u, ul);

	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public String deleteuser(@PathVariable int id) {
		User existingUser = usrServ.findUser(id, ul);
		ul.remove(existingUser);
		return "User Deleted with id  :: "+ id;
		
	}
	
	
}
