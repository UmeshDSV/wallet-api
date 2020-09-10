package com.assignment.WalletRestApi.services;

public class Transfer {
	
	private long fromUser;
	private long toUser;
	private long amount;
	public Transfer(long fromUser, long toUser, long amount) {
		super();
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
	}
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getFromUser() {
		return fromUser;
	}
	public void setFromUser(long fromUser) {
		this.fromUser = fromUser;
	}
	public long getToUser() {
		return toUser;
	}
	public void setToUser(long toUser) {
		this.toUser = toUser;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transfer [fromUser=" + fromUser + ", toUser=" + toUser + ", amount=" + amount + "]";
	}

}
