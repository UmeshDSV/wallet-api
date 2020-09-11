package com.assignment.WalletRestApi.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.WalletRestApi.dao.TransactionDAO;
import com.assignment.WalletRestApi.dao.UsersDAO;
import com.assignment.WalletRestApi.entities.Transaction;
import com.assignment.WalletRestApi.entities.Users;

@Service
public class UserServiceImpl implements UserService {
	public static double defWalletAmount = 0;
	public static double charge = 0.2;
	public static double commission = 0.05;
	
	@Autowired
	private UsersDAO userDao;
	
	@Autowired
	private TransactionDAO transactionDao;
	

	@Override
	public String userSignup(Users user) {
		
		if(user.getUserName() == null) {
			return "Username cannot be null";
		}
		if(user.getPassword() == null) {
			return "Password cannot be null";
		}
		
		for(Users u:this.userDao.findAll()) {
			if(u.getUserName().equals(user.getUserName())) {
				return "Username already exists";
			}
		}
		
		user.setWalletAmount(defWalletAmount);
		this.userDao.save(user);
		
		return "SignUp Successful";
	}


	@Override
	public String addMoney(Users addmoney) {
		if(addmoney.getWalletAmount() <= 0) {
			return "Invalid Amount";
		}
		
		String referenceID = java.util.UUID.randomUUID().toString();
		Transaction debitTransaction = new Transaction();
		debitTransaction.setReferenceID(referenceID);
		debitTransaction.setUserId(addmoney.getUserId());
		debitTransaction.setTransactionType("Debit");
		debitTransaction.setTransactionAmount(addmoney.getWalletAmount());
		debitTransaction.setTransactionStatus("Successful");
		debitTransaction.setAddingMoneytoWallet('Y');
		transactionDao.save(debitTransaction);
		
		for(Users u : this.userDao.findAll()) {
			if(u.getUserId() == addmoney.getUserId()) {
				addmoney.setWalletAmount(addmoney.getWalletAmount()+u.getWalletAmount());
				userDao.save(addmoney);
				break;
			}
			
		}
		
		return "Money credited to the wallet successfully";
	}


	@Override
	public String transferMoney(Transfer transfer) {
		String referenceID = java.util.UUID.randomUUID().toString();
		
		Users fromUser = userDao.getOne(transfer.getFromUser());
		Users toUser = userDao.getOne(transfer.getToUser());
		double tempAmount = transfer.getAmount()*(1+charge+commission);
		if(fromUser.getWalletAmount() >= tempAmount) {
			fromUser.setWalletAmount(fromUser.getWalletAmount()-tempAmount);
			userDao.save(fromUser);
			Transaction debitTransaction = new Transaction(); 
			debitTransaction.setReferenceID(referenceID);
			debitTransaction.setUserId(fromUser.getUserId());
			debitTransaction.setTransactionType("Debit");
			debitTransaction.setTransactionAmount(tempAmount);
			debitTransaction.setTransactionStatus("Successful");
			debitTransaction.setAddingMoneytoWallet('N');
			transactionDao.save(debitTransaction);
			toUser.setWalletAmount(toUser.getWalletAmount()+transfer.getAmount());
			userDao.save(toUser);
			Transaction creditTransaction = new Transaction();
			creditTransaction.setReferenceID(referenceID);
			creditTransaction.setUserId(toUser.getUserId());
			creditTransaction.setTransactionType("Credit");
			creditTransaction.setTransactionAmount(transfer.getAmount());
			creditTransaction.setTransactionStatus("Successful");
			creditTransaction.setAddingMoneytoWallet('N');
			transactionDao.save(creditTransaction);
			
			
			
			return "Transaction Successful";
		}
		else {
			Transaction debitTransaction = new Transaction();
			debitTransaction.setReferenceID(referenceID);
			debitTransaction.setUserId(fromUser.getUserId());
			debitTransaction.setTransactionType("Debit");
			debitTransaction.setTransactionAmount(tempAmount);
			debitTransaction.setTransactionStatus("Unsuccessful");
			debitTransaction.setAddingMoneytoWallet('N');
			transactionDao.save(debitTransaction);
			
			return "Insufficient Funds";
		}
		
	}


	@Override
	public String calculateTransferfee(Transfer transfer) {
		double tempAmount = transfer.getAmount()*(charge+commission);
		return "Total Transaction fee (Charge-0.2% and Commission-0.05%) is "+tempAmount;
	}


	@Override
	public String getTransactionStatus(long transactionid) {
		Transaction transaction = transactionDao.getOne(transactionid);
		return transaction.getTransactionStatus();
	}


	@Override
	public String withdrawMoney(long transactionid) {
		Transaction transaction = transactionDao.getOne(transactionid);
		double tempAmount = transaction.getTransactionAmount()*(1+charge+commission);
		String referenceID = java.util.UUID.randomUUID().toString();
		if(transaction.getAddingMoneytoWallet() == 'Y') {
			Users user = userDao.getOne(transaction.getUserId());
			if(user.getWalletAmount() >= tempAmount) {
				user.setWalletAmount(user.getWalletAmount()-tempAmount);
				Transaction debitTransaction = new Transaction();
				debitTransaction.setReferenceID(referenceID);
				debitTransaction.setUserId(user.getUserId());
				debitTransaction.setTransactionType("Debit");
				debitTransaction.setTransactionAmount(tempAmount);
				debitTransaction.setTransactionStatus("Successful");
				debitTransaction.setAddingMoneytoWallet('N');
				transactionDao.save(debitTransaction);
				return "Transaction reversed successfully";
				
			}
			else {
				user.setWalletAmount(user.getWalletAmount()-tempAmount);
				Transaction debitTransaction = new Transaction();
				debitTransaction.setReferenceID(referenceID);
				debitTransaction.setUserId(user.getUserId());
				debitTransaction.setTransactionType("Debit");
				debitTransaction.setTransactionAmount(tempAmount);
				debitTransaction.setTransactionStatus("Unuccessful");
				debitTransaction.setAddingMoneytoWallet('N');
				transactionDao.save(debitTransaction);
				return "Insufficient Funds";
			}
			
		}
		else {
			return "This Transaction cannot be reversed";
		}
		
	}


	@Override
	public String userSignin(Users user) {
		if(user.getUserName() == null) {
			return "Username cannot be null";
		}
		if(user.getPassword() == null) {
			return "Password cannot be null";
		}
		
		for(Users u:this.userDao.findAll()) {
			if(u.getUserName().equals(user.getUserName())) {
				if(u.getPassword().equals(user.getPassword())) {
					return "logged in successfully";
				}
			}
		}
		return "User not registered";
	}

}
