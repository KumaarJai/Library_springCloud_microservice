package com.crystalark.librarymicroservice.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalark.librarymicroservice.user.dao.UserRepo;
import com.crystalark.librarymicroservice.user.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
	}
	
	public Optional<User> findUserById(int id) {
		return repo.findById(id);
	}
	
	public User login(String name, String password) {
		return repo.findByNameAndPassword(name, password);
	}
	
}
