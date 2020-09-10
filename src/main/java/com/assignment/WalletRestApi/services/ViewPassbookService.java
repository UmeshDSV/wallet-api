package com.assignment.WalletRestApi.services;
import java.util.List;
import com.assignment.WalletRestApi.entities.*;
public interface ViewPassbookService {
	public List<Transaction> getUserTransactions(long userId);
		
}
