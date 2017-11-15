package com.charlie1.etl.model;


public class jChartSector {
	
	
	

    private String Fund;
 
    private  String Sector;

    private int Count;

    private int Percent;
    
    public jChartSector() {}

	public String getFund() {
		return Fund;
	}

	public void setFund(String fund) {
		Fund = fund;
	}

	public String getSector() {
		return Sector;
	}

	public void setSector(String sector) {
		Sector = sector;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public int getPercent() {
		return Percent;
	}

	public void setPercent(int percent) {
		Percent = percent;
	}

	@Override
	public String toString() {
		return "{\"Fund\":\"" + Fund + "\", \"Sector\":\"" + Sector + "\", \"Count\":\"" + Count + "\", \"Percent\":\"" + Percent + "\"}";
	} 

    
    

	
	
	
	
	

}
