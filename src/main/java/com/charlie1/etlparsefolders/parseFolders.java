package com.charlie1.etlparsefolders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.charlie1.etlparser.*;

import com.charlie1.etlvalidatejournal.*;
import com.charlie1.simulate.simulator;
import com.charlie1.etlwriteto.*;

public class parseFolders  {
	

	
	
	String path="";
	
	
	public void setPath(String path) {
		
		this.path = path;
		
	}
	
	public String getPath() {
		
		
		return path;
	}
	
	
	
	public parseFolders(){
		
		File currentDir = new File("."); // current directory
	//	displayDirectoryContents(currentDir);
		
		
	}
	
	
	
	static validateJournal validatejournal = new validateJournal();
	
	
	
	

	public static void displayDirectoryContents(File dir) {
		
		parser srcfiles = new parser();
		
		
			
		
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				
					    String[] bits = file.getName().split(".");
					    
					    
					    
					    
					    String extType ="";
					    
					     	 String StrGetName = file.getName();
					    	 String[] retjrn = StrGetName.split("\\.");
					    	 String journalID = "";
					    						 
					    	if (retjrn[1].equalsIgnoreCase("jrn")) {
					    						 
					    	journalID = retjrn[0];
					    	extType = "JRN";
					    					    					
					    	}else {
					    		
					    		journalID = retjrn[0];
					    		extType = "CSV";
					    					    		
					    	}
					    
					    	String strAbsPath = file.getAbsolutePath();
					       	String strPath = file.getParent();
					    	File subPath = new File(strPath);
					    	String terminalID = subPath.getName();
					   
					    	
					    	
					    	
					    	String strjournaltmp = strAbsPath;
					    	
					    	FileInputStream fis = new FileInputStream(strjournaltmp);
					    	byte[] data = new byte[(int) file.length()];
					    	fis.read(data);
					    	fis.close();
					    	
					    	
					    	
					    	

					    	String strJournalData = new String(data, "UTF-8");
					    	
					        
					    	
					     	validatejournal.setTerminalID(terminalID);
					    	validatejournal.setJournalName(journalID);
					    	validatejournal.checkJournal();
					    	
					    	if(!validatejournal.isGetStatus() && extType.equals("JRN")) {
					    		
					    		srcfiles. parseCashUnStructuredtoFactTbl(strJournalData,terminalID,journalID);
					    	}else if(!validatejournal.isGetStatus() && extType.equals("CSV")) {
					    		
					    		srcfiles.parseCashStructuredToApplicationLog(strJournalData,terminalID,journalID);
					    		//srcfiles.parseCashStructuredToFactTransTbl(strJournalData,terminalID,journalID);
					    	
					    	}
					    	
					    	
					    //	srcfiles.parseCash(strJournalFile);
					    	
					    				    	
					//    }
					
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static void createDirectoryContents(File dir, int maxJournals,int maxtrans ,String journalDate, String starttime) {
	
	
	
	
		String jrnName="";
		parser srcfiles = new parser();
		simulator sim = new simulator();
		String orgJrnDate = journalDate;
		
		 Random generator = new Random();
		 int min = 1;
		
		 int randomtrans = min + generator.nextInt(70);
		 System.out.println("Random trans"+ randomtrans);
		 
	    
		
     //   String journalData = sim.getTransactionStr();
        
         
        
       
		
		
		
		
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				
				 journalDate = orgJrnDate;
				 
				 sim.setJournalDay(journalDate);
		         sim.createJournalFilesSingle();
		         jrnName = sim.getJournalDaySingle();
				 
				 
				
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					//createDirectoryContents(file);
					
					int i=1;
					while (i <= maxJournals) {
					
					
					
									
					     
					     if(i == 1) {
					    	 
					    	 
					    	 sim.setDayofMonth(0);
					         					
					    	 
					    	 	    	 
					    	 
					     }else {
						
					      	 sim.setDayofMonth(1);
						
					     }
					 // params to create journal
				//	 sim.setJournalcnt(7);
			       
			         
			         // set path to journal for creation
					     
					     sim.setTransactioncnt(generator.nextInt(80));
					     sim.setTransactionStartTime(starttime);
					     sim.createTransactions();
					     
					     
					     
			         
			         
			         String canonicalPath = file.getCanonicalPath();
			         canonicalPath +=  "\\";
			         canonicalPath += jrnName;
			         canonicalPath +=  ".csv";
			         
			      //   sim.setDayofMonth(1);
			         sim.setJournalDay(journalDate);
			         sim.createJournalFilesSingle();
			         jrnName = sim.getJournalDaySingle();
			         
			        
					 

			 		
			         String transdata = sim.getTransactionStr();
			         
			         writetoDisk writeto = new writetoDisk();
				     writeto.setCsvPath(canonicalPath);
					 writeto.setJournalData(transdata);
					 writeto.createCSV();
						
					
					 journalDate = sim.getJournalDay();
					 System.out.println(journalDate);
					 
					 
					 
					 
					 
					 i++;
					
					}
					
					
					
					
					
					
					
					
					
					
					
					
	
				}	
				
				
				//
				
				
				} 
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	

}
