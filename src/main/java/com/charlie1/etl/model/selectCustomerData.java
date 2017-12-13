package com.charlie1.etl.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class selectCustomerData {
	
	
	public selectCustomerData(){
		
	
	}
	
	
	
	private String jsonstr="";
	private String risk1;
	private String risk2;
	
	
	
	
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	public void getCustomers() {

		
		
   	 String str="";
   	 
   	 ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
   	 
   	 
   	 FundsDAO CustomerDAO = (FundsDAO) context.getBean("FundsDAO");
//        str =  journalDAO.buildStrJournalData();
		
	
		
		
		
		
		

	        String customerData =  CustomerDAO.buildStrCustomerData();
	        if (customerData.equals(""))
	        {
	            

	        	customerData = "{'CustId': '-','InstallDate' : '-','RetailName': '-','RetailAddress':'-','County':'-', 'Country','-'}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(customerData);
	        	sb.deleteCharAt(customerData.length()-1);
	        	customerData = sb.toString();
	        }


 
	        
	        jsonstr += "{\"ETLData\": [";
	        jsonstr += customerData + "]}";
	       

	        






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
		
		
	
		
	
	
	
	
	
	
	
	

}
