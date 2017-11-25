package com.charlie1.etl.model;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class sendTransactionData {

	
	
	




	
	
	
	public sendTransactionData() {}
	
	String terminalID;
	String journalStatus;
	List<transactionData> transactiondataArray;
	
	String transactionData;
	
	
	
	
	
	 
	public String getTransactionData() {
		return transactionData;
	}






	public void setTransactionData(List<transactionData> transactiondataArray) {
		this.transactiondataArray = transactiondataArray;
	}






	public void initialiseData() {
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		
		
		
		
		
		//List<journalLookup> journals = journaldataArray;
		
		
		//journals.(journaldataArray);
		 
		
		
		 
		 FundsDAO transDAO = (FundsDAO) context.getBean("FundsDAO");
	     transDAO.batchTransaction(transactiondataArray);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
