package com.test.djackatron2.model;

import com.test.djackatron2.service.IVariableFeePolicy;

public class VariableFeePolicy implements IVariableFeePolicy{

	private static final double MAX_FEE = 20000;
	
	private double fee;
	private double transferAmount;
	
	public VariableFeePolicy(double _transferAmount) {
		this.transferAmount = _transferAmount;
	}
	
	
	@Override
	public double getVaiableFee() {
		
		if(this.transferAmount >= 1 && this.transferAmount <= 1000) {
			this.fee = 0;
		} else if (this.transferAmount > 1000 && this.transferAmount <= 20000) {
			this.fee = this.transferAmount * 1.0d / 100.0d;
		} else {
			this.fee = MAX_FEE;
		}
		
		return this.fee;
	}

	
	
}
