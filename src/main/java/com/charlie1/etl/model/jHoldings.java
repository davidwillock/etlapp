package com.charlie1.etl.model;

public class jHoldings {
	
	
	
	 private String FundSymID;
    
     private String SymID;

    
     private String Name; 

   
     private String Asset; 

   
     private String Sector;

    
     private String Geograph;

   
     private double Percentage;
     
     public jHoldings() {}


	public String getFundSymID() {
		return FundSymID;
	}


	public void setFundSymID(String fundSymID) {
		FundSymID = fundSymID;
	}


	public String getSymID() {
		return SymID;
	}


	public void setSymID(String symID) {
		SymID = symID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAsset() {
		return Asset;
	}


	public void setAsset(String asset) {
		Asset = asset;
	}


	public String getSector() {
		return Sector;
	}


	public void setSector(String sector) {
		Sector = sector;
	}


	public String getGeograph() {
		return Geograph;
	}


	public void setGeograph(String geograph) {
		Geograph = geograph;
	}


	public double getPercentage() {
		return Percentage;
	}


	public void setPercentage(double percentage) {
		Percentage = percentage;
	}


	@Override
	public String toString() {
		return "{\"FundSymID\":\"" + FundSymID + "\", \"SymID\":\"" + SymID + "\", \"Name\":\"" + Name + "\", \"Asset\":\"" + Asset
				+ "\", \"Sector\":\"" + Sector + "\", \"Geograph\":\"" + Geograph + "\", \"Percentage\":\"" + Percentage + "\"}";
	}
	
	
	
	
	
	
	
	

}
