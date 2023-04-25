package com.training.orderserivice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderserivice.dao.Orders;
import com.training.orderserivice.dao.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;

	@GetMapping("/greet")
	public String greet() {
		return "Hello From OrderService";
	}
	
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return service.getAllOrders();
	}

	@GetMapping("/order/{oid}")
	public Orders getOrder(@PathVariable int oid) {
		return service.getOrder(oid);
	}

	@GetMapping("/orders/{uid}")
	public List<Orders> getOrdersByUid(@PathVariable int uid){
		return service.getOrdersByUserId(uid);
	}
	
	@PostMapping("/order/save")
	public Orders saveOrder(@RequestBody Orders o) {
		return service.saveOrder(o);
	}

	@PutMapping("/order/update/{oid}")
	public Orders updateOrder(@PathVariable int oid, @RequestBody Orders o) {
		return service.updateOrder(oid, o);
	}

	@DeleteMapping("/order/delete/{oid}")
	public String deleteOrder(@PathVariable int oid) {
		return service.deleteOrder(oid);
	}

}
