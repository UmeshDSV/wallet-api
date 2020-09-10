package com.assignment.WalletRestApi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.WalletRestApi.dao.TransactionDAO;
import com.assignment.WalletRestApi.entities.Transaction;

@Service
public class ViewPassbookServiceImpl implements ViewPassbookService {
	@Autowired
	private TransactionDAO transactionDao;
	
	
	public ViewPassbookServiceImpl() {
		
	}

	@Override
	public List<Transaction> getUserTransactions(long userId) {
		List<Transaction> transactions;
		transactions = new ArrayList<>();
		transactions = this.transactionDao.findAll();
		List<Transaction> userTransactions;
		userTransactions = new ArrayList<>();
		for (Transaction t:transactions) {
			if (t.getUserId() == userId) {
				userTransactions.add(t);
			}
		}
		return userTransactions;
	}



}
