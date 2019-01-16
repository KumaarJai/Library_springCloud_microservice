package com.crystalark.librarymicroservice.book.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crystalark.librarymicroservice.ConfigProperties;
import com.crystalark.librarymicroservice.book.model.Book;
import com.crystalark.librarymicroservice.book.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private ConfigProperties prop;
	
	@Autowired
	private BookService service;
	
	
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
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(service.getAllBooks(), HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable int id){ 
		return new ResponseEntity<Optional<Book>>(service.getBookById(id), HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<Object> addBookToLibrary(@RequestBody Book book) {
		Book savedBook = service.addBook(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping("/bookByName")
	public ResponseEntity<Book> getBookByName(@RequestBody String name) {
		System.out.println("Getting book by name : "+name);
		Book book = service.getBookByName(name);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@PostMapping("/bookByAuthor")
	public ResponseEntity<List<Book>> getBookByAuthor(@RequestBody String author) {
		return new ResponseEntity<List<Book>>(service.getBookByAuthor(author), HttpStatus.OK);
	}
	
	@PostMapping("/price1")
	public ResponseEntity<Book> getBookPrice(@RequestBody Book book) {
		return new ResponseEntity<Book>(service.getPriceByNameOrAuthor(book.getName(), book.getAuthor()), HttpStatus.OK); 
	}
	
	@PostMapping("/price2")
	public ResponseEntity<Double> getBookPrice2(@RequestBody Book book) {
		return new ResponseEntity<Double>(service.getPriceOfBookByNameAndAuthor(book.getName(), book.getAuthor()), HttpStatus.OK); 
	}
	
	
}
