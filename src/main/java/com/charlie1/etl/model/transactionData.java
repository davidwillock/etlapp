package com.charlie1.etl.model;

public class transactionData {
	
	
	public transactionData() {}
	
	

	String journalID;
	int atm_value;
	int atm_volume;
	int uptime;
	
	
	public int getUptime() {
		return uptime;
	}
	public void setUptime(int uptime) {
		this.uptime = uptime;
	}



	String terminalID;
	public String getTerminalID() {
		return terminalID;
	}
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	public String getJournalID() {
		return journalID;
	}
	public void setJournalID(String journalID) {
		this.journalID = journalID;
	}
	public int getAtm_value() {
		return atm_value;
	}
	public void setAtm_value(int atm_value) {
		this.atm_value = atm_value;
	}
	public int getAtm_volume() {
		return atm_volume;
	}
	public void setAtm_volume(int atm_volume) {
		this.atm_volume = atm_volume;
	}



	
	
	
	

}
