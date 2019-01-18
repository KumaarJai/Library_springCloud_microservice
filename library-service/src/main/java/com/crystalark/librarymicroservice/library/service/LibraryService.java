package com.crystalark.librarymicroservice.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalark.librarymicroservice.library.model.BookServiceBean;
import com.crystalark.librarymicroservice.library.model.UserServiceBean;

@Service
public class LibraryService {
	
	@Autowired
	BookServiceProxy bookProxy;
	
	@Autowired
	UserServiceProxy userProxy;
	
	public List<BookServiceBean> getAllBooksFromBookApiUsingFiegn(){
		System.out.println("LibraryService: Inside getAllBooksFromBookApiUsingFiegn... calling book api");
		return bookProxy.getAllBooks();
	}
	
	public List<UserServiceBean> getAllUsersFromUserApiUsingFiegn(){
		System.out.println("LibraryService: Inside getAllUsersFromUserApiUsingFiegn... calling user api");
		return userProxy.getAllUsers();
	}
}
