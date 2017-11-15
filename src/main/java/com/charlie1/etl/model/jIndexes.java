package com.charlie1.etl.model;


public class jIndexes {
	
	
	
	
	
	private String Symbol;
		     
	private String FullName;
	
	
	public jIndexes() {}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	@Override
	public String toString() {
		return "{\"Symbol\":\"" + Symbol + "\", \"FullName\":\"" + FullName + "\"}";
	}
	
	
	
	
	


	
	

}
