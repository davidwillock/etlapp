package com.charlie1.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.charlie1.etl.model.Greeting;
import com.charlie1.etl.model.selectFundsAll;
import com.charlie1.etl.model.selectFundsByFund;
import com.charlie1.etl.model.selectFundsByRisk;
import com.charlie1.etl.model.selectRisk;


@Controller
public class SymListCatController {
	
	

	    @RequestMapping("/rest/SelectCatFunds")
		String getCatFundsData(ModelMap model,@RequestParam("risk") int risk) 
		{
	    	String cat="";
	    	
	    	//cat = "{'risk1':'1','risk2':'4'}";
	    	
	    	if(risk == 1) {
	    		
	    		cat = "{'risk1':'1','risk2':'4'}";
	    		
	    	}else if(risk == 2){
	    		
	    		cat = "{'risk1':'4','risk2':'7'}";
	    		
	    	}else if(risk == 3) {
	    		
	    		cat = "{'risk1':'8','risk2':'10'}";
	    		
	    		
	    	}
	
		
		
		
		    String sym ="";
		    String fundname ="";
		    String jsonstr="";
		    String jsonsim="";
		    String jsonname="";
		    String jsonpost="";
		    String jsoncomma="";
	        
		    
		    
		  
		    String risk1="";
		    String risk2="";
            try {
			JSONObject jsonObj = new JSONObject(cat);
	        risk1 = jsonObj.getString("risk1");
	        risk2 = jsonObj.getString("risk2");
	        
	        
            }catch(Exception ex) {
            	
            	ex.printStackTrace();
            }
	        
	        selectRisk thefunds = new selectRisk(risk1,risk2);
	        
	        
	        
	        
	        String strRisk = thefunds.getjsonStr();
		    
		   	        
	        String testrisk = thefunds.getjsonStr();
	        
	       
	        
			
	        
	        String header = "{\"Performance\": [";
	        
	        jsonsim = "{'Symid':'";
	        jsonname = ",'Fundname':'";
	        jsonpost = "'},";
	        String footer = "]}";
	        jsoncomma ="'";
	        
	        try {
	        
	        JSONObject jsonObject = new JSONObject(strRisk);
	        
	        
	        JSONArray ja_dataPerformance = jsonObject.getJSONArray("Performance");

	        int sz = ja_dataPerformance.length();
	        
	        jsonstr += header;


	        for (int i = 0; i < ja_dataPerformance.length(); i++) {

	            JSONObject rootObj = ja_dataPerformance.getJSONObject(i);


	            sym = rootObj.getString("SymID");
	            
	            fundname = rootObj.getString("FundName");
	            
	            jsonstr += jsonsim;
	            jsonstr += sym;
	            jsonstr += jsoncomma;
	            jsonstr += jsonname;
	            jsonstr += fundname;
	            jsonstr += jsonpost;
	            
	            
	          
	            
	            
	           
	        }  
	             
	             
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
		
		
	        if(!jsonstr.equals("")) {
	        	

			    StringBuilder sb = new StringBuilder(jsonstr);
	          	sb.deleteCharAt(jsonstr.length()-1);
	           	jsonstr = sb.toString();
			        	
	        	
	        }
	        
	        
	        
	        jsonstr += footer;
	        
	        
	       
		        
		        
	        
	        
	        strRisk = jsonstr; 
	        
	        
	        
		   
		    
		    model.addAttribute("symbolCatList",strRisk);
		    model.addAttribute("symbolCatListTest", testrisk);
		    
		
			return "SearchCatpage";

		}
		
	}


		
		
		
		
		
		
		
		


