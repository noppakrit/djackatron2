package com.test.djackatron2.service;

import static org.junit.Assert.*;

import org.junit.Test;


import com.test.djackatron2.model.VariableFeePolicy;




import static org.hamcrest.CoreMatchers.equalTo;


public class TestTransferRecieptVariableFeePolicyTransferException {

	@Test
	public void testException()  {

		VariableFeePolicy v = new VariableFeePolicy(100.0d);
		double expectedFee = 0.0d;
		assertThat(v.getVaiableFee(), equalTo(expectedFee));
		
	}

}
