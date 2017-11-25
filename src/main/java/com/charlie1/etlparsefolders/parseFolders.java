package com.charlie1.etlparsefolders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import com.charlie1.etlparser.*;

import com.charlie1.etlvalidatejournal.*;

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
	
	
	public void NavFolder(String DirPath) {
		
		/*
		
		File dir = new File(DirPath);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		      // Do something with child
		    	
		    	System.out.println(child.getPath());
		    	
		    }
		  } else {
			  
			  
			  
			  System.out.println("Must be file");
			  
			  
		    // Handle the case where dir is not really a directory.
		    // Checking dir.isDirectory() above would not be sufficient
		    // to avoid race conditions with another process that deletes
		    // directories.
		  }
		
		
		 */
		
		
		
		
		
		
		
	}
	
	
	public void getFiles() {
		
		
		
		File path = new File("c:/documents and settings/Zachary/desktop");

	    File [] files = path.listFiles();
	    for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){ //this line weeds out other directories/folders
	            System.out.println(files[i]);
	        }else {
	        	
	        	
	        	
	        }
	    }
		
		
		
	}
	
	
	
	
	public void getfiles2() {
		
		/*
		File[] files = new File("C:\\Users\..myfolder").listFiles();
		for (File file : files) {
		    if (!file.isFile()) continue;

		    String[] bits = file.getName().split(".");
		    if (bits.length > 0 && bits[bits.length - 1].equalsIgnoreCase("pdf")) {
		        // Do stuff with the file
		    }
		}
		*/
		
		
		
		
		
		
		
		
	}
	
	
	
	

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
					 //   String teststr = bits[bits.length - 1];
					//    if (bits.length > 0 && bits[bits.length - 1].equalsIgnoreCase("jrn")) {
					        // Do stuff with the file
					    
					  //   validatejournal.checkJournal();
					    	
					    
					     	 String StrGetName = file.getName();
					    	 String[] retjrn = StrGetName.split("\\.");
					    	 String journalID = "";
					    						 
					    	if (retjrn[1].equalsIgnoreCase("jrn")) {
					    						 
					    	journalID = retjrn[0];
					    					
					    	}	 	
					    
					    	String strAbsPath = file.getAbsolutePath();
					       	String strPath = file.getParent();
					    	File subPath = new File(strPath);
					    	String terminalID = subPath.getName();
					   
;					    	
					    	
					    	
					    	String strjournaltmp = strAbsPath;
					    	
					    	FileInputStream fis = new FileInputStream(strjournaltmp);
					    	byte[] data = new byte[(int) file.length()];
					    	fis.read(data);
					    	fis.close();
					    	
					    	
					    	
					    	

					    	String strJournalData = new String(data, "UTF-8");
					    	
					        
					    	
					     	validatejournal.setTerminalID(terminalID);
					    	validatejournal.setJournalName(journalID);
					    	validatejournal.checkJournal();
					    	
					    	if(!validatejournal.isGetStatus()) {
					    		
					    		srcfiles.parseCash(strJournalData,terminalID,journalID);
					    	}
					    	
					    	
					    	
					    	
					    //	srcfiles.parseCash(strJournalFile);
					    	
					    				    	
					//    }
					
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	

}
