package com.charlie1.etl.model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class selectJournal {
	
	
	
	
	
	
	
	
	

	
	
	
	private String jsonstr="";
	private String risk1;
	private String risk2;
	
	
	
	public selectJournal() {
		
	
		
		getJournals();
	}
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	private void getJournals() {
		
		
		
		
		
		
    	 String str="";
    	 
    	 ApplicationContext context = 
         		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
    	 
    	 FundsDAO journalDAO = (FundsDAO) context.getBean("FundsDAO");
//         str =  journalDAO.buildStrJournalData();
		
	
		
		
		
		
		

	        String journalData =  journalDAO.buildStrJournalData();
	        if (journalData.equals(""))
	        {
	            

	        	journalData = "{'TerminalID': '-','JournalData' : '-','JournalStatus': '-'}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(journalData);
	        	sb.deleteCharAt(journalData.length()-1);
	        	journalData = sb.toString();
	        }


  
	        
	        jsonstr += "{\"ETLData\": [";
	        jsonstr += journalData + "]}";
	       

	        






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	

}
