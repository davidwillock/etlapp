package com.charlie1.etl.model;


import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;



public class selectFundsByFund {
	
	

	private String jsonstr="";
	private String fund;
	private String HoldingsData="";
	private String PerformanceDataCalander="";
	private String ReturnsData="";
	

	
	
	
	public selectFundsByFund(String fund) {
		
		this.fund = fund;
		
		
		getFunds();
	}
	
		
	
	public String getjsonStr() {
		
		return jsonstr;
	}


	
	public String getholdingsStr() {
		
		return HoldingsData;
	}
	
	public String getperfCalander() {
		
		
		return PerformanceDataCalander;
	}
	
	public String getreturnsdataStr() {
		
		
		return ReturnsData;
	}
	


	private void getFunds() {
		
		
		
		
		
		
    	 String str="";
    	 
    	 ApplicationContext context = 
         		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
    	 
    	 FundsDAO customerDAO = (FundsDAO) context.getBean("FundsDAO");
         str =  customerDAO.buildStrPeformanceDataByFund(fund);
		
	
		
		
		
		
		
		
		 ReturnsData = customerDAO.buildStrReturnsDataByFund(fund);


	       
	        if (ReturnsData.equals(""))
	        {

	            ReturnsData = "{\"Return\": \"-\",\"OneMonth\" : \"0\",\"ThreeMonth\": \"0\", \"SixMonth\": \"0\",\"YTD\": \"0\",\"OneYear\": \"0\",\"ThreeYear\" : \"0\",\"FiveYear\" : \"0\",\"TenYear\" : \"0\"}";

	        }
	        else
	        {
	        	
	        	StringBuilder sb = new StringBuilder(ReturnsData);
	        	sb.deleteCharAt(ReturnsData.length()-1);
	            ReturnsData = sb.toString();
	        }

	        HoldingsData = customerDAO.buildStrHoldingsDataByFund(fund);
	        if (HoldingsData.equals(""))
	        {

	           

	            HoldingsData = "{\"FundSymID\": \"-\",\"SymID\" : \"-\",\"Name\": \"-\", \"Asset\": \"-\",\"Sector\": \"-\" ,\"Geograph\": \"-\",\"Percentage\": \"0\"}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(HoldingsData);
	        	sb.deleteCharAt(HoldingsData.length()-1);
	            HoldingsData = sb.toString();
	        }


	        String PerformanceData = customerDAO.buildStrPeformanceDataByFund(fund);
	        if (PerformanceData.equals(""))
	        {


	            


	            

	            PerformanceData = "{\"symbol\": \"-\",\"InceptionDate\" : \"2001-01-01\",\"Mer\": \"0\", \"Asset\": \"0\",\"Rank\": \"0\" ,\"MstarRating\": \"0\",\"StdDev\": \"0\",\"VolatileRank\": \"0\",\"Alpha\": \"0\",\"Beta\": \"0\",\"Rsquare\": \"0\",\"RRSPEligibility\": \"-\",\"Load\": \"-\",\"MaxFrontEnd\": \"0\",\"MaxBackEnd\": \"0\",\"SalesOpen\": \"-\",\"NavPs\": \"0\",\"NetAsset\": \"0\",\"Yield\": \"0\",D\"ividend\": \"0\",\"Managers\": \"0\",\"Fees\": \"0\",\"FundName\": \"0\"}";

	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(PerformanceData);
	        	sb.deleteCharAt(PerformanceData.length()-1);
	        	PerformanceData = sb.toString();
	        }





	        String SymbolsData = customerDAO.buildStrHistoricalDataByFund(fund);

	        if (SymbolsData.equals(""))
	        {


	           
	            SymbolsData = "{\"symbol\": \"-\",\"epoch\" : \"-\",\"open\": \"-\", \"high\": \"-\",\"low\": \"-\" ,\"close\": \"-\",\"close_adj\": \"0\",\"volume\": \"0\"}";

	        

	        }
	        else
	        {
	        	
	        	StringBuilder sb = new StringBuilder(SymbolsData);
	        	sb.deleteCharAt(SymbolsData.length()-1);
	        	SymbolsData = sb.toString();
	        }


	        PerformanceDataCalander =  customerDAO.buildStrPerformanceCalanderByFund(fund);

	        if (PerformanceDataCalander.equals(""))
	        {



	            PerformanceDataCalander = "{\"Date\": \"-\",\"Symbol\" : \"-\",\"NavPS\": \"-\"}";



	        }
	        else
	        {
	        	StringBuilder sb = new StringBuilder(PerformanceDataCalander);
	        	sb.deleteCharAt(PerformanceDataCalander.length()-1);
	        	PerformanceDataCalander = sb.toString();
	        }


	        String PerformanceIDXCalander = customerDAO.buildStrIDX();

	        if (PerformanceIDXCalander.equals(""))
	        {



	            PerformanceIDXCalander = "{\"Date\": \"-\",\"Symbol\" : \"-\",\"NavPS\": \"-\"}";



	        }
	        else
	        {
	        	
	        	StringBuilder sb = new StringBuilder(PerformanceIDXCalander);
	        	sb.deleteCharAt(PerformanceIDXCalander.length()-1);
	        	PerformanceIDXCalander = sb.toString();
	        }


	        String SpinnerIdx = customerDAO.buildStrIDXSpinner();

	        if (SpinnerIdx.equals(""))
	        {



	            SpinnerIdx = "{\"Symbol\": \"-\",\"FullName\" : \"-\"}";



	        }
	        else
	        {
	        	
	        	StringBuilder sb = new StringBuilder(SpinnerIdx);
	        	sb.deleteCharAt(SpinnerIdx.length()-1);
	            SpinnerIdx = sb.toString();
	        }


	        Iterator<String> data = customerDAO.getFundsbyFund(fund);
	        String SectorData = "";
	        String AssetData = "";
	        String GeographData = ""; 
	       
	        
	        
	        while(data.hasNext()) {
	        	
	        	
	        	String fund = (String)data.next();
	        	
	        	
	        	
	            String Sector = customerDAO.buildStrChartSector(fund);
	            if (Sector.equals(""))
	            {

	                Sector = "{\"Fund\": \"-\",\"Sector\" : \"-\",\"Count\": \"0\", \"Percent\": \"0\"}";

	            }
	            else
	            {
	            	StringBuilder sb = new StringBuilder();
	            	sb.deleteCharAt(Sector.length()-1);
	            	Sector = sb.toString();
	            }





	            String Asset = customerDAO.buildStrChartAsset(fund);

	            if (Asset.equals(""))
	            {

	                Asset = "{\"Fund\": \"-\",\"Asset\" : \"-\",\"Count\": \"0\", \"Percent\": \"0\"}";

	            }
	            else
	            {
	            	StringBuilder sb = new StringBuilder(Asset);
	            	sb.deleteCharAt(Asset.length()-1);
	            	Asset = sb.toString();

	            }
	            String Geograph = customerDAO.buildStrChartGeograph(fund);

	            if (Geograph.equals(""))
	            {

	                Geograph = "{\"Fund\": \"-\",\"Geograph\" : \"-\",\"Count\": \"0\", \"Percent\": \"0\"}";

	            }
	            else
	            {
	            	StringBuilder sb = new StringBuilder(Geograph);
	            	sb.deleteCharAt(Geograph.length()-1);
	                Geograph = sb.toString();

	            }


	            SectorData += Sector+ ",";
	            AssetData += Asset +",";
	            GeographData +=Geograph+ ",";

	        }


	        String sectorlastchar = SectorData.substring(SectorData.length() - 1);

	        if (sectorlastchar.equals(","))
	        {

	        	StringBuilder sb = new StringBuilder(SectorData);
	        	sb.deleteCharAt(SectorData.length()-1);
	            SectorData = sb.toString();

	        }

	        String assetlastchar = AssetData.substring(AssetData.length() - 1);

	        if (assetlastchar.equals(","))
	        {

	        	StringBuilder sb  = new StringBuilder(AssetData);
	        	sb.deleteCharAt(AssetData.length()-1);
	            AssetData = sb.toString();

	        }

	        String geographlastchar = GeographData.substring(GeographData.length() - 1);

	        if (geographlastchar.equals(","))
	        {

	        	StringBuilder sb = new StringBuilder(GeographData);
	        	sb.deleteCharAt(GeographData.length()-1);
	        	GeographData = sb.toString();

	        }








/*


	//        jsonstr = "{Returns : [";
	//        jsonstr += ReturnsData;
	//        jsonstr += "],";
	//        jsonstr += "Holdings: [";
	//        jsonstr += HoldingsData + "],";
	        jsonstr += "{\"Performance\": [";
	        jsonstr += PerformanceData + "]}";
	//        jsonstr += PerformanceData + "],";
	//        jsonstr += "Symbols: [";
	//        jsonstr += SymbolsData + "],";
	//        jsonstr += "AssetChart: [";
	//        jsonstr += AssetData + "],";
	//        jsonstr += "SectorChart: [";
	//        jsonstr += SectorData + "],";
	//        jsonstr += "GeographChart: [";
	//        jsonstr += GeographData + "],";                                
	//        jsonstr += "PerformanceCalander: [";
	//        jsonstr += PerformanceDataCalander +"],";
	//        jsonstr += "PerformanceCalanderIDX: [";
	//        jsonstr += PerformanceIDXCalander + "],";
	//        jsonstr += "SpinnerIDX: [";
	//        jsonstr += SpinnerIdx + "]}";

*/	
		
	        
	        
 	        jsonstr += "{\"Returns\": [";
	        jsonstr += ReturnsData + "],";
	        jsonstr += "\"Holdings\": [";	
	        jsonstr += HoldingsData + "],";
	        jsonstr += "\"Performance\": [";
	        jsonstr += PerformanceData + "],";
	        
	        
	        
	//        jsonstr += "{\"Symbols\": [";
	//        jsonstr += SymbolsData + "]}";
	        
	        jsonstr += "\"AssetChart\": [";
	        jsonstr += AssetData + "],";		
	        jsonstr += "\"SectorChart\": [";
	        jsonstr += SectorData + "],";
	        jsonstr += "\"GeographChart\": [";
	        jsonstr += GeographData + "],";
	        jsonstr += "\"PerformanceCalander\": [";
	        jsonstr += PerformanceDataCalander + "],";
	        jsonstr += "\"PerformanceCalanderIDX\": [";
	        jsonstr += PerformanceIDXCalander + "]}";
	        
	        /************************************************************/
	        
//	        jsonstr = "{Returns : [";
	    	//        jsonstr += ReturnsData;
	    	//        jsonstr += "],";
	    	//        jsonstr += "Holdings: [";
	    	//        jsonstr += HoldingsData + "],";
	 //   	        jsonstr += "{\"Performance\": [";
	 //   	        jsonstr += PerformanceData + "]}";
	    	//        jsonstr += PerformanceData + "],";
	    	//        jsonstr += "Symbols: [";
	    	//        jsonstr += SymbolsData + "],";
	    	//        jsonstr += "AssetChart: [";
	    	//        jsonstr += AssetData + "],";
	    	//        jsonstr += "SectorChart: [";
	    	//        jsonstr += SectorData + "],";
	    	//        jsonstr += "GeographChart: [";
	    	//        jsonstr += GeographData + "],";                                
	    	//        jsonstr += "PerformanceCalander: [";
	    	//        jsonstr += PerformanceDataCalander +"],";
	    	//        jsonstr += "PerformanceCalanderIDX: [";
	    	//        jsonstr += PerformanceIDXCalander + "],";
	    	//        jsonstr += "SpinnerIDX: [";
	    	//        jsonstr += SpinnerIdx + "]}";
	        
	        
	      //  System.out.println(jsonstr);
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
		
	}
	

	

}
