package com.training.orderserivice.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.orderserivice.dao.Orders;
import com.training.orderserivice.dao.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	
	public List<Orders> getAllOrders(){
		return (List<Orders>) repo.findAll();
	}
	
	public Orders getOrder(int oid) {
		return repo.findById(oid).orElseThrow(()-> new RuntimeException(" No order placed with "+ oid));
	}
	
	public List<Orders> getOrdersByUserId(int uid){
		return repo.findByuserId(uid);
	}
	
	public Orders saveOrder(Orders o) {
		return repo.save(o);
	}
	
	public Orders updateOrder(int oid, Orders o) {
		Orders existingOrder = repo.findById(oid)
				.orElseThrow(()-> new RuntimeException(" No order placed with "+ oid));
		
		if(o.getOrderName()!=null)
			existingOrder.setOrderName(o.getOrderName());
		if(o.getOrderStatus()!=null)
			existingOrder.setOrderStatus(o.getOrderStatus());
		return repo.save(existingOrder);
	}
	
	public String deleteOrder(int oid) {
		repo.deleteById(repo.findById(oid)
		.orElseThrow(()-> new RuntimeException(" No order placed with "+ oid)).getOrderId());
		return "Order Deleted";
		
	}
}
