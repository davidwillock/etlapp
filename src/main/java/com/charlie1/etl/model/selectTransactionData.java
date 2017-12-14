package com.charlie1.etl.model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class selectTransactionData {
	
	

	
	
	
	private String jsonstr="";
	
	
	
	public selectTransactionData() {
		
	
		
		getTrans();
	}
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	public void getTrans() {
		
		
	
	
	
	
	
	
	
	
	
	 String str="";
	 
	 ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	 
	 
	 FundsDAO transactionDAO = (FundsDAO) context.getBean("FundsDAO");
//    str =  journalDAO.buildStrJournalData();
	

	
	
	
	
	

       String transData =  transactionDAO.buildStrTransactionData();
       if (transData.equals(""))
       {
           

       	transData = "{'TerminalID': '-','JournalID' : '-','Atm_Value': '-','Atm_Volume':'-','Atm_Uptime':'-'}";

       }
       else
       {
       	StringBuilder sb = new StringBuilder(transData);
       	sb.deleteCharAt(transData.length()-1);
       	transData = sb.toString();
       }



       
       jsonstr += "{\"TransactionData\": [";
       jsonstr += transData + "]}";
      

       


























}	

	
	
	
	
	
	
	
	
	
	

}
