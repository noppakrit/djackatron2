package com.test.djackatron2.service;

public interface IFeePolicy {
	public Double getFee();
	public void setFee(Double fee);
	public Double getCalFee(Double transferValue);
}
