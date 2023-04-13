package com.training.userservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.userservice.controllers.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByuname(String uname);
	
	public List<User> getByaddress(String aaddr);
	
	
	@Query(value  =  "select * from user where address = :address",nativeQuery = true)
	public User getNYUser(@Param(value = "address") String address);

}
