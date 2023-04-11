package com.training.userservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.userservice.controllers.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
