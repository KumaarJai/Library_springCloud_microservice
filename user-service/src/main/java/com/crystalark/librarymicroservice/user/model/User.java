package com.crystalark.librarymicroservice.user.model;

public class User {
	private int id;
	private String name;
	private String address;
	private String contact;
	private int booksOnHold;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getBooksOnHold() {
		return booksOnHold;
	}
	public void setBooksOnHold(int booksOnHold) {
		this.booksOnHold = booksOnHold;
	}
	
	
}
