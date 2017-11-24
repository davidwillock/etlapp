package com.charlie1.etlwriteto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.charlie1.etldos.*;
import com.charlie1.etldos.*;

public class writetoDisk {
	
	static  String csvPath;
	
	public writetoDisk() {}

	String journalData;
	
	
	
	
	
	
	
	public String getJournalData() {
		return journalData;
	}
	public void setJournalData(String journalData) {
		this.journalData = journalData;
	}
	public String getCsvPath() {
		return csvPath;
	}
	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}

	
	public void createCSV() {
		
		
		final String FILENAME = getCsvPath();
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = getJournalData();

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		
		
		
		
		
		
		
	}

	public void writetoCSV() {
		
		
		final String FILENAME = getCsvPath();
		
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data = getJournalData();

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	


public void sendCSVtoMart() {
		
		
		bulkInsert bulkinsert = new bulkInsert();
	
	
		final String FILENAME = getCsvPath();
		
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data = getJournalData();

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (file.exists()) {
		
				bulkinsert.bulkinsert();
		
				System.out.println("Sent To Mart");
				
				
			}else {
				
				System.out.println("File doesnt exist!!");
				
			}

			
			
			
			
			
			
			

		} catch (Exception e) {

			e.printStackTrace();

		
		}
	
	
	
	
}
	
	

}
