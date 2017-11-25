package com.charlie1.etl.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.charlie1.etl.dao.FundsDAO;

import com.charlie1.etl.model.journalLookup;
//import com.charlie1.etl.model.







	public class sendJournalStatus {
	
	
	public sendJournalStatus() {}
	
	String terminalID;
	String journalStatus;
	List<journalLookup> journaldataArray;
	
	
	public List<journalLookup> getJournaldata() {
		return journaldataArray;
	}
	public void setJournaldata(List<journalLookup> journaldataArray) {
		this.journaldataArray = journaldataArray;
	}
	

	
	
	
	
	
	 
	public void initialiseData() {
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		
		
		
		
		
		//List<journalLookup> journals = journaldataArray;
		
		
		//journals.(journaldataArray);
		 
		
		
		 
		 FundsDAO journalDAO = (FundsDAO) context.getBean("FundsDAO");
	     journalDAO.updateTable(journaldataArray);
		
		
		
		
		
	}
	
	
	
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
