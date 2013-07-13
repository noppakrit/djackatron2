package com.test.djackatron2.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.model.AccountRepository;
import com.test.djackatron2.model.DefaultTransferService;
import com.test.djackatron2.model.FeePolicy;



import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestTransferReciept {

	@Test
	public void test() {
		//given
		double tranAmount = 30;
		
		
		double feeRate = 5.0d;
		
		String scrAccountNo = "NPK001";
		double scrBalance = 100;
		Account scrAccount = new Account(scrAccountNo, scrBalance);
	
		
		
		String destAccountNo = "DEST001";
		double destBalance = 0;
		Account destAccount = new Account(destAccountNo,destBalance);
		
		
		
		DefaultTransferService transferService = new DefaultTransferService();

		FeePolicy feePolicy = mock(FeePolicy.class);
		when(feePolicy.getCalFee(anyDouble())).thenReturn(feeRate);
		
		
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.find(scrAccountNo)).thenReturn(scrAccount);
		when(accountRepository.find(destAccountNo)).thenReturn(destAccount);
		
		
		transferService.setFeePolicy(feePolicy);
		transferService.setAccountRepository(accountRepository);
		
		
		//when
		transferService.transfer(tranAmount, scrAccountNo, destAccountNo);
		
		
		//then
		assertThat(scrAccount.getBalance(), equalTo(65.0d));
		assertThat(destAccount.getBalance(), equalTo(30.0d));
	
		
	}

}
