package com.training.userservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.training.userservice.controllers.model.User;
import com.training.userservice.dao.UserRepository;
import com.training.userservice.dto.OrderDto;
import com.training.userservice.dto.UserDto;
import com.training.userservice.exceptions.UserNotFoundException;

import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RestTemplate rt;

	public String greet() {
		return rt.getForObject("http://localhost:8087/greet", String.class);
	}
	
	public UserDto getOrderByUserId(Integer uid){
		User existing = findUserById(uid);
		List<OrderDto> orders = rt.getForObject("http://localhost:8087/orders/"+uid, List.class);
		
		UserDto user = new UserDto();
		user.setUname(existing.getUname());
		user.setOrder(orders);
		return user;
	}
	
	
	
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

	public List<User> getUsersByPage(int pageno, int pageSize) {
		Pageable pagable = PageRequest.of(pageno, pageSize);
		Page<User> page = userRepo.findAll(pagable);
		return page.toList();
	}

	public List<User> getUsersByPageAndSort(String sortprop, String sorttype) {
		List<User> userList = new ArrayList<User>();
		switch (sorttype) {
		case "dsc":
			userList = (List<User>) userRepo.findAll(Sort.by(sortprop).descending());
			break;
		default:
			userList = (List<User>) userRepo.findAll(Sort.by(sortprop).ascending());
			break;
		}
		return userList;
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
