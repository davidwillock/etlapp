package com.charlie1.etlparsefolders;

import java.io.File;

public class parseFolders  {
	
	
	String path="";
	
	
	public void setPath(String path) {
		
		this.path = path;
		
	}
	
	public String getPath() {
		
		
		return path;
	}
	
	
	
	parseFolders(){
		
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
	
	
	
	
/*
	public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	*/
	
	
	
	
	
	

}
