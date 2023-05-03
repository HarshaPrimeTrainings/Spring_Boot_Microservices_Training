package com.training.userservice.dto;

import java.util.List;

public class UserDto {

	private String uname;
	private List<OrderDto> order;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public List<OrderDto> getOrder() {
		return order;
	}
	public void setOrder(List<OrderDto> order) {
		this.order = order;
	}
	
	
	
}
