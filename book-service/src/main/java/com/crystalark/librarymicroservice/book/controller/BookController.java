package com.crystalark.librarymicroservice.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystalark.librarymicroservice.ConfigProperties;

@RestController
public class BookController {
	
	@Autowired
	private ConfigProperties prop;
	
	@GetMapping("/env")
	public ResponseEntity<String> getEnvironment(){
		System.out.println("Fetching env for book service");
		return new ResponseEntity<String>(prop.getEnv(), HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> getHello(){
		System.out.println("Fetching hello for book service");
		return new ResponseEntity<String>("Hello Book Service", HttpStatus.OK);
	}
}
