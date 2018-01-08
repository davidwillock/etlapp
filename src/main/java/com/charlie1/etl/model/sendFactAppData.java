package com.charlie1.etl.model;









import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.charlie1.etl.dao.FundsDAO;

public class sendFactAppData {

	
	public sendFactAppData() {}
	
	


   public void initialiseData() {
		
		
		
	   ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module2.xml");
		
		
		
		
		
		
		
		 
		 FundsDAO dimStoreDAO = (FundsDAO) context.getBean("EtlDAO");
	    // dimStoreDAO.batchDimStoreInfo(storeinfodataArray);
	   //  dimStoreDAO.execStoresDim();
		 dimStoreDAO.execAppData();
		
		
		
		
	}
	
	
	
	
	
	public void initializeBean() {
		
		
		
	}
	
	
	
	
	
	
	
}
