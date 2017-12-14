package com.charlie1.etl.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class sendFactTransactionData {
	
	
	public sendFactTransactionData() {}
	
	

	
	String terminalID;
	String journalStatus;
	List<FactTransactionData> transactiondataArray;
	
	String transactionData;
	
	
	
	
	
	 
	public String getTransactionData() {
		return transactionData;
	}






	public void setFactTransactionData(List<FactTransactionData> transactiondataArray) {
		this.transactiondataArray = transactiondataArray;
	}






	public void initialiseData() {
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module2.xml");
		
		
		
		
		
		
		//List<journalLookup> journals = journaldataArray;
		
		
		//journals.(journaldataArray);
		 
		
		
		 
		 FundsDAO transDAO = (FundsDAO) context.getBean("EtlDAO");
	     transDAO.batchTransactionFact(transactiondataArray);
		
		
		
		
		
	}
	
	
	
	
	
	public void initializeBean() {
		
		
		
	}
	
	

}
