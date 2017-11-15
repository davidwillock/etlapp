package com.charlie1.etl.model;


public class jChartGeography {
	
		
	private String Fund;
	
    private String Geograph;
 
    private int Count;

    private int Percent;
        
    public jChartGeography() {}

	public String getFund() {
		return Fund;
	}

	public void setFund(String fund) {
		Fund = fund;
	}

	public String getGeograph() {
		return Geograph;
	}

	public void setGeograph(String geograph) {
		Geograph = geograph;
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
		return "{\"Fund\":\"" + Fund + "\", \"Geograph\":" + Geograph + "\", \"Count\":\"" + Count + "\", \"Percent\":\"" + Percent
				+ "\"}";
	}
	
	
	

}
