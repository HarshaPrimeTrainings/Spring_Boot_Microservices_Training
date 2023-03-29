package com.training.userservice.controllers.model;

public class User {
	
	private int uid;
	private String uname;
	private String address;
	private String contact;
	
	public User() {
		
	}
	
	public User(int uid, String uname, String address, String contact) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.address = address;
		this.contact = contact;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	
	
	
	

}
