package com.test.djackatron2.model;

import com.test.djackatron2.service.IFeePolicy;

public class FeePolicy implements IFeePolicy {

	private double fee;
	

	
	public FeePolicy(double _fee) {
//		super();
		this.fee = _fee;
	}
	


	@Override
	public Double getCalFee(double _transferValue) {		
		return this.fee;
	}

	
	
}
