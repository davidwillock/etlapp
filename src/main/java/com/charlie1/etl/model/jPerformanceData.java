package com.charlie1.etl.model;

import java.util.Date;

public class jPerformanceData {
	
		
	public jPerformanceData(){}
	
	
	
	private String SymID;
    
    private Date InceptionDate; 

    private double MER;

 
    private double Assets; 

  
    private double Rank; 

  
    private double MstarRating; 

   
    private double StdDev;

   
    private double VolatileRank; 

  
    private double MstarRisk;


  
    private double Alpha; 

  
    private double Beta; 


  
    private double Rsquared;


   
    private String RRSPEligibility; 


  
    private String Load; 


    private double MaxBackEnd; 


  
    private double MaxFrontEnd; 



    private String SaleOpen; 



    private double NavPS;



    private double NetAsset; 


  
    private double Yield; 

    private double Dividend; 


    private String Managers; 


    private double Fees; 

  
    private String FundName; 


   
	
	
	
	
	
				public String getSymID() {
		return SymID;
	}


	public void setSymID(String symID) {
		SymID = symID;
	}


	public Date getInceptionDate() {
		return InceptionDate;
	}


	public void setInceptionDate(Date inceptionDate) {
		InceptionDate = inceptionDate;
	}


	public double getMER() {
		return MER;
	}


	public void setMER(double mER) {
		MER = mER;
	}


	public double getAssets() {
		return Assets;
	}


	public void setAssets(double assets) {
		Assets = assets;
	}


	public double getRank() {
		return Rank;
	}


	public void setRank(double rank) {
		Rank = rank;
	}


	public double getMstarRating() {
		return MstarRating;
	}


	public void setMstarRating(double mstarRating) {
		MstarRating = mstarRating;
	}


	public double getStdDev() {
		return StdDev;
	}


	public void setStdDev(double stdDev) {
		StdDev = stdDev;
	}


	public double getVolatileRank() {
		return VolatileRank;
	}


	public void setVolatileRank(double volatileRank) {
		VolatileRank = volatileRank;
	}


	public double getMstarRisk() {
		return MstarRisk;
	}


	public void setMstarRisk(double mstarRisk) {
		MstarRisk = mstarRisk;
	}


	public double getAlpha() {
		return Alpha;
	}


	public void setAlpha(double alpha) {
		Alpha = alpha;
	}


	public double getBeta() {
		return Beta;
	}


	public void setBeta(double beta) {
		Beta = beta;
	}


	public double getRsquared() {
		return Rsquared;
	}


	public void setRsquared(double rsquared) {
		Rsquared = rsquared;
	}


	public String getRRSPEligibility() {
		return RRSPEligibility;
	}


	public void setRRSPEligibility(String rRSPEligibility) {
		RRSPEligibility = rRSPEligibility;
	}


	public String getLoad() {
		return Load;
	}


	public void setLoad(String load) {
		Load = load;
	}


	public double getMaxBackEnd() {
		return MaxBackEnd;
	}


	public void setMaxBackEnd(double maxBackEnd) {
		MaxBackEnd = maxBackEnd;
	}


	public double getMaxFrontEnd() {
		return MaxFrontEnd;
	}


	public void setMaxFrontEnd(double maxFrontEnd) {
		MaxFrontEnd = maxFrontEnd;
	}


	public String getSaleOpen() {
		return SaleOpen;
	}


	public void setSaleOpen(String saleOpen) {
		SaleOpen = saleOpen;
	}


	public double getNavPS() {
		return NavPS;
	}


	public void setNavPS(double navPS) {
		NavPS = navPS;
	}


	public double getNetAsset() {
		return NetAsset;
	}


	public void setNetAsset(double netAsset) {
		NetAsset = netAsset;
	}


	public double getYield() {
		return Yield;
	}


	public void setYield(double yield) {
		Yield = yield;
	}


	public double getDividend() {
		return Dividend;
	}


	public void setDividend(double dividend) {
		Dividend = dividend;
	}


	public String getManagers() {
		return Managers;
	}


	public void setManagers(String managers) {
		Managers = managers;
	}


	public double getFees() {
		return Fees;
	}


	public void setFees(double fees) {
		Fees = fees;
	}


	public String getFundName() {
		return FundName;
	}


	public void setFundName(String fundName) {
		FundName = fundName;
	}
	
	
/*
    @Override
public String toString() {
return "[SymID=" + SymID + ", InceptionDate=" + InceptionDate + ", MER=" + MER + ", Assets="
	+ Assets + ", Rank=" + Rank + ", MstarRating=" + MstarRating + ", StdDev=" + StdDev + ", VolatileRank="
	+ VolatileRank + ", MstarRisk=" + MstarRisk + ", Alpha=" + Alpha + ", Beta=" + Beta + ", Rsquared="
	+ Rsquared + ", RRSPEligibility=" + RRSPEligibility + ", Load=" + Load + ", MaxBackEnd=" + MaxBackEnd
	+ ", MaxFrontEnd=" + MaxFrontEnd + ", SaleOpen=" + SaleOpen + ", NavPS=" + NavPS + ", NetAsset="
	+ NetAsset + ", Yield=" + Yield + ", Dividend=" + Dividend + ", Managers=" + Managers + ", Fees=" + Fees
	+ ", FundName=" + FundName + "]";
}
*/
	
	  @Override
	  public String toString() {
	  return "{\"SymID\":\"" + SymID + "\", \"InceptionDate\":\"" + InceptionDate + "\", \"MER\":\"" + MER + "\", \"Assets\":\""
	  	+ Assets + "\", \"Rank\":\"" + Rank +  "\",\"MstarRating\":\"" + MstarRating + "\", \"StdDev\":\"" + StdDev + "\", \"VolatileRank\":\""
	  	+ VolatileRank + "\", \"MstarRisk\":\"" + MstarRisk + "\", \"Alpha\":\"" + Alpha + "\", \"Beta:\":\"" + Beta + "\", \"Rsquared\":\""
	  	+ Rsquared + "\", \"RRSPEligibility\":\"" + RRSPEligibility + "\", \"Load\":\"" + Load + "\", \"MaxBackEnd\":\"" + MaxBackEnd
	  	+ "\", \"MaxFrontEnd\":\"" + MaxFrontEnd + "\", \"SaleOpen\":\"" + SaleOpen + "\", \"NavPS\":\"" + NavPS + "\", \"NetAsset\":\""
	  	+ NetAsset + "\", \"Yield\":\"" + Yield + "\", \"Dividend\":\"" + Dividend + "\", \"Managers\":\"" + Managers + "\", \"Fees\":\"" + Fees
	  	+ "\", \"FundName\":\"" + FundName + "\"}";
	  }
	
	
	
	
	

    
    

				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
