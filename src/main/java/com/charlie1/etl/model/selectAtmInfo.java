package com.charlie1.etl.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class selectAtmInfo {
	
	
	public selectAtmInfo() {
		getAtmInfo();
	}
	
	

	private String jsonstr="";
	
	
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	public void getAtmInfo() {

		
		
   	 String str="";
   	 
   	 ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
   	 
   	 
   	 FundsDAO AtmInfoDAO = (FundsDAO) context.getBean("FundsDAO");
//        str =  journalDAO.buildStrJournalData();
		
	
		
		
		
		
		

	        String atmInfoData =  AtmInfoDAO.buildStrAtmInfo();
	        if (atmInfoData.equals(""))
	        {
	            

	        	atmInfoData = "{'CustId': '-','TerminalID' : '-','Model': '-','StoreID':'-'}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(atmInfoData);
	        	sb.deleteCharAt(atmInfoData.length()-1);
	        	atmInfoData = sb.toString();
	        }


 
	        
	        jsonstr += "{\"AtmInfoData\": [";
	        jsonstr += atmInfoData + "]}";
	       

	        






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
		
		
	
	
	
	
	

}
