package com.training.orderserivice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer>{
	
	public List<Orders> findByuserId(Integer userId);

}
