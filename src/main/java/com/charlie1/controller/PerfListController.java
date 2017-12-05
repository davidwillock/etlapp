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

import com.charlie1.etl.model.jRisk;
import com.charlie1.etl.model.selectFundsByFund;
import com.charlie1.etl.model.selectFundsByRisk;





@Controller
@RequestMapping("/rest/SelectFundsByFund")
public class PerfListController  {
	
	
	@RequestMapping(value = "{fund}", method = RequestMethod.GET)
	String getPerfData(@PathVariable String fund, ModelMap model) {
		
		
	
		String p_sym ="";
        String p_inceptdate ="";
        double p_mer =0;
        double p_assets=0;
        double p_rank =0;
        double p_mstarrating=0;
        double p_stddev =0;
        double p_volatilerank =0;
        double p_mstarrisk =0;
        double p_alpha =0;
        double p_beta =0;
        double p_rsquare =0;
        String p_rrspel ="";
        String p_load ="";
        double p_maxfrontend =0;
        double p_maxbackend =0;
        String p_salesopen ="";
        double p_navps =0;
        double p_netasset =0;
        double p_yield =0;
        double p_dividend =0;
        String p_manager ="";
        double p_Fees =0;
        String p_FullName ="";
        
        
        String h_FundSymID="";
        String h_SymID = "";
        String h_Name = "";
        String h_Asset = "";
        String h_Sector = "";
        String h_Geograph = "";
        double h_Percent = 0;
        
        
        String RReturns = ""; 
        double ROneMonth = 0;
        double RThreeMonth = 0;
        double RSixMonth = 0;
        double RYTD = 0;
        double ROneYear = 0;
        double RThreeYear = 0;
        double RFiveYear = 0;
        double RTenYear = 0;
        

        String SFund = "";
        String SSector = "";
        int SCount = 0;
        int SPercent = 0;
        
        
        String AFund = "";
        String AAsset = "";
        int ACount = 0;
        int APercent = 0;
        
        
           
        
        
        String GFund = "";
        String GGeograph = "";
        int GCount = 0;
        int GPercent = 0;
		
        
        String PCDate = "";
        String PCSymbol = "";
        double PCNavPS = 0;
		
		
		
		
		    //String fundtmp = "{'Fund': 'PGMIX'}";
        String sfund="";
        try {
	        JSONObject jsonObj = new JSONObject(fund);
	        sfund = jsonObj.getString("Fund");
	        
	        
        }catch(Exception ex) {
        	ex.printStackTrace();
        	
        }
	        selectFundsByFund thefund = new selectFundsByFund(sfund);
	        
	        String strRisk = thefund.getjsonStr();
	        String strHolding = thefund.getholdingsStr();
	        String strCalPerf = thefund.getperfCalander();
	        String strReturn =  thefund.getreturnsdataStr();
	        
	        try {
	        
	        JSONObject jsonObject = new JSONObject(strRisk);
	        
	        
	        JSONArray ja_dataPerformance = jsonObject.getJSONArray("Performance");
	        JSONArray ja_dataHoldings = jsonObject.getJSONArray("Holdings");
	        JSONArray ja_dataReturn = jsonObject.getJSONArray("Returns");
	        JSONArray ja_dataAsset = jsonObject.getJSONArray("AssetChart");
	        JSONArray ja_dataSector = jsonObject.getJSONArray("SectorChart");
	        JSONArray ja_dataGeograph = jsonObject.getJSONArray("GeographChart");
	        JSONArray ja_dataPerCal = jsonObject.getJSONArray("PerformanceCalander");
	        
	        
	        

	     //   for (int i = 0; i < ja_dataPerformance.length(); i++) {

	            JSONObject rootObjProfile = ja_dataPerformance.getJSONObject(0);

	             p_sym = rootObjProfile.getString("symID");
	             p_inceptdate = rootObjProfile.getString("inceptionDate");
	             p_mer = rootObjProfile.getDouble("mer");
	             p_assets = rootObjProfile.getDouble("assets");
	             p_rank = rootObjProfile.getDouble("rank");
	             p_mstarrating= rootObjProfile.getDouble("mstarRating");
	             p_stddev = rootObjProfile.getDouble("stdDev");
	             p_volatilerank = rootObjProfile.getDouble("volatileRank");
	             p_mstarrisk = rootObjProfile.getDouble("mstarRisk");
	             p_alpha = rootObjProfile.getDouble("alpha");
	             p_beta = rootObjProfile.getDouble("beta");
	             p_rsquare = rootObjProfile.getDouble("rsquared");
	             p_rrspel = rootObjProfile.getString("rrspeligibility");
	             p_load = rootObjProfile.getString("load");
	             p_maxfrontend = rootObjProfile.getDouble("maxFrontEnd");
	             p_maxbackend = rootObjProfile.getDouble("maxBackEnd");
	             p_salesopen = rootObjProfile.getString("saleOpen");
	             p_navps = rootObjProfile.getDouble("navPS");
	             p_netasset = rootObjProfile.getDouble("netAsset");
	             p_yield = rootObjProfile.getDouble("yield");
	             p_dividend = rootObjProfile.getDouble("dividend");
	             p_manager = rootObjProfile.getString("managers");
	             p_Fees = rootObjProfile.getDouble("fees");
	             p_FullName = rootObjProfile.getString("fundName");
	             
	             
	             
	             
	             
	             JSONObject rootObjholding = ja_dataHoldings.getJSONObject(0);
	             
	             
	             h_FundSymID = rootObjholding.getString("FundSymID");
	             h_SymID = rootObjholding.getString("SymID");
	             h_Name = rootObjholding.getString("Name");
	             h_Asset = rootObjholding.getString("Asset");
	             h_Sector = rootObjholding.getString("Sector");
	             h_Geograph = rootObjholding.getString("Geograph");
	             h_Percent = rootObjholding.getDouble("Percentage");
	             
	             
	             JSONObject rootObjreturns = ja_dataReturn.getJSONObject(0);
	             
	             

	             
	             RReturns = rootObjreturns.getString("Return");
	             ROneMonth = rootObjreturns.getDouble("OneMonth");
	             RThreeMonth = rootObjreturns.getDouble("ThreeMonth");
	             RSixMonth = rootObjreturns.getDouble("SixMonth");
	             RYTD = rootObjreturns.getDouble("YTD");
	             ROneYear = rootObjreturns.getDouble("OneYear");
	             RThreeYear = rootObjreturns.getDouble("ThreeYear");
	             RFiveYear = rootObjreturns.getDouble("FiveYear");
	             RTenYear = rootObjreturns.getDouble("TenYear");
	             
	             
	             
	             
	             
	             JSONObject rootObjasset = ja_dataAsset.getJSONObject(0);

	             
	             
	             
	             AFund = rootObjasset.getString("Fund");
	             AAsset = rootObjasset.getString("Asset");
	             ACount = rootObjasset.getInt("Count");
	             APercent = rootObjasset.getInt("Percent");
	             
	             
	             
	             JSONObject rootObjsector = ja_dataSector.getJSONObject(0); 
	             
	             

	             SFund = rootObjsector.getString("Fund");
	             SSector = rootObjsector.getString("Sector");
	             SCount = rootObjsector.getInt("Count");
	             SPercent = rootObjsector.getInt("Percent");
	             
	             
	             JSONObject rootObjgeograph =  ja_dataGeograph.getJSONObject(0); 

	             GFund = rootObjgeograph.getString("Fund");
	             GGeograph = rootObjgeograph.getString("Geograph");
	             GCount = rootObjgeograph.getInt("Count");
	             GPercent = rootObjgeograph.getInt("Percent");
	             
	             
	             
	             JSONObject rootObjperfcal = ja_dataPerCal.getJSONObject(0);
	             
	             
	             PCDate = rootObjperfcal.getString("Date");
	             PCSymbol = rootObjperfcal.getString("Symbol");
	             PCNavPS = rootObjperfcal.getDouble("NavPS");
	             
	             
	             
	            
	             
	             
	             
	             
	             
	             
	        
	        
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
	        
	       
	        
	        model.addAttribute("p_symid",p_sym);
	        model.addAttribute("p_inceptdate",p_inceptdate);
	        model.addAttribute("p_mer",p_mer);
	        model.addAttribute("p_assets",p_assets);
	        model.addAttribute("p_rank",p_rank);
	        model.addAttribute("p_mstarrating",p_mstarrating);
	        model.addAttribute("p_stddev",p_stddev);
	        model.addAttribute("p_volatilerank",p_volatilerank);
	        model.addAttribute("p_mstarrisk",p_mstarrisk);
	        model.addAttribute("p_alpha",p_alpha);
	        model.addAttribute("p_beta",p_beta);
	        model.addAttribute("p_rrspel",p_rrspel);
	        model.addAttribute("p_load",p_load);
	        model.addAttribute("p_maxfrontend",p_maxfrontend);
	        model.addAttribute("p_maxbackend",p_maxbackend);
	        model.addAttribute("p_salesopen",p_salesopen);
	        model.addAttribute("p_navps",p_navps);
	        model.addAttribute("p_netasset",p_netasset);
	        model.addAttribute("p_yield",p_yield);
	        model.addAttribute("p_dividend",p_dividend);
	        model.addAttribute("p_manager",p_manager);
	        model.addAttribute("p_fees",p_Fees);
	        model.addAttribute("p_fullName",p_FullName);
	        
	        
	        model.addAttribute("h_fundsymid",h_FundSymID);
	        model.addAttribute("h_symid",h_SymID);
	        model.addAttribute("h_name",h_Name );
	        model.addAttribute("h_asset",h_Asset);
	        model.addAttribute("h_sector",h_Sector);
	        model.addAttribute("h_geograph",h_Geograph);
	        model.addAttribute("h_percent",h_Percent);
	        
	               
	        
	        
	        model.addAttribute("r_returns",RReturns);
	        model.addAttribute("r_onemonth",ROneMonth);
	        model.addAttribute("r_threemonth",RThreeMonth);
	        model.addAttribute("r_sixmonth",RSixMonth);
	        model.addAttribute("r_ytd",RYTD);
	        model.addAttribute("r_oneyear", ROneYear);
	        model.addAttribute("r_threeyear",RThreeYear);
	        model.addAttribute("r_fiveyear",RFiveYear);
	        model.addAttribute("r_tenyear",RTenYear);
	      
	        
	        model.addAttribute("sfund", SFund);
	        model.addAttribute("ssector",SSector);
	        model.addAttribute("scount",SCount);
	        model.addAttribute("spercent",SPercent);
	        
	       
	        model.addAttribute("afund", AFund);
	        model.addAttribute("aasset",AAsset);
	        model.addAttribute("acount",ACount);
	        model.addAttribute("apercent",APercent);
	        
	        model.addAttribute("gfund", GFund);
	        model.addAttribute("ggeograph",GGeograph);
	        model.addAttribute("gcount",GCount);
	        model.addAttribute("gpercent",GPercent);
	        
	        
	        
	      
	        
            model.addAttribute("perfJSON",strRisk);
            model.addAttribute("jsonHoldings",strHolding);
            model.addAttribute("jsonCalPerf",strCalPerf);
            model.addAttribute("jsonAnnualReturns",strReturn);
            
            
            
            
            
            
            
            String strChartHolding = thefund.getholdingsStr();
            String strChartCalPerf = thefund.getperfCalander();
            String strChartReturn =  thefund.getreturnsdataStr();
            
            String jsonHolding = "{\"Holdings\": [";	
            jsonHolding += strChartHolding + "]}";
            
            
            String jsonCalPerf = "{\"PerformanceCalander\": [";
            jsonCalPerf += strChartCalPerf + "]}";
            
            String jsonReturn = "{\"Returns\": [";
            jsonReturn += strChartReturn + "]}";
            
            
            model.addAttribute("jsonHoldings",jsonHolding);
            model.addAttribute("jsonCalPerf",jsonCalPerf);
            model.addAttribute("jsonAnnualReturns",jsonReturn);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
		return "Fundstats";

	}
	
	
	
	
	
	
	
}
	
	
	
	
	
