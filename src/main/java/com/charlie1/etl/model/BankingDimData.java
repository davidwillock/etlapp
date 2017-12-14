package com.charlie1.etl.model;

public class BankingDimData {

	
	String BankID;
	String BankName;
	int Rate;
	
	
	public BankingDimData() {}
	
	
	public String getBankID() {
		return BankID;
	}


	public void setBankID(String bankID) {
		BankID = bankID;
	}


	public String getBankName() {
		return BankName;
	}


	public void setBankName(String bankName) {
		BankName = bankName;
	}


	public int getRate() {
		return Rate;
	}


	public void setRate(int rate) {
		Rate = rate;
	}


	
	
	
}
