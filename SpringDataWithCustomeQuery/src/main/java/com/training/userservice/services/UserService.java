package com.training.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.userservice.controllers.model.User;
import com.training.userservice.dao.UserRepository;
import com.training.userservice.exceptions.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}

	public User findUserById(int id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("No USer Present with id :" + id));
	}
	
	public User findUserByName(String uname) {
		return userRepo.findByuname(uname);
	}
	
	public List<User> findUserByAdress(String addr) {
		return userRepo.getByaddress(addr);
	}

	public User getNewYorkuser(String addr) {
		return userRepo.getNYUser(addr);
		
	}
	
	public User updateUser(int id, User u) {
		User existingUser = userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No USer Present with id :" + id));
		if (u.getUname() != null)
			existingUser.setUname(u.getUname());
		if (u.getContact() != null)
			existingUser.setContact(u.getContact());
		if (u.getAddress() != null)
			existingUser.setAddress(u.getAddress());
		return userRepo.save(existingUser);
	}

	public String deleteUser(int id) {
		User existingUser = userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No USer Present with id :" + id));
		userRepo.deleteById(id);
		return "User Deleted ::: " + existingUser.getUname();
	}

}
