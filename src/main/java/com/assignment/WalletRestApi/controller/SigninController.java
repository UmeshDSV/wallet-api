package com.assignment.WalletRestApi.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.assignment.WalletRestApi.entities.Users;
import com.assignment.WalletRestApi.services.UserService;

@RestController
public class SigninController {
	

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signin")
	public String userSignin(@RequestBody Users user) {
		
		return this.userService.userSignin(user);
		
	}
}
