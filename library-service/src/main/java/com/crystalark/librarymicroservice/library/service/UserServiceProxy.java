package com.crystalark.librarymicroservice.library.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crystalark.librarymicroservice.library.model.LoginInputBean;
import com.crystalark.librarymicroservice.library.model.UserServiceBean;

//@FeignClient(name = "user-service", url = "localhost:8100")
@FeignClient(name = "user-service")
@RibbonClient(name = "user-service")
public interface UserServiceProxy {
	@GetMapping("/user-service/users")
	public List<UserServiceBean> getAllUsers();
	
	@PostMapping("/user-service/login")
	public UserServiceBean login(@RequestBody LoginInputBean user);
	
	@PostMapping("/user-service/profile/{id}")
	public UserServiceBean getUserProfile(@PathVariable int id);
}
