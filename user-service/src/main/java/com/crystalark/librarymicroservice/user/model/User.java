package com.crystalark.librarymicroservice.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	@Column	private int id;
	@Column	private String name;
	@JsonIgnore
	@Column private String password;
	@Column	private String address;
	@Column	private String contact;
	@Column	private int booksOnHold;

	transient private boolean authorized;
	

	public User() {
		super();
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}
	
	
}
