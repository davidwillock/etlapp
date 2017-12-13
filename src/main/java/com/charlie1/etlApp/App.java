package com.charlie1.etlApp;


//import java.util.ArrayList;
//import java.util.List;

import org.json.JSONObject;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.charlie1.controller.JSONArray;
import com.charlie1.etl.dao.FundsDAO;
import com.charlie1.etl.model.jPerformanceData;
import com.charlie1.etl.model.selectFundsAll;
import com.charlie1.etl.model.selectFundsByRisk;
import com.charlie1.etl.model.selectJournal;
import com.charlie1.etl.model.selectRisk;
import com.charlie1.etl.model.selectFundsByFund;
import com.charlie1.etl.model.selectTransactionData;
//import java.util.Date;

import com.charlie1.etlparser.parser;
import com.charlie1.etlparsefolders.*;
import com.charlie1.etlvalidatejournal.*;
import com.charlie1.simulate.*;
import com.charlie1.etl.model.selectCustomerData;


/**
 * Hello world!
 *
 */
public class App 
{
	
	

	 static String jsonStr;

	
	
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ////SQL_SERVER_HOSTNAME:1433/TESTDB?instance=TEST2012
 /*       
        String name = "{'risk1': '1', 'risk2': '4'}";
        
       
        String risk = "1";
        
        String cat="";
    	
    	if(risk == "1") {
    		
    		cat = "{'risk1':'1','risk2':'4'}";
    		
    	}else if(risk == "2"){
    		
    		cat = "{'risk1':'4','risk2':'8'}";
    		
    	}else if(risk == "3") {
    		
    		cat = "{'risk1':'8','risk2':'10'}";
    		
    		
    	}
   */     
    	
  //  	JSONObject jsonObj = new JSONObject(name);
  //      String risk1 = jsonObj.getString("risk1");
  //      String risk2 = jsonObj.getString("risk2");
        
        
 /*  
        String name = "{'Risk1': '1', 'Risk2': '4'}";
        
          
        
        JSONObject jsonObj = new JSONObject(name);
        String risk1 = jsonObj.getString("Risk1");
        String risk2 = jsonObj.getString("Risk2");
        selectFundsByRisk risk = new selectFundsByRisk(risk1,risk2);
        
        String strRisk = risk.getjsonStr();
     */
        
        
       // simulator sim = new simulator();
       // sim.createTransaction();
        
        
        
    /*    
        selectJournal journaldata = new selectJournal();
        validateJournal validatejrn = new validateJournal();
        selectJournal selectjournal = new selectJournal();
        
        String jsonStr = selectjournal.getjsonStr();
        
        App app = new App();
        app.setJsonStr(jsonStr);
        */
        
      //  String Static final journalDATAstr = app.getJsonStr();
        
        
        
        
        
     // Parse Unstructured Data   
       //File currentDirLOG = new File("C:\\home\\charlie\\Custjrn");
        
        //**File currentDirLOG = new File("C:\\home\\charlie\\Custjrn");
        parseFolders source = new parseFolders();
        //source.displayDirectoryContents(currentDirLOG);
        
      
      //***  Parse Structured Data
      //  File currentDirCSV = new File("C:\\home\\charlie\\Journaljrn");
      //  source.displayDirectoryContents(currentDirCSV);
        
     
        // Simulation Stuff**********************
        
        
        // Create Simulator Transactions
        //File currentDirSim = new File("C:\\home\\charlie\\Journaljrn");
        //source.createDirectoryContents(currentDirSim,80,60,"2002-01-01","09:00");
      
        
       // Create Random Folders  
       //**simulator sim = new simulator(); 
       //sim.setCreatefolders(70);
       //sim.createRandomFolders();
       
       
       
       parser test = new parser();
       
       /*  Get Customer Data        */
       
       
       
       selectCustomerData selectcustomerdata = new selectCustomerData();
      // selectcustomerdata.getCustomers();
      // String customerstr = selectcustomerdata.getjsonStr();
       selectTransactionData selectransactiondata = new selectTransactionData();
       selectransactiondata.getTrans();
         
         
         
       
       
//       test.parseCashUptime("", "", "");
       
       
       
       
       /*
        disabled last
    
        String fundtmp = "{'Fund': 'PGMIX'}";
        
        try {
        JSONObject jsonObj = new JSONObject(fundtmp);
        String fund = jsonObj.getString("Fund");
       // 	String fund = "PGMIX";
        selectFundsByFund thefund = new selectFundsByFund(fund);
        
        String strRisk = thefund.getjsonStr();
        System.out.println(strRisk);
        
        } catch(JSONException e){
        	
        	throw new RuntimeException(e);
        	
        	
        }
        
        parser getR = new parser();
        getR.rUtility();
        System.out.println("Complete");
       */
        /*
        String dummy ="";
        
       
     
        try {
        	
        	
        	
        
        
        
        JSONObject jsonObject = new JSONObject(strRisk);
        
        
        JSONArray ja_dataPerformance = jsonObject.getJSONArray("PerformanceCalander");
        
        JSONArray ja_dataHoldings = jsonObject.getJSONArray("Holdings");
        
   
        
       // return "{Fund:" + Fund + ", Asset:" + Asset + ", Count:" + Count + ", Percent:" + Percent + "}";


     //   for (int i = 0; i < ja_dataPerformance.length(); i++) {
          
          
    //	return "{Symbol:" + Symbol + ", Date:" + Date + ", NavPS:" + NavPS + "}";
        
        
        
        JSONObject rootObjholding = ja_dataHoldings.getJSONObject(0);
        
        
        
        String h_FundSymID="";
        String h_SymID = "";
        String h_Name = "";
        String h_Asset = "";
        String h_Sector = "";
        String h_Geograph = "";
        double h_Percent = 0;
        
        
        
        h_FundSymID = rootObjholding.getString("FundSymID");
        h_SymID = rootObjholding.getString("SymID");
        h_Name = rootObjholding.getString("Name");
        h_Asset = rootObjholding.getString("Asset");
        h_Sector = rootObjholding.getString("Sector");
        h_Geograph = rootObjholding.getString("Geograph");
        h_Percent = rootObjholding.getDouble("Percentage");
        
        
        
        
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
        
        
        JSONArray ja_dataPerformance_ = jsonObject.getJSONArray("Performance");
        
        JSONObject rootObjProfile = ja_dataPerformance_.getJSONObject(0);

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
        
        
        
        
        
        
        
        
        
        
    
        
          JSONObject rootObj = ja_dataPerformance.getJSONObject(0);
         
          String PCDate = rootObj.getString("Date");
          String PCSymbol = rootObj.getString("Symbol");
          Double PCNavPS = rootObj.getDouble("NavPS");
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          

          String GFund = rootObj.getString("Fund");
          String GGeograph = rootObj.getString("Geograph");
          int GCount = rootObj.getInt("Count");
          int GPercent = rootObj.getInt("Percent");
          
          
          
          
 
          
          
          String SFund = rootObj.getString("Fund");
          String SSector = rootObj.getString("Sector");
          int SCount = rootObj.getInt("Count");
          int SPercent = rootObj.getInt("Percent");
          
          
          
          
          
          
          
          
          
          
          
          String AFund = rootObj.getString("Fund");
          String AAsset = rootObj.getString("Asset");
          int ACount = rootObj.getInt("Count");
          int APercent = rootObj.getInt("Percent");
          
          
          
           
       
          String RReturns = rootObj.getString("Return");
          Double ROneMonth = rootObj.getDouble("OneMonth");
          Double RThreeMonth = rootObj.getDouble("ThreeMonth");
          Double RSixMonth = rootObj.getDouble("SixMonth");
          Double RYTD = rootObj.getDouble("YTD");
          Double ROneYear = rootObj.getDouble("OneYear");
          Double RThreeYear = rootObj.getDouble("ThreeYear");
          Double RFiveYear = rootObj.getDouble("FiveYear");
          Double RTenYear = rootObj.getDouble("TenYear");
          
          
          
                
          String HFundSymID = rootObj.getString("FundSymID");
          String HSymID = rootObj.getString("SymID");
          String HName = rootObj.getString("Name");
          String HAsset = rootObj.getString("Asset");
          String HSector = rootObj.getString("Sector");
          String HGeograph = rootObj.getString("Geograph");
          Double HPercent = rootObj.getDouble("Percentage");
          
          
          
           

            String sym = rootObj.getString("symID");
            String inceptdate = rootObj.getString("inceptionDate");
            double mer = rootObj.getDouble("mer");
            double assets = rootObj.getDouble("assets");
            double rank = rootObj.getDouble("rank");
            double mstarrating= rootObj.getDouble("mstarRating");
            double stddev = rootObj.getDouble("stdDev");
            double volatilerank = rootObj.getDouble("volatileRank");
            double mstarrisk = rootObj.getDouble("mstarRisk");
            double alpha = rootObj.getDouble("alpha");
            double beta = rootObj.getDouble("beta");
            double rsquare = rootObj.getDouble("rsquared");
            String rrspel = rootObj.getString("rrspeligibility");
            String load = rootObj.getString("load");
            double maxfrontend = rootObj.getDouble("maxFrontEnd");
            double maxbackend = rootObj.getDouble("maxBackEnd");
            String salesopen = rootObj.getString("saleOpen");
            double navps = rootObj.getDouble("navPS");
            double netasset = rootObj.getDouble("netAsset");
            double yield = rootObj.getDouble("yield");
            double dividend = rootObj.getDouble("dividend");
            String manager = rootObj.getString("managers");
            double Fees = rootObj.getDouble("fees");
            String FullName = rootObj.getString("fundName");

        
    
        } catch(Exception ex) {
        	
        	
        	
        	ex.printStackTrace();
        	
        	
        }
        
      */
     /*   
        
 //   String test = "{ Performance : {SymID :BTTRX, InceptionDate : 1998-02-15, MER=1.6, Assets=247.0, Rank=1.0, MstarRating=5.0, StdDev=16.0, VolatileRank=2.0, MstarRisk=3.0, Alpha=0.0, Beta=0.0, Rsquared=0.0, RRSPEligibility=yes, Load=no load, MaxBackEnd=0.0, MaxFrontEnd=0.0, SaleOpen=open, NavPS=99.0, NetAsset=0.0, Yield=4.2, Dividend=2.0, Managers=Robert Gahagan, Fees=0.7, FundName=American Century Zero Coupon 2025 Inv]}";

    
   		  		
    		//,[SymID=BTTRX, InceptionDate=1998-02-15, MER=1.6, Assets=247.0, Rank=1.0, MstarRating=5.0, StdDev=16.0, VolatileRank=2.0, MstarRisk=3.0, Alpha=0.0, Beta=0.0, Rsquared=0.0, RRSPEligibility=yes, Load=no load, MaxBackEnd=0.0, MaxFrontEnd=0.0, SaleOpen=open, NavPS=99.0, NetAsset=0.0, Yield=4.2, Dividend=2.0, Managers=Robert Gahagan, Fees=0.7, FundName=American Century Zero Coupon 2025 Inv]"
    		//,[SymID=PLGBX, InceptionDate=1978-07-15, MER=1.2, Assets=247.0, Rank=5.0, MstarRating=2.0, StdDev=16.0, VolatileRank=2.0, MstarRisk=3.0, Alpha=0.0, Beta=0.0, Rsquared=0.0, RRSPEligibility=yes, Load=no load, MaxBackEnd=0.0, MaxFrontEnd=0.0, SaleOpen=open, NavPS=29.0, NetAsset=0.0, Yield=1.0, Dividend=2.0, Managers=William A. Coleman, Fees=0.45, FundName=Vanguard Balanced Index Inv]]}";
        
//    String foo = "{foundation: 'Mozilla', model: 'box', week: 45, transport: 'car', month: 7}";
   // JSONObject jsonObjs = new JSONObject(foo);  
        
        
        
            
        JSONObject jsonObj = new JSONObject(cat);
        String risk1 = jsonObj.getString("risk1");
        String risk2 = jsonObj.getString("risk2");
        
        selectRisk selectrisk = new selectRisk(risk1,risk2);
        
	     String strRisk = selectrisk.getjsonStr();
	        
		
	        String sym ="";
		    String jsonstr="";
		    String jsonpre="";
		    String jsonpost="";
	        
	    
	        jsonpre = "{'symid':'";
	        jsonpost = "'},";
	        
	        try {
	        
	        JSONObject jsonObject = new JSONObject(strRisk);
	        
	        
	        JSONArray ja_dataPerformance = jsonObject.getJSONArray("Performance");




	      //  for (int i = 0; i < ja_dataPerformance.length(); i++) {

	            JSONObject rootObj = ja_dataPerformance.getJSONObject(0);

	            sym = rootObj.getString("SymID");
	            
	            jsonstr += jsonpre;
	            jsonstr += sym;
	            jsonstr += jsonpost; 
	            
	            
	     //   }  
	            
	            
	            if(!jsonstr.equals("")) {
	            	

	   		        StringBuilder sb = new StringBuilder(jsonstr);
	              	sb.deleteCharAt(jsonstr.length()-1);
	               	jsonstr = sb.toString();
	   		        	
	            	
	            }
	            
	             
	             
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
		
		
        */
        
        
/*
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
        
      */
        
        /*
       
        
        
        
        
    	String sym ="";
	    String fundname ="";
	    String jsonstr="";
	    String jsonsim="";
	    String jsonname="";
	    String jsonpost="";
	    String jsoncomma="";
        
	    
	    
	  
	    

		JSONObject jsonObj = new JSONObject(cat);
        String risk1 = jsonObj.getString("risk1");
        String risk2 = jsonObj.getString("risk2");
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
        
        
        
    	
    	
    	
   */ 	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
           
        
          
    
    }
    
    
        
        
	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

        
        
        
        
       
        
             
        
        
    
}
