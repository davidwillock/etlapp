package com.charlie1.etl.model;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class sendDimStoreInfo {

	
	public sendDimStoreInfo() {}
	
	List<storeInfoData> storeinfodataArray;
	
	String storeinfoData;
	 
	public String getDimStoreInfo() {
		return storeinfoData;
	}
	public void setDimStoreInfo(List<storeInfoData> storeinfodataArray) {
		this.storeinfodataArray = storeinfodataArray;
	}


   public void initialiseData() {
		
		
		
	   ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		
		
		
		
		
		
		 
		 FundsDAO dimStoreDAO = (FundsDAO) context.getBean("FundsDAO");
	     dimStoreDAO.batchDimStoreInfo(storeinfodataArray);
		
		
		
		
		
	}
	
	
	
	
	
	public void initializeBean() {
		
		
		
	}
	
	
	
	
	
	
	
}
