package com.charlie1.etlparsefolders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import com.charlie1.etlparser.*;

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
					    
					   
					    		
					    	//	if (file.getName().split(".").equals(obj)("jrn"))
					    			 String Str = file.getName();
					    			 
					    			 
					    					// for (String retjrn: Str.split(".")) {
					    			 String[] retjrn = Str.split("\\.");
					    						 
					    						 if (retjrn[1].equalsIgnoreCase("jrn")) {
					    						 
					    				         System.out.println("Str");
					    					//	 }
					    					 }	 	
					    	
					    	
					    	
					    	FileInputStream fis = new FileInputStream(file.getName());
					    	byte[] data = new byte[(int) file.length()];
					    	fis.read(data);
					    	fis.close();

					    	String strFile = new String(data, "UTF-8");
					    	
					    	srcfiles.parseCash(strFile);
					    	
					    				    	
					//    }
					
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	

}
