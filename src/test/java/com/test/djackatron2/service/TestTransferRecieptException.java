package com.test.djackatron2.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.model.AccountRepository;
import com.test.djackatron2.model.DefaultTransferService;
import com.test.djackatron2.model.FeePolicy;




import static org.mockito.Mockito.*;


public class TestTransferRecieptException {

	private DefaultTransferService transferService ;
	private Account scrAccount;
	private Account destAccount ;
	private String scrAccountNo;
	private String destAccountNo;
	
	@Before
	public void setup(){
        double feeRate = 5.0d;
		
		 scrAccountNo = "NPK001";
		double scrBalance = 100.0d;
		scrAccount = new Account(scrAccountNo, scrBalance);
	
		
		
		destAccountNo = "DEST001";
		double destBalance = 0.0d;
		destAccount = new Account(destAccountNo,destBalance);
		
		
		transferService = new DefaultTransferService();

		FeePolicy feePolicy = mock(FeePolicy.class);
		when(feePolicy.getCalFee(anyDouble())).thenReturn(feeRate);
		
		
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.find(scrAccountNo)).thenReturn(scrAccount);
		when(accountRepository.find(destAccountNo)).thenReturn(destAccount);
		
		
		transferService.setFeePolicy(feePolicy);
		transferService.setAccountRepository(accountRepository);
		
	}
	
	
	@Test(expected=InsufficientFundException.class)
	public void testException()  {
		//given
		double tranAmount = 95.0d;
		
		
		
		
		
		
		//when
		transferService.transfer(tranAmount, scrAccountNo, destAccountNo);
		
		
		//then
		fail();
	
		
	}

}
