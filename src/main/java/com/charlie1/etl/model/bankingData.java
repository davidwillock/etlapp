package com.charlie1.etl.model;

public class bankingData {
	
	
	
	int bankID;
	
	
	public bankingData() {}
	
	public int getBankID() {
		return bankID;
	}
	public void setBankID(int bankID) {
		this.bankID = bankID;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getCostPerTransaction() {
		return costPerTransaction;
	}
	public void setCostPerTransaction(int costPerTransaction) {
		this.costPerTransaction = costPerTransaction;
	}
	String bankName;
	int costPerTransaction;
	
	

}
