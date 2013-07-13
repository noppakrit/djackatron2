package com.test.djackatron2.model;

import com.test.djackatron2.service.InsufficientFundException;
import com.test.djackatron2.service.illegalTransferException;

public class DefaultTransferService {

	private AccountRepository accountRepository;
	private FeePolicy fee;
	private VariableFeePolicy variableFee;
	private double minTransfer;
	
	public void setFeePolicy(FeePolicy _fee) {
		this.fee = _fee;
	}
	
	public void setVariableFeePolicy(VariableFeePolicy _variableFee) {
		this.variableFee = _variableFee;
	}
	
	
	public void setMinimumTransfer(double _minTransfer) {
		this.minTransfer = _minTransfer;
	}
	
	
	public void setAccountRepository (AccountRepository _accountRepo) {
		this.accountRepository = _accountRepo;
	}
	
	
	
	public void transfer(double _tranAmount, String _scrAccountNo, String _destAccountNo) throws InsufficientFundException, illegalTransferException {
		
		
		
		Account scrAccount = accountRepository.find(_scrAccountNo);
		Account destAccount = accountRepository.find(_destAccountNo); 
		
		
		if(scrAccount.getBalance()-this.fee.getCalFee(_tranAmount)-_tranAmount <= 0) {
			throw new InsufficientFundException();
		} else if(_tranAmount <= 0) {
			throw new illegalTransferException();
		} else if(_tranAmount < this.minTransfer) {
			throw new illegalTransferException();
		}
			
			
		scrAccount.setBalance(scrAccount.getBalance()-_tranAmount-this.fee.getCalFee(_tranAmount));
		destAccount.setBalance(destAccount.getBalance()+_tranAmount);
		
		
		
	}
	
}
