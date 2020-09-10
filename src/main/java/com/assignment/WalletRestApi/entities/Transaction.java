package com.assignment.WalletRestApi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(name="transactionid",initialValue=1,allocationSize=50)
public class Transaction {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionid")
	@Id private long transactionId;
	private String referenceID;
	private long userId;
	private String transactionType;
	private double transactionAmount;
	private String transactionStatus;
	private char addingMoneytoWallet;
	public Transaction(String referenceID, long userId, String transactionType, long transactionAmount,
			String transactionStatus, char addingMoneytoWallet) {
		super();
		this.referenceID = referenceID;
		this.userId = userId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
		this.addingMoneytoWallet = addingMoneytoWallet;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReferenceID() {
		return referenceID;
	}
	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setAddingMoneytoWallet(char addingMoneytoWallet) {
		this.addingMoneytoWallet = addingMoneytoWallet;
	}
	public long getAddingMoneytoWallet() {
		return addingMoneytoWallet;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", referenceID=" + referenceID + ", userId=" + userId
				+ ", transactionType=" + transactionType + ", transactionAmount=" + transactionAmount
				+ ", transactionStatus=" + transactionStatus + ", addingMoneytoWallet=" + addingMoneytoWallet + "]";
	}
	
	
	

}
