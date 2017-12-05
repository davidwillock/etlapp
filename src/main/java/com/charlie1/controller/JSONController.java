package com.charlie1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;
import com.charlie1.etl.model.Shop;
import com.charlie1.etl.model.selectFundsByRisk;
import com.charlie1.etl.model.jRisk;

import org.json.JSONArray;
import org.json.JSONObject;


@Controller
@RequestMapping("/rest/apiSelectFundsByRisk")
public class JSONController {

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody
	jRisk getTestJSON(@PathVariable String name) {
		
		
		// String risk1 = "1";
        // String risk2 = "4";
    	// String str="";
    	 
    	 ApplicationContext context = 
         		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
    	 
    	// FundsDAO customerDAO = (FundsDAO) context.getBean("FundsDAO");
        // str =  customerDAO.buildStrPeformanceData(risk1, risk2);
    	 String risk1="";
    	 String risk2="";
    	 
		try {
		JSONObject jsonObj = new JSONObject(name);
        risk1 = jsonObj.getString("risk1");
        risk2 = jsonObj.getString("risk2");
        
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
        selectFundsByRisk fundsByRisk = new selectFundsByRisk(risk1,risk2);
        
        String strRisk = fundsByRisk.getjsonStr();
        
        
		      
         
	//	Shop shop = new Shop();
	//	shop.setName(strRisk);
		
		jRisk jrisk = new jRisk();
		jrisk.setRisk1(strRisk);
		
		//shop.setStaffName(new String[] { "mkyong1", "mkyong2" });

		return jrisk;

	}
	
	
	
	
	
	
	

}
