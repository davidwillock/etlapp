package com.charlie1.etlparser;


//import org.rosuda.REngine.*;
//import org.rosuda.REngine;

import org.rosuda.JRI.Rengine;

public class parser {

//	public static void main(String[] args) {
	
	
		// TODO Auto-generated method stubd
	
	public void rUtility() {
	
		System.out.println("test");
		
		
		
		String journal=""
		+"147 A/C 905723 61503568 CASH    20   09:11:47 Cash taken"
		+"147 A/C 905723 61503568 CASH    200   09:11:47 Cash taken"
		+"147 A/C 905723 61503568 CASH    4000   09:11:47 Cash taken"
		+"09:11:15 Track 2 data: 6304905723792809157"
		+"09:11:20 Transaction request AA"     
		+"09:11:42 Cash response: 00010000"
		+"09:11:42 Cash 2:1,1;"
		+"09:11:46 Cash presented"
		+"147 A/C 905723 61503568 CASH    20   09:11:47 Cash taken"
		+"09:11:58 Track 2 data: 6304905723792809157"
		+"09:12:03 Transaction request AA"      
		+"09:12:22 Cash response: 00010000"
		+"09:12:22 Cash 2:1,1;"
		+"09:12:25 Cash presented"
		+"148 A/C 905723 61503568 CASH    20   09:12:27 Cash taken";
		
		
		
		
		
		
		
		
		
		

        // Create an R vector in the form of a string.
        String javaVector = "c(1,2,3,4,5)";

        // Start Rengine.
        Rengine engine = new Rengine(new String[] { "--no-save" }, false, null);
        
     
        
        
        

        // The vector that was created in JAVA context is stored in 'rVector' which is a variable in R context.
        engine.eval("rVector=" + javaVector);
        
        //Calculate MEAN of vector using R syntax.
        engine.eval("meanVal=mean(rVector)");
        
        //Retrieve MEAN value
        double mean = engine.eval("meanVal").asDouble();
        
        //Print output values
        System.out.println("Mean of given vector is=" + mean);
        
  /*      
        engine.eval("library(RODBC)");
        
        engine.eval("ch <- odbcConnect(\"Adventure Works DW2012\")");
        
        engine.eval("sqlResult <- sqlQuery(ch, \"select * from dbo.DimCustomer\")");
        
        String sql = engine.eval("sqlResult").asString();
        
        
        System.out.println(sql);
     */   
        
      //  parse(journal);
      //  parseCash(journal);

	}
	
	public static void parse(String journal) {
		
		
		char p;
		
		//String is = "is";
		//String paragraph = "transaction is a test.";
		String bufferStr="";
		String buffer="";
		
		//char bufferChar[]= {'i','s','\0'};
		char lblCash[]= {'C','A','S','H'};
		
		//int bufferCharsz = bufferChar.length;
		String jrn = journal;
		String bufferCash="";
		
	
		
		
		int paraLength = jrn.length();
		
	    int i=0;
		while(i < paraLength) {
			
			int j=0;
			while(jrn.charAt(i) != lblCash[j] && i < paraLength-1) {
				i++;
			
				
				
				
			}
			
			if(jrn.charAt(i) == lblCash[j]){
				
				if(j < lblCash.length)
				while(jrn.charAt(i) ==  lblCash[j] && j < lblCash.length) {
					
					bufferCash+= jrn.charAt(i);
					
					i++;
					j++;
				}
				
				if(bufferCash.equals(lblCash))
				{
					buffer = bufferCash;
					
				}else {
					
					bufferStr="";
					
				}
				
				
				
			}
			
			
			i++;
		}
		
		
		
		
		
		
	}
	
public static void parseCash(String journal) {
		
		
		char p;
		
		String is = "is";
		String paragraph = "transaction is a test.";
		String bufferStr="";
		String buffer="";
		
		String testCash = new String();
	
	
		char lblCash[]= {'C','A','S','H',' ',' ',' ','\0'};
		String strCash = "CASH   ";
		int transCnt=0;
		
	
		String jrn = journal;
		int jrnLength = jrn.length();
		
		
	
		
		
		int paraLength = paragraph.length();
		
	    int i=0;
		while(i < jrnLength) {
			
			int j=0;
			while(jrn.charAt(i) != lblCash[j] && i < jrnLength-1) {
				i++;
			
				
				
				
			}
			
			if(jrn.charAt(i) ==  lblCash[j]){
				
				if(j < lblCash.length)
				while(jrn.charAt(i) ==  lblCash[j] && j < lblCash.length) {
					
					bufferStr+= jrn.charAt(i);
					
					
					i++;
					j++;
				}
				
				if(bufferStr.equals(strCash))
				{
					
					
							
				
					i++;
					if(jrn.charAt(i) != 'D' && Character.isDigit(jrn.charAt(i))) {
						
						while(Character.isDigit(jrn.charAt(i))) {
							
							bufferStr+= jrn.charAt(i);
							i++;
						}
						
						
						transCnt++;
						buffer += bufferStr;
						buffer += " ";
						buffer += "\r\n";
						System.out.println(buffer);
						
						
						
						
						
					}else {
						
						bufferStr = "";
									
					}
					
					
					
					
					
					
					
					
				}else {
					
					bufferStr="";
					
				}
				
				
				
			}
			
			
			i++;
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
