package com.crystalark.librarymicroservice.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.crystalark.librarymicroservice.user.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	
}
