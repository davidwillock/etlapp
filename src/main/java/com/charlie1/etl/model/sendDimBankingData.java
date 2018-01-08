package com.charlie1.etl.model;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class sendDimBankingData {
	
	
	public sendDimBankingData() {}
	
	List<bankingData> bankingDataArray;
		 
	public List<bankingData> getTransactionData() {
		return bankingDataArray;
	}

	public void setDimBankingData(List<bankingData> bankingDataArray) {
		this.bankingDataArray = bankingDataArray;
	}

	public void initialiseData() {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module2.xml");
	
		FundsDAO bankingDAO = (FundsDAO) context.getBean("EtlDAO");
	    bankingDAO.execBankingDataDim();
		
	}
		
	public void initializeBean() { }
	
}

