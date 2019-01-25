package com.crystalark.librarymicroservice.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystalark.librarymicroservice.ConfigProperties;
import com.crystalark.librarymicroservice.user.model.LoginBean;
import com.crystalark.librarymicroservice.user.model.User;
import com.crystalark.librarymicroservice.user.service.UserService;

@RestController
@RequestMapping(path="/user-service")
public class UserController {

	@Autowired
	private ConfigProperties prop;
	
	@Autowired
	UserService service;

	@GetMapping("/env")
	public ResponseEntity<String> getEnvironment() {
		System.out.println("Fetching env for user service");
		return new ResponseEntity<String>(prop.getEnv(), HttpStatus.OK);
	}

	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		System.out.println("Fetching hello for user service");
		return new ResponseEntity<String>("Hello User Service", HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("Fetching all users");
		return new ResponseEntity<List<User>>(service.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginBean user) {
		System.out.println(user.getName()+ " - Initiating login procedure...");
		return new ResponseEntity<User>(service.login(user), HttpStatus.OK);
	}
	
	@PostMapping("/profile/{id}")
	public ResponseEntity<Optional<User>> getUserProfile(@PathVariable int id) {
		return new ResponseEntity<Optional<User>>(service.findUserById(id), HttpStatus.OK);
	}
	
	

}
