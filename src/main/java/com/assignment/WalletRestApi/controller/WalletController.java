package com.assignment.WalletRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.WalletRestApi.entities.Users;
import com.assignment.WalletRestApi.services.Transfer;
import com.assignment.WalletRestApi.services.UserService;

@RestController
public class WalletController {
	
	@Autowired
	private UserService userService;
	
	@PutMapping("/addmoney")
	public String addMoney(@RequestBody Users addmoney) {
		
		return this.userService.addMoney(addmoney);
		
	}
	
	@PutMapping("/transfer")
	public String transferMoney(@RequestBody Transfer transfer) {
		
		return this.userService.transferMoney(transfer);
	}
	
	@GetMapping("/transferfee")
	public String calculateTransferfee(@RequestBody Transfer transfer) {
		
		return this.userService.calculateTransferfee(transfer);
	}
	
	@GetMapping("/transactionstatus/{transactionid}")
	public String getTransactionStatus(@PathVariable String transactionid) {
		
		return this.userService.getTransactionStatus(Long.parseLong(transactionid));
	}
	
	
	@PutMapping("/reversetranction/{transactionid}")
	public String withdrawMoney(@PathVariable String transactionid) {
		
		return this.userService.withdrawMoney(Long.parseLong(transactionid));
	}
	

}
