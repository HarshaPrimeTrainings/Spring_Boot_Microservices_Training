package com.training.userservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userservice.controllers.model.User;

@Service
public class UserService {

	public User findUser(int id,List<User> ul) {
		return ul.stream()
		.filter(u-> (u.getUid() == id))
		.findFirst()
		.orElseThrow(()->new RuntimeException("user Not found with id :: "+ id ));
	}
	
	public User FindUserByName( String name,List<User> ul) {
		return ul.stream()
				.filter(u-> u.getUname().equalsIgnoreCase(name))
				.findFirst()
				.orElseThrow(()->new RuntimeException("user Not found with name :: "+ name ));
	}
	
	public User updateUser( int id, User u,List<User> ul) {
		User existingUser = findUser( id, ul);
		if(u.getUname()!=null)
			existingUser.setUname(u.getUname());
		if(u.getContact()!=null)
			existingUser.setContact(u.getContact());
		if(u.getAddress()!=null)
			existingUser.setAddress(u.getAddress());
	return existingUser;
	}
	
	
}
