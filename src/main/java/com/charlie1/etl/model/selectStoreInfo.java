package com.charlie1.etl.model;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class selectStoreInfo {
	
	
	public selectStoreInfo() {
		getStoreInfo();
	}
	
	

	private String jsonstr="";
	
	
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	public void getStoreInfo() {

		
		
   	 String str="";
   	 
   	 ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
   	 
   	 
   	 FundsDAO StoreInfoDAO = (FundsDAO) context.getBean("FundsDAO");
//        str =  journalDAO.buildStrJournalData();
		
	
		
		
		
		
		

	        String storeInfoData =  StoreInfoDAO.buildStrStoreInfo();
	        if (storeInfoData.equals(""))
	        {
	            

	        	storeInfoData = "{'CustId': '-','TerminalID' : '-','Model': '-','StoreID':'-'}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(storeInfoData);
	        	sb.deleteCharAt(storeInfoData.length()-1);
	        	storeInfoData = sb.toString();
	        }


 
	        
	        jsonstr += "{\"StoreInfoData\": [";
	        jsonstr += storeInfoData + "]}";
	       

	        






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
		
		
	
	
	
	
	

}
