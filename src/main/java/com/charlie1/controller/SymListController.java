package com.charlie1.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.ui.ModelMap;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.charlie1.funds.model.jRisk;
//import com.charlie1.funds.model.selectFundsByFund;
import com.charlie1.etl.model.selectFundsAll;
import com.charlie1.etl.model.selectFundsByFund;








@Controller
@RequestMapping("/rest/SelectFundsAll")
public class SymListController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	String getAllSymData(ModelMap model) {
		
		

	    String sym ="";
	    String fundname ="";
	    String jsonstr="";
	    String jsonsim="";
	    String jsonname="";
	    String jsonpost="";
	    String jsoncomma="";
        
        
        selectFundsAll thefund = new selectFundsAll();
        
        String strRisk = thefund.getjsonStr();
        
		
        
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

            sym = rootObj.getString("symID");
            fundname = rootObj.getString("fundName");
            
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
	    model.addAttribute("symbolList",strRisk);
	
		return "test";

	}
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


