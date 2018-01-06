package com.charlie1.etl.model;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class selectBankingData {
	
	
	public selectBankingData() {
		getBankingData();
	}
	
	

	private String jsonstr="";
	
	
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	public void getBankingData() {

		
		
   	 String str="";
   	 
   	 ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
   	 
   	 
   	 FundsDAO BankingDataDAO = (FundsDAO) context.getBean("FundsDAO");

		
	
		
		
		
		
		

	        String bankingData =  BankingDataDAO.buildStrStoreInfo();
	        if (bankingData.equals(""))
	        {
	            

	        	bankingData = "{'CustId': '-','TerminalID' : '-','Model': '-','StoreID':'-'}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(bankingData);
	        	sb.deleteCharAt(bankingData.length()-1);
	        	bankingData = sb.toString();
	        }


 
	        
	        jsonstr += "{\"BankingData\": [";
	        jsonstr += bankingData + "]}";
	       

	        






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
		
		
	
	
	
	
	

}

