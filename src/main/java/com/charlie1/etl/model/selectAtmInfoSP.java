
package com.charlie1.etl.model;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class selectAtmInfoSP {
	
	
	public selectAtmInfoSP() {
		getAtmInfo();
	}
	
	

	private String jsonstr="";
	
	
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}




	public void getAtmInfo() {

		
		
   	 String strAtmInfo="";
   	 
   	 ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module3.xml");
   	 
   	 
   	 FundsDAO AtmInfoDAO = (FundsDAO) context.getBean("Etl2DAO");
   	 
//        str =  journalDAO.buildStrJournalData();
		
	
		
  // 	public List<Map<String, Object>> TestResultset(Integer departId) {
		
   	List<Map<String, Object>> LMResult;
		

	        LMResult =  AtmInfoDAO.TestResultset();
	        strAtmInfo += "{";
	        
	           
	        for (Map<String, Object> map :  LMResult) {
	            for (Map.Entry<String, Object> entry : map.entrySet()) {
	                System.out.println(entry.getKey() + " -* " + entry.getValue());
	            	
	            	strAtmInfo += "'"  + entry.getKey() +"': '"+ entry.getValue()+"',";
	            	if(entry.getKey().equals("Rate")) { 
	            		
	            		StringBuilder sb = new StringBuilder(strAtmInfo);
	    	        	sb.deleteCharAt(strAtmInfo.length()-1);
	    	        	strAtmInfo = sb.toString();
	    	        	strAtmInfo += "},{"; 
	            		
	            		
	            	}
	            	
	            
	            //	bankingData = "{'CustId': '-','TerminalID' : '-','Model': '-','StoreID':'-'}";
	            	
	            	
	            	
	            }
	        	System.out.println(strAtmInfo);
	        }
	        
	        
	        
	        
	        
	        
	        
	        
	 /*       
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

*/
	        if(strAtmInfo.charAt(strAtmInfo.length()-1) == ('{')){
	        StringBuilder sb = new StringBuilder(strAtmInfo);
        	sb.deleteCharAt(strAtmInfo.length()-1);
        	sb.deleteCharAt(strAtmInfo.length()-2);
        	strAtmInfo = sb.toString();
	        }
 
	        
	        jsonstr += "{\"AtmInfoData\": [";
	        jsonstr += strAtmInfo + "]}";
	       

	        






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
		
		
	
	
	
	
	

}
