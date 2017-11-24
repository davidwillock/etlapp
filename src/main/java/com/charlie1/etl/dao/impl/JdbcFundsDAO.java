package com.charlie1.etl.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.charlie1.etl.dao.FundsDAO;
import com.charlie1.etl.model.jPerformanceData;
import com.charlie1.etl.model.jHoldings;
import com.charlie1.etl.model.jPerformanceReturns;
import com.charlie1.etl.model.jPerformanceData;
import com.charlie1.etl.model.jHDstats;
import com.charlie1.etl.model.jChartAsset;
import com.charlie1.etl.model.jChartSector;
import com.charlie1.etl.model.jChartGeography;
import com.charlie1.etl.model.jPerfCalender;
import com.charlie1.etl.model.jIndexes;


import com.charlie1.etl.model.journalData;
import com.charlie1.etl.model.journalLookup;








public class JdbcFundsDAO extends JdbcDaoSupport implements FundsDAO
{

	
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	

	public String buildStrPeformanceData(String risk1, String risk2){
		
		
	//	SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		
		 String jsonstr = "";
		
		 String performancestr = "select P.SymID,P.InceptionDate_,P.MER_,P.Assets_,P.Rank_,P.MstarRating_,P.StdDev_,P.VolatileRank_," +
	               "P.MstarRisk_,P.Alpha_,P.Beta_,P.Rsquared_,P.RRSPEligibility_,P.Load_,P.MaxFrontEnd_,P.MaxBackEnd_,P.SaleOpen_,P.NavPS_," +
	               "P.NetAsset_,P.Yield_,P.Dividend_,P.Managers_,P.Fees_,P.FundName_" +
	               " from PerformanceData P where  P.volatilerank_ >= '" + risk1 + "' and P.volatilerank_ <= '" + risk2 + "'";

		 jPerformanceData jperform = new jPerformanceData();
	
	
		 
 List<String> data = getJdbcTemplate().query(performancestr, new RowMapper<String>(){
			 
			 String jsonstr = "";
             public String mapRow(ResultSet rs, int rowNum) 
                                          throws SQLException {
            	 
            	   
            	              
                     
                    jperform.setInceptionDate(rs.getDate("InceptionDate_"));
                    jperform.setAlpha(rs.getDouble("Alpha_"));
         			jperform.setAssets(rs.getDouble("Assets_"));
         			jperform.setBeta(rs.getDouble("Beta_"));
         			jperform.setDividend(rs.getDouble("Dividend_"));
         			jperform.setFees(rs.getDouble("Fees_"));
         			jperform.setFundName(rs.getString("FundName_"));
         			jperform.setLoad(rs.getString("Load_"));
         			jperform.setManagers(rs.getString("Managers_"));
         			jperform.setMaxBackEnd(rs.getDouble("MaxBackEnd_"));
         			jperform.setMER(rs.getDouble("MER_"));
         			jperform.setMstarRating(rs.getDouble("MstarRating_"));
         			jperform.setMstarRisk(rs.getDouble("MstarRisk_"));
         			jperform.setNavPS(rs.getDouble("NavPS_"));
         			jperform.setRank(rs.getDouble("Rank_"));
         			jperform.setRRSPEligibility(rs.getString("RRSPEligibility_"));
         			jperform.setRsquared(rs.getDouble("Rsquared_"));
         			jperform.setSaleOpen(rs.getString("SaleOpen_"));
         			jperform.setStdDev(rs.getDouble("StdDev_"));
         			jperform.setSymID(rs.getString("SymID"));
         			jperform.setVolatileRank(rs.getDouble("VolatileRank_"));
         			jperform.setYield(rs.getDouble("Yield_"));
                     
                 
                     
                     jsonstr += jperform.toString();
                     jsonstr += ",";
                     
                     
                     return jsonstr;
                     
                     
                     
             }
             
        });
			
			
		Iterator itemIterator = data.iterator();
				
		while(itemIterator.hasNext()){
			
			jsonstr+= (String)itemIterator.next();
			
		}
		 
		 
		return jsonstr;
		
		
	}
	

	public String buildStrHoldingsData(String risk1, String risk2) {
		
		
		
		 String jsonstr = "";
		
		 String holdingstr = "select h.FundSymID,h.symid,h.name,aa.asset,sa.sector,ga.geograph,h.percentage from holdings H left join AssetAllocation AA on H.assetid = AA.assetid left join SectorAllocation SA on H.sectorid = SA.sectorid left join GeographAllocation GA on H.geographid = GA.geographid left join PerformanceData P on H.FundSymID = P.SymID where P.volatilerank_ >= '" + risk1 + "' and P.volatilerank_ <= '" + risk2 + "'";
	
	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(holdingstr);
		for (Map<String,Object> row : rows) {
			jHoldings holdings = new jHoldings();
			
			holdings.setFundSymID((String)row.get("FundSymID"));
			holdings.setSymID((String)row.get("symid"));
			holdings.setName((String)row.get("name"));
			holdings.setAsset((String)row.get("asset"));
			holdings.setSector((String)row.get("sector"));
			holdings.setGeograph((String)row.get("geograph"));
			holdings.setPercentage((Double)row.get("percentage"));
		
					
			
			
			
			jsonstr += holdings.toString();
            jsonstr += ",";

			
			
		}
		
		return jsonstr;
		
		
	}
	
	public String buildStrReturnsData(String risk1, String risk2) {
		
		
		
		 String jsonstr = "";
		
		 String returnstr = "select PDR.return_,PDR.OneMonth,PDR.ThreeMonth,PDR.SixMonth,PDR.YTD,PDR.OneYear,PDR.ThreeYear,PDR.FiveYear,PDR.TenYear from PerformanceDataReturn PDR left join PerformanceData P on PDR.return_ = P.SymID where P.volatilerank_ >= '"+ risk1 +"' and P.volatilerank_ <= '"+risk2+"'";


	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(returnstr);
		for (Map<String,Object> row : rows) {
			jPerformanceReturns returns = new jPerformanceReturns();
			
			returns.setReturn((String)row.get("Return_"));
			returns.setOneMonth((Double)row.get("OneMonth"));
			returns.setThreeMonth((Double)row.get("ThreeMonth"));
			returns.setSixMonth((Double)row.get("SixMonth"));
			returns.setYTD((Double)row.get("YTD"));
			returns.setOneYear((Double)row.get("OneYear"));
			returns.setThreeYear((Double)row.get("ThreeYear"));
			returns.setFiveYear((Double)row.get("FiveYear"));
			returns.setTenYear((Double)row.get("TenYear"));
		
					
			
			
			
			jsonstr += returns.toString();
           jsonstr += ",";

			
			
		}
		
		return jsonstr;
		
		
	}
	
	
	 public String buildStrHistoricalData(String risk1, String risk2){
		
		 
		 
		
		 
		 jHDstats stats = new jHDstats();
		 
		 String jsonstr = "";
			
		 String symbolstr = "select S.symbol_,S.Epoch_,S.Open_,S.High_,S.Low_ ,S.Close_,S.Close_Adj,S.Volume_  from PerformanceData P " +
		            "left join Symbols S on substring(s.symbol_, 1, LEN(S.symbol_) - 2) = P.SymID where P.volatilerank_ >= '" + risk1 + "' and P.volatilerank_ <= '" + risk2 + "' and symbol_ != ''";

		 List<String> data = getJdbcTemplate().query(symbolstr, new RowMapper<String>(){
			 
			 String jsonstr = "";
             public String mapRow(ResultSet rs, int rowNum) 
                                          throws SQLException {
            	 
            	   
            	     stats.setSymbol(rs.getString("symbol_"));
            	    
                     stats.setEpoch(rs.getDate("epoch_"));
                     stats.setOpen(rs.getDouble("open_"));
                     stats.setHigh(rs.getDouble("high_"));
                     stats.setLow(rs.getDouble("low_"));
                     stats.setClose(rs.getDouble("close_"));
                     stats.setClose_adj(rs.getDouble("close_adj"));
                     stats.setVolume(rs.getDouble("volume_"));
                     
                     
                     
                     
                     jsonstr += stats.toString();
                     jsonstr += ",";
                     
                     
                     return jsonstr;
                     
                     
                     
             }
             
        });
			
			
		Iterator itemIterator = data.iterator();
				
		while(itemIterator.hasNext()){
			
			jsonstr+= (String)itemIterator.next();
			
		}
		
		
			
		return jsonstr;
		
		
	}
	
	public String buildStrChartSector(String fund){
			
			
			
		 String jsonstr = "";
		
		 String query = "select SA.Sector, count(H.sectorID) as count, (100 * count(*) / (select count(*)   from holdings where fundsymid = '" + fund + "'))  as [Percent] from holdings H left join SectorAllocation SA on H.sectorid = SA.sectorid where fundsymid = '" + fund + "' group by SA.sector";


	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(query);
		for (Map<String,Object> row : rows) {
			jChartSector funds = new jChartSector();
			
			funds.setFund((String)fund);
			funds.setSector((String)row.get("Sector"));
			funds.setCount((int)row.get("Count"));
			funds.setPercent((int)row.get("Percent"));
			
					
			
			
			
			jsonstr += funds.toString();
          jsonstr += ",";

			
			
		}
		
		return jsonstr;
		
		
	}
	
	
	public String buildStrChartAsset(String fund){
			
			
			
		 String jsonstr = "";
		
		   String query = "select AA.Asset, count(H.sectorID) as count, (100 * count(*) / (select count(*)   from holdings where fundsymid = '" + fund + "'))  as [Percent] from holdings H left join AssetAllocation AA on H.assetid = AA.assetid where fundsymid = '" + fund + "' group by AA.Asset";



	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(query);
		for (Map<String,Object> row : rows) {
			jChartSector funds = new jChartSector();
			
			funds.setFund((String)fund);
			funds.setSector((String)row.get("Asset"));
			funds.setCount((int)row.get("Count"));
			funds.setPercent((int)row.get("Percent"));
			
					
			
			
			
			jsonstr += funds.toString();
          jsonstr += ",";

			
			
		}
		
		return jsonstr;
		
		
	}
	
	 
	public String buildStrChartGeograph(String fund){
		
			
			
		 String jsonstr = "";
		
		 String query = "select GA.Geograph, count(H.sectorID) as count, (100 * count(*) / (select count(*)   from holdings where fundsymid = '" + fund + "'))  as [Percent] from holdings H left join GeographAllocation GA on H.Geographid = GA.Geographid where fundsymid = '" + fund + "' group by GA.Geograph";


	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(query);
		for (Map<String,Object> row : rows) {
			jChartSector funds = new jChartSector();
			
			funds.setFund((String)fund);
			funds.setSector((String)row.get("Geograph"));
			funds.setCount((int)row.get("Count"));
			funds.setPercent((int)row.get("Percent"));
			
					
			
			
			
			jsonstr += funds.toString();
          jsonstr += ",";

			
			
		}
		
		return jsonstr;
		
		
	}
	
	public  String buildStrPerformanceCalander(String risk1, String risk2) {		
			
			
		 String jsonstr = "";

		
		 String query = "select c.Year_,c.Symbol_,c.NavPS_ from PerformanceCalander c left join performancedata d on c.symbol_ = d.symid where d.volatilerank_ >='" + risk1 +"' and d.volatilerank_ <= '"+risk2+"'";
		 jPerfCalender cal = new jPerfCalender();


		 
		 
		 
		 
			
		 List<String> data = getJdbcTemplate().query(query, new RowMapper<String>(){
			 
			 String jsonstr = "";
             public String mapRow(ResultSet rs, int rowNum) 
                                          throws SQLException {
            	 
            	   
            	     cal.setDate(rs.getDate("Year_"));
            	     cal.setSymbol(rs.getString("Symbol_"));
                     cal.setNavPS(rs.getDouble("NavPS_"));
                 
                     
                     
                     
                     
                     jsonstr += cal.toString();
                     jsonstr += ",";
                     
                     
                     return jsonstr;
                     
                     
                     
             }
             
        });
			
			
		Iterator itemIterator = data.iterator();
				
		while(itemIterator.hasNext()){
			
			jsonstr+= (String)itemIterator.next();
			
		}
		
		 
		return jsonstr;
		
		
	}
	  
	 
	  
public Iterator getFundsbyRisk(String risk1, String risk2)
	    {
		
	
			ArrayList<String> jlist = new ArrayList<String>();
		
			
			
			 String jsonstr = "";
			 String buildstr = "";
			
			 String performancestr = "select P.SymID,P.InceptionDate_,P.MER_,P.Assets_,P.Rank_,P.MstarRating_,P.StdDev_,P.VolatileRank_," +
		               "P.MstarRisk_,P.Alpha_,P.Beta_,P.Rsquared_,P.RRSPEligibility_,P.Load_,P.MaxFrontEnd_,P.MaxBackEnd_,P.SaleOpen_,P.NavPS_," +
		               "P.NetAsset_,P.Yield_,P.Dividend_,P.Managers_,P.Fees_,P.FundName_" +
		               " from PerformanceData P where  P.volatilerank_ >= '" + risk1 + "' and P.volatilerank_ <= '" + risk2 + "'";





		
			 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(performancestr);
			for (Map<String,Object> row : rows) {
				jPerformanceData data = new jPerformanceData();
				
				
			
				data.setSymID((String)row.get("SymID"));
				
				   buildstr+= data + " ";
				   jlist.add(buildstr);

                   

				
				
				
			
	        
				
				
			}
			
			
			//jPerformDataEnum jdata = new jPerformDataEnum(buildstr, new Char[] {' ',','}); 
			
			Iterator<String> forList =  jlist.iterator();
			
			
			
			
			
			return forList;
			
			
		}
		  
	  
	  
	  
public	  String buildStrIDX() {
		
			
			
	 		String jsonstr = "";
			String symbolstr = "select * from  PerformanceCalander where symbol_ like '^%'";
			jPerfCalender cal = new jPerfCalender();

			
			
			 List<String> data = getJdbcTemplate().query(symbolstr, new RowMapper<String>(){
				 
				 String jsonstr = "";
	             public String mapRow(ResultSet rs, int rowNum) 
	                                          throws SQLException {
	            	 
	            	   
	            	     cal.setDate(rs.getDate("Year_"));
	            	     cal.setSymbol(rs.getString("Symbol_"));
	                     cal.setNavPS(rs.getDouble("NavPS_"));
	                 
	                     
	                     
	                     
	                     
	                     jsonstr += cal.toString();
	                     jsonstr += ",";
	                     
	                     
	                     return jsonstr;
	                     
	                     
	                     
	             }
	             
	        });
				
				
			Iterator itemIterator = data.iterator();
					
			while(itemIterator.hasNext()){
				
				jsonstr+= (String)itemIterator.next();
				
			}
			
			
		return jsonstr;
			
			
		} 
	  
	  
	  
 public String buildStrIDXSpinner()
	    {
		
			
			 String jsonstr = "";
			

	            String symbolstr = "select * from Idx";


		
			 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(symbolstr);
			for (Map<String,Object> row : rows) {
				jIndexes index  = new jIndexes();
				
				
				
				
				index.setSymbol((String)row.get("Symbol"));
				index.setFullName((String)row.get("FullName"));
				
				
						
				
				
				
				jsonstr += index.toString();
				jsonstr += ",";

				
				
			}
			
			return jsonstr;
			
			
		}
	  
	/*******************************************************************************/  


 	public String buildStrPeformanceDataByFund(String fund){
 		
 		
 		
 		 String jsonstr = "";
 		
 		 String performancestr = "select P.SymID,P.InceptionDate_,P.MER_,P.Assets_,P.Rank_,P.MstarRating_,P.StdDev_,P.VolatileRank_," +
 	               "P.MstarRisk_,P.Alpha_,P.Beta_,P.Rsquared_,P.RRSPEligibility_,P.Load_,P.MaxFrontEnd_,P.MaxBackEnd_,P.SaleOpen_,P.NavPS_," +
 	               "P.NetAsset_,P.Yield_,P.Dividend_,P.Managers_,P.Fees_,P.FundName_" +
 	               " from PerformanceData P where  P.SymID = '" + fund + "'";

 		 jPerformanceData jperform = new jPerformanceData();
 	
 		 
 		 
 		 
  List<String> data = getJdbcTemplate().query(performancestr, new RowMapper<String>(){
 			 
 			 String jsonstr = "";
              public String mapRow(ResultSet rs, int rowNum) 
                                           throws SQLException {
             	 
             	   
             	              
                      
                     jperform.setInceptionDate(rs.getDate("InceptionDate_"));
                     jperform.setAlpha(rs.getDouble("Alpha_"));
          			jperform.setAssets(rs.getDouble("Assets_"));
          			jperform.setBeta(rs.getDouble("Beta_"));
          			jperform.setDividend(rs.getDouble("Dividend_"));
          			jperform.setFees(rs.getDouble("Fees_"));
          			jperform.setFundName(rs.getString("FundName_"));
          			jperform.setLoad(rs.getString("Load_"));
          			jperform.setManagers(rs.getString("Managers_"));
          			jperform.setMaxBackEnd(rs.getDouble("MaxBackEnd_"));
          			jperform.setMER(rs.getDouble("MER_"));
          			jperform.setMstarRating(rs.getDouble("MstarRating_"));
          			jperform.setMstarRisk(rs.getDouble("MstarRisk_"));
          			jperform.setNavPS(rs.getDouble("NavPS_"));
          			jperform.setRank(rs.getDouble("Rank_"));
          			jperform.setRRSPEligibility(rs.getString("RRSPEligibility_"));
          			jperform.setRsquared(rs.getDouble("Rsquared_"));
          			jperform.setSaleOpen(rs.getString("SaleOpen_"));
          			jperform.setStdDev(rs.getDouble("StdDev_"));
          			jperform.setSymID(rs.getString("SymID"));
          			jperform.setVolatileRank(rs.getDouble("VolatileRank_"));
          			jperform.setYield(rs.getDouble("Yield_"));
                      
                  
                      
          			ObjectMapper ob = new ObjectMapper();
          			String jkson="";
          			
          			try {
          				
          				jkson = ob.writeValueAsString(jperform);
          				
          				
          				
          			}catch(JsonProcessingException ex) {
          				
          				ex.printStackTrace();
          				
          				
          			}
          			
          			
          			  jsonstr += jkson;
          			
                    //  jsonstr += jperform.toString();
                      jsonstr += ",";
                      
                      
                      return jsonstr;
                      
                      
                      
              }
              
         });
 			
 			
 		Iterator itemIterator = data.iterator();
 				
 		while(itemIterator.hasNext()){
 			
 			jsonstr+= (String)itemIterator.next();
 			
 		}
 		 
 		 
 		return jsonstr;
 		
 		
 	}  
	  
 	public String buildStrHoldingsDataByFund(String fund) {
		
		
		
		 String jsonstr = "";
		
		 String holdingstr = "select h.FundSymID,h.symid,h.name,aa.asset,sa.sector,ga.geograph,h.percentage from holdings H left join AssetAllocation AA on H.assetid = AA.assetid left join SectorAllocation SA on H.sectorid = SA.sectorid left join GeographAllocation GA on H.geographid = GA.geographid left join PerformanceData P on H.FundSymID = P.SymID where h.FundSymID = '" + fund + "'";
	
	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(holdingstr);
		for (Map<String,Object> row : rows) {
			jHoldings holdings = new jHoldings();
			
			holdings.setFundSymID((String)row.get("FundSymID"));
			holdings.setSymID((String)row.get("symid"));
			holdings.setName((String)row.get("name"));
			holdings.setAsset((String)row.get("asset"));
			holdings.setSector((String)row.get("sector"));
			holdings.setGeograph((String)row.get("geograph"));
			holdings.setPercentage((Double)row.get("percentage"));
		
					
			
			
			
			jsonstr += holdings.toString();
           jsonstr += ",";

			
			
		}
		
		return jsonstr;
		
		
	}
	  
 	public String buildStrReturnsDataByFund(String fund) {
		
		
		
		 String jsonstr = "";
		
		 String returnstr = "select PDR.return_,PDR.OneMonth,PDR.ThreeMonth,PDR.SixMonth,PDR.YTD,PDR.OneYear,PDR.ThreeYear,PDR.FiveYear,PDR.TenYear from PerformanceDataReturn PDR left join PerformanceData P on PDR.return_ = P.SymID where PDR.return_ = '"+ fund +"'";


	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(returnstr);
		for (Map<String,Object> row : rows) {
			jPerformanceReturns returns = new jPerformanceReturns();
			
			returns.setReturn((String)row.get("Return_"));
			returns.setOneMonth((Double)row.get("OneMonth"));
			returns.setThreeMonth((Double)row.get("ThreeMonth"));
			returns.setSixMonth((Double)row.get("SixMonth"));
			returns.setYTD((Double)row.get("YTD"));
			returns.setOneYear((Double)row.get("OneYear"));
			returns.setThreeYear((Double)row.get("ThreeYear"));
			returns.setFiveYear((Double)row.get("FiveYear"));
			returns.setTenYear((Double)row.get("TenYear"));
		
					
			
			
			
			jsonstr += returns.toString();
          jsonstr += ",";

			
			
		}
		
		return jsonstr;
		
		
	} 
	 
 	public String buildStrHistoricalDataByFund(String fund){
		
		 
		 
		
		 
		 jHDstats stats = new jHDstats();
		 
		 String jsonstr = "";
			
		 String symbolstr = "select S.symbol_,S.Epoch_,S.Open_,S.High_,S.Low_ ,S.Close_,S.Close_Adj,S.Volume_  from PerformanceData P " +
		            "left join Symbols S on substring(s.symbol_, 1, LEN(S.symbol_) - 2) = P.SymID where S.symbol_ >= '" + fund + "'";

		 List<String> data = getJdbcTemplate().query(symbolstr, new RowMapper<String>(){
			 
			 String jsonstr = "";
            public String mapRow(ResultSet rs, int rowNum) 
                                         throws SQLException {
           	 
           	   
           	     stats.setSymbol(rs.getString("symbol_"));
           	    
                    stats.setEpoch(rs.getDate("epoch_"));
                    stats.setOpen(rs.getDouble("open_"));
                    stats.setHigh(rs.getDouble("high_"));
                    stats.setLow(rs.getDouble("low_"));
                    stats.setClose(rs.getDouble("close_"));
                    stats.setClose_adj(rs.getDouble("close_adj"));
                    stats.setVolume(rs.getDouble("volume_"));
                    
                    
                    
                    
                    jsonstr += stats.toString();
                    jsonstr += ",";
                    
                    
                    return jsonstr;
                    
                    
                    
            }
            
       });
			
			
		Iterator itemIterator = data.iterator();
				
		while(itemIterator.hasNext()){
			
			jsonstr+= (String)itemIterator.next();
			
		}
		
		
			
		return jsonstr;
		
		
	}
 	
 	
 	
 	public  String buildStrPerformanceCalanderByFund(String fund) {		
		
		
		 String jsonstr = "";

		
		 String query = "select c.Year_,c.Symbol_,c.NavPS_ from PerformanceCalander c left join performancedata d on c.symbol_ = d.symid where c.Symbol_ ='" + fund +"'";
		 jPerfCalender cal = new jPerfCalender();


		 
		 
		 
		 
			
		 List<String> data = getJdbcTemplate().query(query, new RowMapper<String>(){
			 
			 String jsonstr = "";
            public String mapRow(ResultSet rs, int rowNum) 
                                         throws SQLException {
           	 
           	   
           	     cal.setDate(rs.getDate("Year_"));
           	     cal.setSymbol(rs.getString("Symbol_"));
                    cal.setNavPS(rs.getDouble("NavPS_"));
                
                    
                    
                    
                    
                    jsonstr += cal.toString();
                    jsonstr += ",";
                    
                    
                    return jsonstr;
                    
                    
                    
            }
            
       });
			
			
		Iterator itemIterator = data.iterator();
				
		while(itemIterator.hasNext()){
			
			jsonstr+= (String)itemIterator.next();
			
		}
		
		 
		return jsonstr;
		
		
	}
 	
 	
 	
 	public Iterator getFundsbyFund(String fund)
    {
	

		ArrayList<String> jlist = new ArrayList<String>();
	
		
		
		 String jsonstr = "";
		 String buildstr = "";
		
		 String performancestr = "select P.SymID,P.InceptionDate_,P.MER_,P.Assets_,P.Rank_,P.MstarRating_,P.StdDev_,P.VolatileRank_," +
	               "P.MstarRisk_,P.Alpha_,P.Beta_,P.Rsquared_,P.RRSPEligibility_,P.Load_,P.MaxFrontEnd_,P.MaxBackEnd_,P.SaleOpen_,P.NavPS_," +
	               "P.NetAsset_,P.Yield_,P.Dividend_,P.Managers_,P.Fees_,P.FundName_" +
	               " from PerformanceData P where  P.SymID = '" + fund + "'";





	
		 List <Map <String,Object>> rows = getJdbcTemplate().queryForList(performancestr);
		for (Map<String,Object> row : rows) {
			jPerformanceData data = new jPerformanceData();
			
			
		
			data.setSymID((String)row.get("SymID"));
			
			   buildstr+= data + " ";
			   jlist.add(buildstr);

               

			
			
			
		
        
			
			
		}
		
		
		//jPerformDataEnum jdata = new jPerformDataEnum(buildstr, new Char[] {' ',','}); 
		
		Iterator<String> forList =  jlist.iterator();
		
		
		
		
		
		return forList;
		
		
	}	
 	
 	
 

 		public String buildStrPeformanceDataAll(){
 	 		
 	 		
 	 		
 	 		 String jsonstr = "";
 	 		
 	 		 String performancestr = "select P.SymID,P.InceptionDate_,P.MER_,P.Assets_,P.Rank_,P.MstarRating_,P.StdDev_,P.VolatileRank_," +
 	 	               "P.MstarRisk_,P.Alpha_,P.Beta_,P.Rsquared_,P.RRSPEligibility_,P.Load_,P.MaxFrontEnd_,P.MaxBackEnd_,P.SaleOpen_,P.NavPS_," +
 	 	               "P.NetAsset_,P.Yield_,P.Dividend_,P.Managers_,P.Fees_,P.FundName_" +
 	 	               " from PerformanceData P ";

 	 		 jPerformanceData jperform = new jPerformanceData();
 	 	
 	 		 
 	 		 
 	 		 
 	  List<String> data = getJdbcTemplate().query(performancestr, new RowMapper<String>(){
 	 			 
 	 			 String jsonstr = "";
 	              public String mapRow(ResultSet rs, int rowNum) 
 	                                           throws SQLException {
 	             	 
 	             	   
 	             	              
 	                      
 	                     jperform.setInceptionDate(rs.getDate("InceptionDate_"));
 	                     jperform.setAlpha(rs.getDouble("Alpha_"));
 	          			jperform.setAssets(rs.getDouble("Assets_"));
 	          			jperform.setBeta(rs.getDouble("Beta_"));
 	          			jperform.setDividend(rs.getDouble("Dividend_"));
 	          			jperform.setFees(rs.getDouble("Fees_"));
 	          			jperform.setFundName(rs.getString("FundName_"));
 	          			jperform.setLoad(rs.getString("Load_"));
 	          			jperform.setManagers(rs.getString("Managers_"));
 	          			jperform.setMaxBackEnd(rs.getDouble("MaxBackEnd_"));
 	          			jperform.setMER(rs.getDouble("MER_"));
 	          			jperform.setMstarRating(rs.getDouble("MstarRating_"));
 	          			jperform.setMstarRisk(rs.getDouble("MstarRisk_"));
 	          			jperform.setNavPS(rs.getDouble("NavPS_"));
 	          			jperform.setRank(rs.getDouble("Rank_"));
 	          			jperform.setRRSPEligibility(rs.getString("RRSPEligibility_"));
 	          			jperform.setRsquared(rs.getDouble("Rsquared_"));
 	          			jperform.setSaleOpen(rs.getString("SaleOpen_"));
 	          			jperform.setStdDev(rs.getDouble("StdDev_"));
 	          			jperform.setSymID(rs.getString("SymID"));
 	          			jperform.setVolatileRank(rs.getDouble("VolatileRank_"));
 	          			jperform.setYield(rs.getDouble("Yield_"));
 	                      
 	                  
 	                      
 	          			ObjectMapper ob = new ObjectMapper();
 	          			String jkson="";
 	          			
 	          			try {
 	          				
 	          				jkson = ob.writeValueAsString(jperform);
 	          				
 	          				
 	          				
 	          			}catch(JsonProcessingException ex) {
 	          				
 	          				ex.printStackTrace();
 	          				
 	          				
 	          			}
 	          			
 	          			
 	          			  jsonstr += jkson;
 	          			
 	                   
 	                      jsonstr += ",";
 	                      
 	                      
 	                      return jsonstr;
 	                      
 	                      
 	                      
 	              }
 	              
 	         });
 	 			
 	 			
 	 		Iterator itemIterator = data.iterator();
 	 				
 	 		while(itemIterator.hasNext()){
 	 			
 	 			jsonstr+= (String)itemIterator.next();
 	 			
 	 		}
 	 		 
 	 		 
 	 		return jsonstr;
 	 		
 	 		
 	 	}  
		

 		public String buildStrJournalData(){
 	 		
 	 		
 	 		
 	 		 String jsonstr = "";
 	 		
 	 		 String journalstr =  "select R.TerminalID,R.JournalID from JournalLookup R right join Customer C on C.TerminalID = R.TerminalID where R.JournalStatus = 0";

 	 
 	 	
 	 		journalData journaldata = new journalData();
 	 		 
 	 		 
 	  List<String> data = getJdbcTemplate().query(journalstr, new RowMapper<String>(){
 	 			 
 	 			 String jsonstr = "";
 	              public String mapRow(ResultSet rs, int rowNum) 
 	                                           throws SQLException {
 	             	 
 	             	   
 	             	 journaldata.setJournalID(rs.getString("JournalID"));
 	             	 journaldata.setTerminalID(rs.getString("TerminalID")); 
 	             	// journaldata.setJournalStatus(rs.getString("InceptionDate_")); 
 	            	  
 	            	                                     
 	                  
 	                      
 	          			ObjectMapper ob = new ObjectMapper();
 	          			String jkson="";
 	          			
 	          			try {
 	          				
 	          				jkson = ob.writeValueAsString(journaldata);
 	          				
 	          				
 	          				
 	          			}catch(JsonProcessingException ex) {
 	          				
 	          				ex.printStackTrace();
 	          				
 	          				
 	          			}
 	          			
 	          			
 	          			  jsonstr += jkson;
 	          			
 	                   
 	                      jsonstr += ",";
 	                      
 	                      
 	                      return jsonstr;
 	                      
 	                      
 	                      
 	              }
 	              
 	         });
 	 			
 	 			
 	 		Iterator itemIterator = data.iterator();
 	 				
 	 		while(itemIterator.hasNext()){
 	 			
 	 			jsonstr+= (String)itemIterator.next();
 	 			
 	 		}
 	 		 
 	 		 
 	 		return jsonstr;
 	 		
 	 		
 	 	}  
		
		
 		
 	
 		
		
 	public void updateTable(journalLookup data) {
 		
 		journalLookup journallookup = new journalLookup();

 		//	String sql = "INSERT INTO CUSTOMER " +
 		//		"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
 		
 		String sql = "update journallookup set JournalStatus = ? where terminalID = ?";

 			jdbcTemplate = new JdbcTemplate(datasource);

 			jdbcTemplate.update(sql, new Object[] { data.getJournalStatus(),
 				data.getTerminalID()
 			});
 		
 		
 		
 		
 		
 		
 		
 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
	
	
}
