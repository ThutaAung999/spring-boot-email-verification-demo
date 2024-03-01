package com.tta.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.model.entity.User;
import com.tta.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserContrller {

	private final UserService userService;
	
	
	@GetMapping
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
}
