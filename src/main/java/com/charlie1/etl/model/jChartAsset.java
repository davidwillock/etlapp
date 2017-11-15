package com.charlie1.etl.model;
public class jChartAsset {
	
	
	
	private String Fund;
	
    private String Asset;
     
    private int Count;

    private int Percent;
    
    
    public jChartAsset() {}

	public String getFund() {
		return Fund;
	}

	public void setFund(String fund) {
		Fund = fund;
	}

	public String getAsset() {
		return Asset;
	}

	public void setAsset(String asset) {
		Asset = asset;
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
		return "{\"Fund\":\"" + Fund + "\", \"Asset\":\"" + Asset + "\", \"Count\":\"" + Count + "\", \"Percent\":" + Percent + "\"}";
	}
    
    
	
	
	
	

}
