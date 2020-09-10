package com.assignment.WalletRestApi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assignment.WalletRestApi.entities.Transaction;
import com.assignment.WalletRestApi.services.ViewPassbookService;

@RestController
public class ViewPassbookController {
	
	@Autowired
	private ViewPassbookService viewPassbookService;
	
	@GetMapping("/transactions/{userId}")
	public List<Transaction> getUserTransactions(@PathVariable String userId){
		
		return this.viewPassbookService.getUserTransactions(Long.parseLong(userId));
		
	}

}
