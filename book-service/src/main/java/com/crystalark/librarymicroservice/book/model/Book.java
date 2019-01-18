package com.crystalark.librarymicroservice.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue
	@Column	private int id;
	@Column	private String name;
	@Column private String author;
	@Column private String description;
	@Column private double price;
	@Column private int heldBy;


	public Book() {
		super();
	}

	public Book(String name, String author, String description, double price) {
		super();
		this.name = name;
		this.author = author;
		this.description = description;
		this.price = price;
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
	
	public int getHeldBy() {
		return heldBy;
	}

	public void setHeldBy(int heldBy) {
		this.heldBy = heldBy;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
