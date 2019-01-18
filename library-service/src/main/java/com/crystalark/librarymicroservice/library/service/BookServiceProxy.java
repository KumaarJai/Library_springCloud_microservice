package com.crystalark.librarymicroservice.library.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.crystalark.librarymicroservice.library.model.BookServiceBean;

@FeignClient(name="book-service", url="localhost:8200")
public interface BookServiceProxy {
	@GetMapping("/book-service/books")
	public List<BookServiceBean> getAllBooks();
}
