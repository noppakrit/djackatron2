package com.test.djackatron2.model;

import com.test.djackatron2.service.IFeePolicy;

public class FeePolicy implements IFeePolicy {

	private Double fee;
	
	
	public FeePolicy() {
		super();
	}
	
	
	public FeePolicy(Double fee) {
		super();
		this.setFee(fee);
	}
	
	@Override
	public Double getFee() {
		// TODO Auto-generated method stub
		return this.fee;
	}

	@Override
	public void setFee(Double fee) {
		this.fee = fee;
		
	}


	@Override
	public Double getCalFee(Double transferValue) {		
		return this.fee;
	}

	
	
}
