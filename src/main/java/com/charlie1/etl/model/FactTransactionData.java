package com.charlie1.etl.model;

public class FactTransactionData {
	
	
	String TerminalID;
	public String getTerminalID() {
		return TerminalID;
	}
	public void setTerminalID(String terminalID) {
		TerminalID = terminalID;
	}
	String JournalID;
	String CustID;
	String StoreID;
	String BankID;
	int Atm_value;
	int Atm_volume;
	int Atm_upTime;
	
	public String getJournalID() {
		return JournalID;
	}
	public void setJournalID(String journalID) {
		JournalID = journalID;
	}
	public int getAtm_value() {
		return Atm_value;
	}
	public void setAtm_value(int atm_value) {
		Atm_value = atm_value;
	}
	public int getAtm_volume() {
		return Atm_volume;
	}
	public void setAtm_volume(int atm_volume) {
		Atm_volume = atm_volume;
	}
	public int getAtm_upTime() {
		return Atm_upTime;
	}
	public void setAtm_upTime(int atm_upTime) {
		Atm_upTime = atm_upTime;
	}
	public String getCustID() {
		return CustID;
	}
	public void setCustID(String custID) {
		CustID = custID;
	}
	public String getStoreID() {
		return StoreID;
	}
	public void setStoreID(String storeID) {
		StoreID = storeID;
	}
	public String getBankID() {
		return BankID;
	}
	public void setBankID(String bankID) {
		BankID = bankID;
	}
	
	
	
	
	
	
	
	

}
