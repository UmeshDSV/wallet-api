package com.assignment.WalletRestApi.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.assignment.WalletRestApi.entities.Users;
import com.assignment.WalletRestApi.services.UserService;

@RestController
public class SignupController {
	

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public String userSignup(@RequestBody Users user) {
		
		return this.userService.userSignup(user);
		
	}
}
