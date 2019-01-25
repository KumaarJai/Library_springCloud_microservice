package com.crystalark.librarymicroservice.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystalark.librarymicroservice.ConfigProperties;
import com.crystalark.librarymicroservice.library.model.BookServiceBean;
import com.crystalark.librarymicroservice.library.model.LoginInputBean;
import com.crystalark.librarymicroservice.library.model.UserServiceBean;
import com.crystalark.librarymicroservice.library.service.LibraryService;

@RestController
@RequestMapping(path="/lib-service")
public class LibraryController {

	@Autowired
	ConfigProperties prop;
	
	@Autowired
	LibraryService service;
	
	@GetMapping("/env")
	public ResponseEntity<String> getEnvironment() {
		System.out.println("Fetching env for library service");
		return new ResponseEntity<String>(prop.getEnv(), HttpStatus.OK);
	}

	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		System.out.println("Fetching hello for library service");
		return new ResponseEntity<String>("Hello library Service", HttpStatus.OK);
	}
	
	
	@GetMapping("/books")
	public ResponseEntity<List<BookServiceBean>> getAllBooksFromBookApi() {
		System.out.println("We are in LibraryController : Fetching all books from Book API");
		ResponseEntity<List<BookServiceBean>> books = new ResponseEntity<>(service.getAllBooksFromBookApiUsingFiegn(), HttpStatus.OK);
		return books;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserServiceBean>> getAllUsersFromUserApi() {
		System.out.println("We are in LibraryController : Fetching all users from User API");
		ResponseEntity<List<UserServiceBean>> users = new ResponseEntity<>(service.getAllUsersFromUserApiUsingFiegn(), HttpStatus.OK);
		return users;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserServiceBean> login(@RequestBody LoginInputBean user) {
		System.out.println("We are in LibraryController : User -" + user.getName()+ " -> Initiating login procedure...");
		return new ResponseEntity<UserServiceBean>(service.loginUserUsingFiegn(user), HttpStatus.OK);
	}
	
	
}
