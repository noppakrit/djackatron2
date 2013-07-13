package com.test.djackatron2.model;

public class DefaultTransferService {

	private AccountRepository accountRepository;
	private FeePolicy fee;
	
	public void setFeePolicy(FeePolicy _fee) {
		this.fee = _fee;
	}
	
	public void setAccountRepository (AccountRepository _accountRepo) {
		this.accountRepository = _accountRepo;
	}
	
	public void transfer(double _tranAmount, String _scrAccountNo, String _destAccountNo) {
		Account scrAccount = accountRepository.find(_scrAccountNo);
		Account destAccount = accountRepository.find(_destAccountNo); 
		
		scrAccount.setBalance(scrAccount.getBalance()-_tranAmount-this.fee.getCalFee(_tranAmount));
		destAccount.setBalance(destAccount.getBalance()+_tranAmount);
	}
	
}
