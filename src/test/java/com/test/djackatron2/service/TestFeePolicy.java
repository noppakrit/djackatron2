package com.test.djackatron2.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.test.djackatron2.model.FeePolicy;

public class TestFeePolicy {

	
	private FeePolicy fee;
	
	@Before
	public void newFeePolicy() {
		fee = new FeePolicy();
	}
	
	@Test
	public void testFeeStaticWithSetMethod() {
		fee.setFee(10.0d);
		assertEquals((Double)10.0d, fee.getFee());
	
	}
	
	@Test
	public void testFeeStaticWithConstructure() {
		FeePolicy fee = new FeePolicy((Double)10.0d);
		assertEquals((Double)10.0d, fee.getFee());
	
	}
	
	
	@Test
	public void testFeeNull() {
		fee.setFee((Double)null);
		assertNull(fee.getFee());
	}
	
	@Test
	public void testCalFee() {
		fee.setFee((Double)10.0d);
		assertEquals((Double)10.0d, fee.getCalFee((Double)10.0d));
	}

}
