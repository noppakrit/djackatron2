package com.test.djackatron2.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import com.test.djackatron2.model.FeePolicy;


import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(value=Parameterized.class)
public class TestFeePolicy {


	
	private FeePolicy fee;
	
	double fixRate, amount, expectedFee;
	
	
	public  TestFeePolicy(double fixRate, double amount, double expectedFee) {
		this.fixRate = fixRate;
		this.amount = amount;
		this.expectedFee = expectedFee;
	}
	
	@Parameters
	public static Collection<Object[]> primeNumber() {
		return Arrays.asList(new Object[][]{
				{5,1,5},
				{5,10,5}
				});
	}
	
		


	
	@Test
	public void testCalFee() {
		double rate = fixRate;
		fee = new FeePolicy(rate);
		double expFee = this.expectedFee;
		double calFee = fee.getCalFee(this.amount);
		assertThat(expFee, equalTo(calFee));
	}



}
