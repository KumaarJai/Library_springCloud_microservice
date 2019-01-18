package com.crystalark.librarymicroservice.library.model;

import lombok.Getter;
import lombok.Setter;

public class UserServiceBean {
	@Getter @Setter private int id;
	@Getter @Setter private String name;
	@Getter @Setter private String address;
	@Getter @Setter private String contact;
	@Getter @Setter private int booksOnHold;
}
