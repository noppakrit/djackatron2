package com.test.djackatron2.model;

public class Account {

	private String accountNo;
	private double balance;
	
	public Account(String _accountNo, double _balance) {
		this.accountNo = _accountNo;
		this.balance = _balance;
				
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
