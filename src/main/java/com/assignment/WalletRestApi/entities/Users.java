package com.assignment.WalletRestApi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="userid",initialValue=1000,allocationSize=50)
public class Users {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userid")
	@Id private long userId;
	private String userName;
	private String password;
	private double walletAmount;
	public Users(String userName, String password, long walletAmount) {
		super();
		this.userName = userName;
		this.password = password;
		this.walletAmount = walletAmount;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
	public long getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", walletAmount="
				+ walletAmount + "]";
	}
	
	
	
}
