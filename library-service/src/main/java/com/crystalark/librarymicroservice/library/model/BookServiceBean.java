package com.crystalark.librarymicroservice.library.model;

import lombok.Getter;
import lombok.Setter;

public class BookServiceBean {
	 @Getter @Setter private int id;
	 @Getter @Setter private String name;
	 @Getter @Setter private String author;
	 @Getter @Setter private String description;
	 @Getter @Setter private double price;
	 @Getter @Setter private int heldBy;
}
