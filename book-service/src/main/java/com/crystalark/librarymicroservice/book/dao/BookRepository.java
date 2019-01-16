package com.crystalark.librarymicroservice.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crystalark.librarymicroservice.book.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findByName(String name);

	public List<Book> findByAuthor(String author);
	
	public Book findPriceByNameAndAuthor(String name, String author);
	
	@Query("select u.price from Book u where u.name = :name and u.author = :author")
	public double findPriceOfBookByNameAndAuthor(@Param("name") String name, @Param("author") String author);
	
}
