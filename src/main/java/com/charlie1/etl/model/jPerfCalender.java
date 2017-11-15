package com.charlie1.etl.model;

import java.util.Date;

public class jPerfCalender {
	
	
	
	 private String Symbol;
    
     private Date Date;
    
     private double NavPS;
     
     
    public jPerfCalender() {}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public double getNavPS() {
		return NavPS;
	}

	public void setNavPS(double navPS) {
		NavPS = navPS;
	}

	@Override
	public String toString() {
		return "{\"Symbol\":\"" + Symbol + "\", \"Date\":\"" + Date + "\", \"NavPS\":\"" + NavPS + "\"}";
	}
     
     
    
	
	
	

}
