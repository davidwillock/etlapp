package com.charlie1.etl.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class jFundsRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		jPerformanceData jperform = new jPerformanceData();
		jperform.setAlpha(rs.getDouble("Alpha_"));
		jperform.setAssets(rs.getDouble("Assets_"));
		jperform.setBeta(rs.getDouble("Beta_"));
		jperform.setDividend(rs.getDouble("Dividend"));
		jperform.setFees(rs.getDouble("Fees_"));
		jperform.setFundName(rs.getString("FundName_"));
		jperform.setInceptionDate(rs.getDate("InceptionDate_"));
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
		
		
		return jperform;
	}
	
}
