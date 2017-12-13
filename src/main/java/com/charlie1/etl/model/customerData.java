package com.charlie1.etl.model;
import java.util.Date;

public class customerData {
	
	
	public customerData() {}

	
	int CustId;
	String InstallDate;
	String RetailName;
	String RetailAddress;
	String County;
	String Country;
	
	public int getCustId() {
		return CustId;
	}
	public void setCustId(int custId) {
		CustId = custId;
	}
	public String getInstallDate() {
		return InstallDate;
	}
	public void setInstallDate(String installDate) {
		InstallDate = installDate;
	}
	public String getRetailName() {
		return RetailName;
	}
	public void setRetailName(String retailName) {
		RetailName = retailName;
	}
	public String getRetailAddress() {
		return RetailAddress;
	}
	public void setRetailAddress(String retailAddress) {
		RetailAddress = retailAddress;
	}
	public String getCounty() {
		return County;
	}
	public void setCounty(String county) {
		County = county;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	
		
	
}
