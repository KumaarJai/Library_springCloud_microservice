package com.crystalark.librarymicroservice.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalark.librarymicroservice.user.dao.UserRepo;
import com.crystalark.librarymicroservice.user.model.LoginBean;
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
	
	public User login(LoginBean user) {
		User loggedInUser = repo.findByNameAndPassword(user.getName(), user.getPassword());
		if(loggedInUser != null && loggedInUser.getId()>0 && loggedInUser.getName() !=null)
			loggedInUser.setAuthorized(true);
		return loggedInUser;
		
	}
	
}
