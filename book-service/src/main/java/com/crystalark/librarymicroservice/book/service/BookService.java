package com.crystalark.librarymicroservice.book.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalark.librarymicroservice.book.dao.BookRepository;
import com.crystalark.librarymicroservice.book.model.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	@Transactional
	public List<Book> getAllBooks(){
		return (List<Book>) repo.findAll();
	}
	
	@Transactional
	public Book getBookByName(String name) {
		return repo.findByName(name);
	}
	
	@Transactional
	public Optional<Book> getBookById(int id) {
		return repo.findById(id);
	}
	
	@Transactional
	public List<Book> getBookByAuthor(String author) {
		return repo.findByAuthor(author);
	}
	
	@Transactional
	public Book getPriceByNameOrAuthor(String name, String author) {
		return repo.findPriceByNameAndAuthor(name, author);
	}
	
	@Transactional
	public double getPriceOfBookByNameAndAuthor(String name, String author) {
		return repo.findPriceOfBookByNameAndAuthor(name, author);
	}

	@Transactional
	public Book addBook(Book book) {
		return repo.save(book);
	}
	
	
	
	
	
	
}
