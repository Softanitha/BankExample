package com.micro.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNumber;
	private String accountHolderName;
	private double accountBalance;
	
	public Account() {
	}
	
	
	public Account(String accountHolderName, double accountBalance) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}


	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountBalance=" + accountBalance + "]";
	}
 

}
 

