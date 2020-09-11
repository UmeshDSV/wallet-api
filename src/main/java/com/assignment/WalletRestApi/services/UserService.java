package com.assignment.WalletRestApi.services;


import com.assignment.WalletRestApi.entities.Users;

public interface UserService {
	
	public String userSignup(Users user);
	public String userSignin(Users user);
	public String addMoney(Users addmoney);
	public String transferMoney(Transfer transfer);
	public String calculateTransferfee(Transfer transfer);
	public String getTransactionStatus(long transactionid);
	public String withdrawMoney(long transactionid);
}
