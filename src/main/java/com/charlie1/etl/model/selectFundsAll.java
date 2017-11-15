package com.charlie1.etl.model;


import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;


public class selectFundsAll {
	
	

	private String jsonstr="";
	private String fund;

	
	
	
	public selectFundsAll() {
		
		
		
		
		getFunds();
	}
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	private void getFunds() {
		
		
		
		
		
		
    	 String str="";
    	 
    	 ApplicationContext context = 
         		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
    	 
    	 FundsDAO customerDAO = (FundsDAO) context.getBean("FundsDAO");
 	      
    	 String PerformanceData = customerDAO.buildStrPeformanceDataAll();
	        if (PerformanceData.equals(""))
	        {

	            PerformanceData = "{'symbol': '-','InceptionDate' : '2001-01-01','Mer': '0', 'Asset': '0','Rank': '0' ,'MstarRating': '0','StdDev': '0','VolatileRank': '0','Alpha': '0','Beta': '0','Rsquare': '0','RRSPEligibility': '-','Load': '-','MaxFrontEnd': '0','MaxBackEnd': '0','SalesOpen': '-','NavPs': '0','NetAsset': '0','Yield': '0','Dividend': '0','Managers': '0','Fees': '0','FundName': '0'}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(PerformanceData);
	        	sb.deleteCharAt(PerformanceData.length()-1);
	        	PerformanceData = sb.toString();
	        }


	        jsonstr += "{\"Performance\": [";
	        jsonstr += PerformanceData + "]}";
	
		
	}
	

	
	
	
	
	
	
	
	
	

}
