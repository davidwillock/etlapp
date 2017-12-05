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
@RequestMapping("/")
public class defaultController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	String getSearchwrapData(ModelMap model) {
		
		
		
		
		
		return "Searchwrap";
	}
	
	
	
	
	

}
