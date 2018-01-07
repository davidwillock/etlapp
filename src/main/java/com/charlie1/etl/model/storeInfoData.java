package com.charlie1.etl.model;

public class storeInfoData {
	
	
	
	
	
	
	
	
	String storeID;
	String installDate;
	String terminalID;
	String custId;
	String retailName;
	String retailAddress;
	String county;
	String region;
	String country;
	String city;
	
	
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public storeInfoData() {}
	
	
	public String getStoreID() {
		return storeID;
	}
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
	public String getInstallDate() {
		return installDate;
	}
	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}
	public String getTerminalID() {
		return terminalID;
	}
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getRetailName() {
		return retailName;
	}
	public void setRetailName(String retailName) {
		this.retailName = retailName;
	}
	public String getRetailAddress() {
		return retailAddress;
	}
	public void setRetailAddress(String retailAddress) {
		this.retailAddress = retailAddress;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "storeInfoData [storeID=" + storeID + ", installDate=" + installDate + ", terminalID=" + terminalID
				+ ", custId=" + custId + ", retailName=" + retailName + ", retailAddress=" + retailAddress + ", county="
				+ county + ", region=" + region + ", country=" + country + ", city=" + city + "]";
	}


	
	

}
