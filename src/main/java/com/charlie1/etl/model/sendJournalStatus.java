package com.charlie1.etl.model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.charlie1.etl.dao.FundsDAO;

import com.charlie1.etl.model.journalLookup;
//import com.charlie1.etl.model.







	public class sendJournalStatus {
	
	
	public sendJournalStatus() {}
	
	String terminalID;
	String journalStatus;
	
	
	public String getTerminalID() {
		return terminalID;
	}
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	public String getJournalStatus() {
		return journalStatus;
	}
	public void setJournalStatus(String journalStatus) {
		this.journalStatus = journalStatus;
	}

	 
	void initialiseData() {
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		journalLookup journallookup = new journalLookup();
		
		
		journallookup.getJournalStatus();
		journallookup.getTerminalID();
		 
		
		
		 
		 FundsDAO journalDAO = (FundsDAO) context.getBean("FundsDAO");
	     journalDAO.updateTable(journallookup);
		
		
		
		
		
	}
	
	
	
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
