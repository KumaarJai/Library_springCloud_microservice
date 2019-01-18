package com.crystalark.librarymicroservice.library.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.crystalark.librarymicroservice.library.model.UserServiceBean;

@FeignClient(name = "user-service", url = "localhost:8100")
public interface UserServiceProxy {
	@GetMapping("/user-service/users")
	public List<UserServiceBean> getAllUsers();
}
