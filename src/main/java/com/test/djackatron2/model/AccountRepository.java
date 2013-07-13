package com.test.djackatron2.model;

public class AccountRepository  {

	public Account find(String _accountNo) {
		
		Account account = null;
		
		if(_accountNo.equals("NPK001")) {
			account = new Account(_accountNo, 100);
		} else if(_accountNo.equals("DEST001")) {
			account = new Account(_accountNo, 0);
		}
		
		return account;
	}
	
}
