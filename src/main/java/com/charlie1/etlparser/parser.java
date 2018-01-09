package com.charlie1.etlparser;


import java.text.ParseException;
import java.text.SimpleDateFormat;

//import org.rosuda.REngine.*;


//import org.rosuda.REngine;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rosuda.JRI.Rengine;
import com.charlie1.etlwriteto.*;
import com.charlie1.etlvalidatejournal.*;
import com.charlie1.etl.model.journalLookup;
import com.charlie1.etl.model.selectAtmInfo;
import com.charlie1.etl.model.selectTransactionData;
import com.charlie1.etl.model.sendJournalStatus;
import com.charlie1.etl.model.sendTransactionData;
import com.charlie1.etl.model.transactionData;
import com.charlie1.etl.model.atmInfoData;
import com.charlie1.etl.model.sendFactTransactionData;
import com.charlie1.etl.model.FactTransactionData;
import com.charlie1.etl.model.storeInfoData;
import com.charlie1.etl.model.bankingData;
import com.charlie1.etl.model.selectStoreInfo;
import com.charlie1.etl.model.selectBankingData;
import com.charlie1.etl.model.sendDimStoreInfo;
import com.charlie1.etl.model.selectBankingData;
import com.charlie1.etl.model.sendDimBankingData;
import com.charlie1.etl.model.sendDimDateTime;
import com.charlie1.etl.model.sendFactAppData;

import com.charlie1.etl.model.selectAtmInfoSP;


public class parser {

//	public static void main(String[] args) {
	
	
		// TODO Auto-generated method stubd
	
	static int countBuffers = 0;
	static ArrayList<journalLookup> journalStatusArray = new ArrayList<journalLookup>();
	static ArrayList<transactionData> transArray = new ArrayList<transactionData>();
	static ArrayList<FactTransactionData> transFactArray = new ArrayList<FactTransactionData>();
	static ArrayList<storeInfoData> storeDimensionArray = new ArrayList<storeInfoData>();
	static ArrayList<bankingData> bankingDimensionArray = new ArrayList<bankingData>();
	
	//final static selectAtmInfo selectatminfo = new selectAtmInfo();
	final static selectStoreInfo selectstoreinfo = new selectStoreInfo();
	final static selectBankingData selectbanking = new selectBankingData();
	
	
	public parser(){ }
	
	
	
	
	
	public void rUtility() {
		
		
		journalLookup jrnlookup = new journalLookup();
		
		
		System.out.println("rUtility");
		
		
	
		
		
		
		
		
		
		

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
	/*
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
	
public static void parseAppLog(String journal,String terminalID,String journalID) {
		
		
		
		writetoDisk writetodisk = new writetoDisk();
		validateJournal evaljrn = new validateJournal();
		
		
		writetodisk.setCsvPath("c:\\home\\charlie\\dataMart.csv");
		
	
		char p;
		
	//	String is = "is";
	//	String paragraph = "transaction is a test.";
		String bufferStr="";
		String bufferDigits="";
		String buffer="";
		String buffToDisk="";
		String journalrecordBuffer="";
		int sumValues=0;
		
		String testCash = new String();
		int sumval=0;
	
	
		char lblCash[]= {'C','A','S','H',' ',' ',' ','\0'};
		String strCash = "CASH   ";
		int transCnt=0;
		
	
		String jrn = journal;
		int jrnLength = jrn.length();
		
		
		
		
	
		
		
	//	int paraLength = paragraph.length();
		
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
							bufferDigits+= jrn.charAt(i);
							bufferStr+= jrn.charAt(i);
							i++;
						}
						
						
						transCnt++;
						buffer += bufferStr;
						buffer += " ";
						buffer += "\r\n";
						System.out.println(bufferStr + " " + "Transaction Count" + " "+ transCnt+" Value "+sumval);
						String csvFormat = "Transact ";
						
						
						sumval = Integer.parseInt(bufferDigits);
						
						sumValues+=sumval;
						
						bufferDigits="";
						
						
						
					}else {
						
						
						
						bufferStr = "";
									
					}
					
					
					
					
					
					
					
					
				}else {
					
					bufferStr="";
					
				}
				
				
				
			}
			
			
			i++;
		}
		
		//long uptime =  parseCashUptime(journal,"","");
		 Random generator = new Random();
		 int rpercent =0;
		 if (transCnt < 10) {
			 
			rpercent = generator.nextInt(10);
			 
		 }else if(transCnt < 20) {
			 
			 rpercent =  generator.nextInt(20);
			 
		 }else if(transCnt < 30) {
			 
			 rpercent = generator.nextInt(30);
			 
		 }else if(transCnt < 40) {
			 
			 rpercent =  generator.nextInt(40);
			 
		 }else if(transCnt < 50 ) {
			 
			 rpercent =  generator.nextInt(50);
			 
		 }else if(transCnt < 60 ) {
			 
			 rpercent =  generator.nextInt(60);
			 
		 }else if(transCnt < 70) {
			 
			 rpercent = generator.nextInt(70);
			 
		 }else if(transCnt < 80) {
			 
			 rpercent =  generator.nextInt(80);
			 
			 
		 }else if( transCnt < 90) {
			 
			 rpercent =  generator.nextInt(90);
			 
			 
		 }else if(transCnt < 100) {
			 
			 rpercent =  generator.nextInt(95);
			 
			 
		 }else if(transCnt < 500) {
			 
			 
			 rpercent = generator.nextInt(100);
			 
		 }
		 
		 
		 
		 
		
		
		
		
		//buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+","+uptime+"\r\n";
		buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+","+rpercent+"\r\n";
		writetodisk.setJournalData(buffToDisk);
		writetodisk.writetoCSV();
		// WE should check the status of the write to file but we cannot verify
		sendJournalStatus sendjournalstatus= new sendJournalStatus();
		journalLookup journallookup = new journalLookup();
		journallookup.setTerminalID(terminalID);
		journallookup.setJournalStatus(journalID);
	
		
		
		sendTransactionData sendtran = new sendTransactionData();
		transactionData transdata = new transactionData();
		transdata.setTerminalID(terminalID);
		transdata.setJournalID(journalID);
		transdata.setAtm_value(sumValues);
		transdata.setAtm_volume(transCnt);
		transdata.setUptime(rpercent);
		
		
		transArray.add(transdata);
		journalStatusArray.add(journallookup);
		
		if(countBuffers > 5000) {
		sendtran.setTransactionData(transArray);
		sendtran.initialiseData();
		sendjournalstatus.setJournaldata(journalStatusArray);
		sendjournalstatus.initialiseData();
		countBuffers = 0;
		}
		//writetodisk.sendCSVtoMart();
		
			
		
		
		countBuffers++;
	}
	
/*	
public static long parseCashUptime(String journal,String terminalID,String journalID) {
	
	
	
	writetoDisk writetodisk = new writetoDisk();
	validateJournal evaljrn = new validateJournal();
	
	
	writetodisk.setCsvPath("c:\\home\\charlie\\dataMart.csv");
	

	char p;
	
//	String is = "is";
//	String paragraph = "transaction is a test.";
//	String bufferStr="";
	String bufferDigits="";
	String buffer="";
	String buffToDisk="";
	String journalrecordBuffer="";
	int sumValues=0;
	
	String testCash = new String();
	int sumval=0;


	char lblCash[]= {'C','A','S','H',' ',' ',' ','\0'};
	char lblCashTaken[]= {'C','a','s','h',' ','t','a','k','e','n','\0'};
	String strCash = "CASH   ";
	String strCashTaken = "Cash taken";
	String strError = "*";
	char lblError[]= {'*','\0'};
	String cashTakenTime ="";
	String errorType="";
	String errorTime="";
    long shophours = 43200;
	
	
	int transCnt=0;
	
	
	String commdata = " *204*18:07:59 Communication error"+"\r\n"
			+" 17:52:34 Cash taken\r\n" + 
			" 936 AIB NSC  931063 CASH    40   17:52:36 Cash taken "
			+"*204*17:53:59 Communication error\r\n"
			+" 18:50:34 Cash presented\r\n" + 
			" 936 AIB NSC  931063 CASH    40   17:52:36 Cash taken "+"\r\n";
			
	
	

	String jrn = journal;
	int jrnLength = jrn.length();
	ArrayList<journalLookup> journalStatusArray = new ArrayList<journalLookup>();
	ArrayList<transactionData> transArray = new ArrayList<transactionData>();
	
	

	
	
//	int paraLength = paragraph.length();
	
    int i=0;
	while(i < jrnLength) {
		
		int j=0;
		while(jrn.charAt(i) != lblError[j] && i < jrnLength-1) {
			i++;
		
			
			
			
		}
		i++;
				
			while(i < jrn.length()-1 &&Character.isDigit(jrn.charAt(i))) {
				i++;
				
			}
			
			if(i < jrn.length() && jrn.charAt(i) ==  lblError[0]){
				
				i++;
			
				 while(i < jrn.length() && jrn.charAt(i) != ' ') {
					
					errorTime+= jrn.charAt(i);
									
					i++;
				
				 }
				 
				 
				 
				 errorType = "";
				 int index = i;
				 i++;
				 switch(jrn.charAt(i)) {
				 
				 case 'S':
					 
					 	errorType = findError(i,jrn);
					 		
					break;
				 case 'C':
					 
					 	errorType = findError(i,jrn);
					 break;
					 
				 default:
					 
					 break;
					 
					 
				 }
				 
				 j=0;
				 if(errorTime != "" && errorType != "") {
					 
					
					 
					 while(jrn.charAt(i) != jrn.length()-1) {
					 
					 String findBuffer="";
					 while(jrn.charAt(i) != 'C' && i < jrn.length()-1  ) {
						 
						 findBuffer+=jrn.charAt(i);
						 
						 i++;
						 
					 }
					 
					 
					//i++;
					j=0;
					String bufferCash="";
					int tmplocation =0;
					if(jrn.charAt(i) == lblCashTaken[j])
						
					while(jrn.charAt(i) ==  lblCashTaken[j] && j < lblCashTaken.length) {
							
						bufferCash+= jrn.charAt(i);
							
							
							i++;
							j++;
						}
					 
					if(bufferCash.equals(strCashTaken))	 {
					 
					 tmplocation = i;
					 
					 String bufferwhere ="";
					 while(jrn.charAt(i) != 'C' )
					 {
						 bufferwhere+=jrn.charAt(i);
						 --i; 
					 }
				
					 --i; 
					 bufferwhere+=jrn.charAt(i);
					 --i;
					 bufferwhere+=jrn.charAt(i);
					 while(jrn.charAt(i) != ' ') {--i;}
					 bufferwhere+=jrn.charAt(i);
					 i++;
					 while(i < jrn.length()-1 && jrn.charAt(i) != ' ') {
						 
						 cashTakenTime+= jrn.charAt(i);
						 i++;
						 
					 }
					 
					 if(cashTakenTime != "") {
					 
						 	i = tmplocation;
						 	
						 	System.out.println(errorType+" "+errorTime+" "+cashTakenTime);
						 	//SimpleDateFormat 
						 	
						 	
						 	
						 	 SimpleDateFormat dfstartTimeformat = new SimpleDateFormat("HH:mm:ss");
							 Date startDate = null;
							 Date endDate = null;
							try {
								startDate = dfstartTimeformat.parse(errorTime);
								endDate = dfstartTimeformat.parse(cashTakenTime);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							
							long diff = startDate.getTime() - endDate.getTime();
							 
							long diffSeconds = diff / 1000 % 60;
							
							
						//	 Calendar cal = Calendar.getInstance();
					//		 cal.setTime(d);
					//		 cal.add(Calendar.MINUTE, 10);
					//		 transactionStartTime = df.format(cal.getTime());
					//		 int rsecond = generator.nextInt(60)+10;
					//		 String rtotalTime = transactionStartTime +":" +rsecond;
					//		 System.out.println(rtotalTime);
						 	
							
						    
							shophours -= diffSeconds;
							
							System.out.println("Uptime:  "+shophours);
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						 	errorType="";
						 	errorTime="";
						 	cashTakenTime="";
						 	break;
						 	
					 }
					 }
					 
				 }
					 
					 
				 } // while loop find cashtaken
				 
			}
		
		
		i++;
	}
	

	
     return shophours;

	
	
	/*
	
	buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+"\r\n";
	writetodisk.setJournalData(buffToDisk);
	writetodisk.writetoCSV();
	// WE should check the status of the write to file but we cannot verify
	sendJournalStatus sendjournalstatus= new sendJournalStatus();
	journalLookup journallookup = new journalLookup();
	journallookup.setTerminalID(terminalID);
	journallookup.setJournalStatus(journalID);

	
	
	sendTransactionData sendtran = new sendTransactionData();
	transactionData transdata = new transactionData();
	transdata.setTerminalID(terminalID);
	transdata.setJournalID(journalID);
	transdata.setAtm_value(sumValues);
	transdata.setAtm_volume(transCnt);
	
	
	transArray.add(transdata);
	sendtran.setTransactionData(transArray);
	sendtran.initialiseData();
	journalStatusArray.add(journallookup);
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	
	//writetodisk.sendCSVtoMart();
	
		
	
	
	
}
*/

public static void parseCashStructured(String journal_,String terminalID,String journalID) {
	
	
	
	writetoDisk writetodisk = new writetoDisk();
	validateJournal evaljrn = new validateJournal();
	
	
	writetodisk.setCsvPath("c:\\home\\charlie\\dataMart.csv");
	

	char p;
	
//	String is = "is";
//	String paragraph = "transaction is a test.";
	String bufferStr="";
	String bufferDigits="";
	String buffer="";
	String buffToDisk="";
	String journalrecordBuffer="";
	int sumValues=0;
	
	//String journal = "01:20:29,Track 2 data:,CASH   200,Cash Taken,No Error\n\r"
	//+"01:20:46,Track 2 data:,CASH   300,Cash Taken,No Error\n\r"
	//+"01:20:50,Track 2 data:,CASH   50,Cash Taken,No Error\n\r";
	
	String journal = journal_;
	
	
	String testCash = new String();
	int sumval=0;


	char lblCash[]= {'C','A','S','H',' ',' ',' ','\0'};
	String strCash = "CASH   ";
	int transCnt=0;
	

	String jrn = journal;
	int jrnLength = jrn.length();
	//ArrayList<journalLookup> journalStatusArray = new ArrayList<journalLookup>();
	//ArrayList<transactionData> transArray = new ArrayList<transactionData>();
	
	
	

	
	
//	int paraLength = paragraph.length();
	
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
				
				
						
				if(jrn.charAt(i) == ' ')
					++i;
				
				
				if(jrn.charAt(i) != 'D' && Character.isDigit(jrn.charAt(i))) {
					
					while(Character.isDigit(jrn.charAt(i))) {
						bufferDigits+= jrn.charAt(i);
						bufferStr+= jrn.charAt(i);
						i++;
					}
					
					
					sumval = Integer.parseInt(bufferDigits);
					
					sumValues+=sumval;
					
					bufferDigits="";
					
					
					transCnt++;
					buffer += bufferStr;
					buffer += " ";
					buffer += "\r\n";
					System.out.println(bufferStr + " " + "Transaction Count" + " "+ transCnt+" Value "+sumval);
					String csvFormat = "Transact ";
					
					
				
					
					
					
				}else {
					
					
					
					bufferStr = "";
								
				}
				
				
				
				
				
				
				
				
			}else {
				
				bufferStr="";
				
			}
			
			
			
		}
		
		
		i++;
	}
	
	
	 Random generator = new Random();
	 int rpercent =0;
	 if (transCnt < 10) {
		 
		rpercent = generator.nextInt(10);
		 
	 }else if(transCnt < 20) {
		 
		 rpercent = generator.nextInt(20);
		 
	 }else if(transCnt < 30) {
		 
		 rpercent = generator.nextInt(40);
		 
	 }else if(transCnt < 40) {
		 
		 rpercent = generator.nextInt(50);
		 
	 }else if(transCnt < 50 ) {
		 
		 rpercent = generator.nextInt(60);
		 
	 }else if(transCnt < 60 ) {
		 
		 rpercent = generator.nextInt(60);
		 
	 }else if(transCnt < 70) {
		 
		 rpercent = generator.nextInt(70);
		 
	 }else if(transCnt < 80) {
		 
		 rpercent = generator.nextInt(80);
		 
		 
	 }else if( transCnt < 90) {
		 
		 rpercent = generator.nextInt(90);
		 
		 
	 }else if(transCnt < 100) {
		 
		 rpercent = generator.nextInt(95);
		 
		 
	 }else if(transCnt < 500) {
		 
		 
		 rpercent = generator.nextInt(100);
		 
	 }
	 	
	buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+"\r\n";
	writetodisk.setJournalData(buffToDisk);
	writetodisk.writetoCSV();
	// WE should check the status of the write to file but we cannot verify
	sendJournalStatus sendjournalstatus= new sendJournalStatus();
	journalLookup journallookup = new journalLookup();
	journallookup.setTerminalID(terminalID);
	journallookup.setJournalStatus(journalID);

	
	
	sendTransactionData sendtran = new sendTransactionData();
	transactionData transdata = new transactionData();
	transdata.setTerminalID(terminalID);
	transdata.setJournalID(journalID);
	transdata.setAtm_value(sumValues);
	transdata.setAtm_volume(transCnt);
	transdata.setUptime(rpercent);
	
	
	

	
	
	
	transArray.add(transdata);
	journalStatusArray.add(journallookup);
	
	if(countBuffers == 10) {
	sendtran.setTransactionData(transArray);
	sendtran.initialiseData();
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	countBuffers = 0;
	return;
	}
	
	
	
	
	
	/*
	sendtran.setTransactionData(transArray);
	sendtran.initialiseData();
	journalStatusArray.add(journallookup);
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	*/
	sumValues =0;
	transCnt =0;
	
	//writetodisk.sendCSVtoMart();
	
		
	countBuffers++;
	
	
}
	


public static void parseCashStructuredToFactTransTbl(String journal_,String terminalID,String journalID) {
	
	
	
	writetoDisk writetodisk = new writetoDisk();
	validateJournal evaljrn = new validateJournal();
	
	
	writetodisk.setCsvPath("c:\\home\\charlie\\dataMart.csv");
	

	char p;
	
//	String is = "is";
//	String paragraph = "transaction is a test.";
	String bufferStr="";
	String bufferDigits="";
	String buffer="";
	String buffToDisk="";
	String journalrecordBuffer="";
	int sumValues=0;
	
	//String journal = "01:20:29,Track 2 data:,CASH   200,Cash Taken,No Error\n\r"
	//+"01:20:46,Track 2 data:,CASH   300,Cash Taken,No Error\n\r"
	//+"01:20:50,Track 2 data:,CASH   50,Cash Taken,No Error\n\r";
	
	String journal = journal_;
	
	
	String testCash = new String();
	int sumval=0;


	char lblCash[]= {'C','A','S','H',' ',' ',' ','\0'};
	String strCash = "CASH   ";
	int transCnt=0;
	

	String jrn = journal;
	int jrnLength = jrn.length();
	//ArrayList<journalLookup> journalStatusArray = new ArrayList<journalLookup>();
	//ArrayList<transactionData> transArray = new ArrayList<transactionData>();
	
	
	

	
	
//	int paraLength = paragraph.length();
	
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
				
				
						
				if(jrn.charAt(i) == ' ')
					++i;
				
				
				if(jrn.charAt(i) != 'D' && Character.isDigit(jrn.charAt(i))) {
					
					while(Character.isDigit(jrn.charAt(i))) {
						bufferDigits+= jrn.charAt(i);
						bufferStr+= jrn.charAt(i);
						i++;
					}
					
					
					sumval = Integer.parseInt(bufferDigits);
					
					sumValues+=sumval;
					
					bufferDigits="";
					
					
					transCnt++;
					buffer += bufferStr;
					buffer += " ";
					buffer += "\r\n";
					System.out.println(bufferStr + " " + "Transaction Count" + " "+ transCnt+" Value "+sumval);
					String csvFormat = "Transact ";
					
					
				
					
					
					
				}else {
					
					
					
					bufferStr = "";
								
				}
				
				
				
				
				
				
				
				
			}else {
				
				bufferStr="";
				
			}
			
			
			
		}
		
		
		i++;
	}
	
	
	 Random generator = new Random();
	 int rpercent =0;
	 if (transCnt < 10) {
		 
		rpercent =  generator.nextInt(10);
		 
	 }else if(transCnt < 20) {
		 
		 rpercent =  generator.nextInt(20);
		 
	 }else if(transCnt < 30) {
		 
		 rpercent = generator.nextInt(40);
		 
	 }else if(transCnt < 40) {
		 
		 rpercent = generator.nextInt(50);
		 
	 }else if(transCnt < 50 ) {
		 
		 rpercent = generator.nextInt(60);
		 
	 }else if(transCnt < 60 ) {
		 
		 rpercent = generator.nextInt(60);
		 
	 }else if(transCnt < 70) {
		 
		 rpercent = generator.nextInt(70);
		 
	 }else if(transCnt < 80) {
		 
		 rpercent = generator.nextInt(80);
		 
		 
	 }else if( transCnt < 90) {
		 
		 rpercent = generator.nextInt(90);
		 
		 
	 }else if(transCnt < 100) {
		 
		 rpercent = generator.nextInt(95);
		 
		 
	 }else if(transCnt < 500) {
		 
		 
		 rpercent = generator.nextInt(100);
		 
	 }
	 
	 	
	buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+"\r\n";
	writetodisk.setJournalData(buffToDisk);
	writetodisk.writetoCSV();
	// WE should check the status of the write to file but we cannot verify
	sendJournalStatus sendjournalstatus= new sendJournalStatus();
	journalLookup journallookup = new journalLookup();
	journallookup.setTerminalID(terminalID);
	journallookup.setJournalStatus(journalID);

	
	
	//sendTransactionData sendtran = new sendTransactionData();
	//transactionData transdata = new transactionData();
	sendFactTransactionData sendFacttransdata = new sendFactTransactionData();
	FactTransactionData transdata = new FactTransactionData();
	selectAtmInfoSP stratminfo = new selectAtmInfoSP();
	
	
	
	
	//String strAtmInfo = selectatminfo.getjsonStr();
	String terminalid ="";
	String custid="";
	String storeid="";
	String bankid ="";
	
	 try {
	        
	        JSONObject jsonObject = new JSONObject(stratminfo.getjsonStr());
	        
	        
	        JSONArray ja_dataFact = jsonObject.getJSONArray("AtmInfoData");

	        int sz = ja_dataFact.length();
	        
	    


	        for (int j = 0; j <ja_dataFact.length(); j++) {

	            JSONObject rootObj = ja_dataFact.getJSONObject(j);

	            terminalid = rootObj.getString("TerminalID");
	            custid = rootObj.getString("CustID");
	            storeid = rootObj.getString("StoreID");
	            bankid = rootObj.getString("BankID");
	           
	            if(terminalid.equals(terminalID)) {
	            	

	            	transdata.setTerminalID(terminalID);
	            	transdata.setJournalID(journalID);
	            	transdata.setAtm_value(sumValues);
	            	transdata.setAtm_volume(transCnt);
	            	transdata.setAtm_upTime(rpercent);
	            	transdata.setCustID(custid);
	            	transdata.setStoreID(storeid);
	            	transdata.setBankID(bankid);
	            	transFactArray.add(transdata);
	            	System.out.println("Found Structured Devices: " + terminalid);
	            	
	            }
	            
	            
	                     
	           
	        }  
	             
	             
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	journalStatusArray.add(journallookup);
	
	if(transFactArray.size() == 5000) {
	
	
	
	sendFacttransdata.setFactTransactionData(transFactArray);
	sendFacttransdata.initialiseData();
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	countBuffers = 0;
	//sendFactAppData sendfactappdata = new sendFactAppData();
	//sendfactappdata.initialiseData();

	}
	
	
	
	
	
	/*
	sendtran.setTransactionData(transArray);
	sendtran.initialiseData();
	journalStatusArray.add(journallookup);
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	*/
	sumValues =0;
	transCnt =0;
	
	//writetodisk.sendCSVtoMart();
	
		
	countBuffers++;
	
	
}


///
public static void parseCashStructuredToApplicationLog(String journal_,String terminalID,String journalID) {
	
	
	
	writetoDisk writetodisk = new writetoDisk();
	validateJournal evaljrn = new validateJournal();
	
	
	writetodisk.setCsvPath("c:\\home\\charlie\\dataMart.csv");
	

	char p;
	
//	String is = "is";
//	String paragraph = "transaction is a test.";
	String bufferStr="";
	String bufferDigits="";
	String buffer="";
	String buffToDisk="";
	String journalrecordBuffer="";
	int sumValues=0;
	
	//String journal = "01:20:29,Track 2 data:,CASH   200,Cash Taken,No Error\n\r"
	//+"01:20:46,Track 2 data:,CASH   300,Cash Taken,No Error\n\r"
	//+"01:20:50,Track 2 data:,CASH   50,Cash Taken,No Error\n\r";
	
	String journal = journal_;
	
	
	String testCash = new String();
	int sumval=0;


	char lblCash[]= {'C','A','S','H',' ',' ',' ','\0'};
	String strCash = "CASH   ";
	int transCnt=0;
	

	String jrn = journal;
	int jrnLength = jrn.length();
	//ArrayList<journalLookup> journalStatusArray = new ArrayList<journalLookup>();
	//ArrayList<transactionData> transArray = new ArrayList<transactionData>();
	
	
	

	
	
//	int paraLength = paragraph.length();
	
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
				
				
						
				if(jrn.charAt(i) == ' ')
					++i;
				
				
				if(jrn.charAt(i) != 'D' && Character.isDigit(jrn.charAt(i))) {
					
					while(Character.isDigit(jrn.charAt(i))) {
						bufferDigits+= jrn.charAt(i);
						bufferStr+= jrn.charAt(i);
						i++;
					}
					
					
					sumval = Integer.parseInt(bufferDigits);
					
					sumValues+=sumval;
					
					bufferDigits="";
					
					
					transCnt++;
					buffer += bufferStr;
					buffer += " ";
					buffer += "\r\n";
					System.out.println(bufferStr + " " + "Transaction Count" + " "+ transCnt+" Value "+sumval);
					String csvFormat = "Transact ";
					
					
				
					
					
					
				}else {
					
					
					
					bufferStr = "";
								
				}
				
				
				
				
				
				
				
				
			}else {
				
				bufferStr="";
				
			}
			
			
			
		}
		
		
		i++;
	}
	
	
	 Random generator = new Random();
	 int rpercent =0;
	 if (transCnt < 10) {
		 
		rpercent =  generator.nextInt(10);
		 
	 }else if(transCnt < 20) {
		 
		 rpercent =  generator.nextInt(20);
		 
	 }else if(transCnt < 30) {
		 
		 rpercent = generator.nextInt(40);
		 
	 }else if(transCnt < 40) {
		 
		 rpercent = generator.nextInt(50);
		 
	 }else if(transCnt < 50 ) {
		 
		 rpercent = generator.nextInt(60);
		 
	 }else if(transCnt < 60 ) {
		 
		 rpercent = generator.nextInt(60);
		 
	 }else if(transCnt < 70) {
		 
		 rpercent = generator.nextInt(70);
		 
	 }else if(transCnt < 80) {
		 
		 rpercent = generator.nextInt(80);
		 
		 
	 }else if( transCnt < 90) {
		 
		 rpercent = generator.nextInt(90);
		 
		 
	 }else if(transCnt < 100) {
		 
		 rpercent = generator.nextInt(95);
		 
		 
	 }else if(transCnt < 500) {
		 
		 
		 rpercent = generator.nextInt(100);
		 
	 }
	 
	 	
	buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+"\r\n";
	writetodisk.setJournalData(buffToDisk);
	writetodisk.writetoCSV();
	// WE should check the status of the write to file but we cannot verify
	sendJournalStatus sendjournalstatus= new sendJournalStatus();
	journalLookup journallookup = new journalLookup();
	journallookup.setTerminalID(terminalID);
	journallookup.setJournalStatus(journalID);

	
	
	//sendTransactionData sendtran = new sendTransactionData();
	transactionData transdata = new transactionData();
	sendFactTransactionData sendFacttransdata = new sendFactTransactionData();
	//FactTransactionData transdata = new FactTransactionData();
	selectAtmInfoSP stratminfo = new selectAtmInfoSP();
	
	
	
	sendTransactionData sendtran = new sendTransactionData();
	
	
	
	
	
	
	
	
	
	
	
	
	
	//String strAtmInfo = selectatminfo.getjsonStr();
	String terminalid ="";
	String custid="";
	String storeid="";
	String bankid ="";
	
	 try {
	        
	        JSONObject jsonObject = new JSONObject(stratminfo.getjsonStr());
	        
	        
	        JSONArray ja_dataFact = jsonObject.getJSONArray("AtmInfoData");

	        int sz = ja_dataFact.length();
	        
	    


	        for (int j = 0; j <ja_dataFact.length(); j++) {

	            JSONObject rootObj = ja_dataFact.getJSONObject(j);

	            terminalid = rootObj.getString("TerminalID");
	            custid = rootObj.getString("CustID");
	            storeid = rootObj.getString("StoreID");
	            bankid = rootObj.getString("BankID");
	           
	            if(terminalid.equals(terminalID)) {
	            	
/*
	            	transdata.setTerminalID(terminalID);
	            	transdata.setJournalID(journalID);
	            	transdata.setAtm_value(sumValues);
	            	transdata.setAtm_volume(transCnt);
	            	transdata.setAtm_upTime(rpercent);
	            	transdata.setCustID(custid);
	            	transdata.setStoreID(storeid);
	            	transdata.setBankID(bankid);
	            	
*/
	            	
	            	transdata.setTerminalID(terminalID);
	            	transdata.setJournalID(journalID);
	            	transdata.setAtm_value(sumValues);
	            	transdata.setAtm_volume(transCnt);
	            	transdata.setUptime(rpercent);
	            	
	            	transArray.add(transdata);
	            	
	            
	            	
	            	
	            	
	            	
	            
	            	System.out.println("Found Structured Devices from Application: " + terminalid);
	            	
	            }
	            
	            
	                     
	           
	        }  
	             
	             
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	journalStatusArray.add(journallookup);
	
	if(transArray.size() == 5000) {
	
		sendtran.setTransactionData(transArray);
    	sendtran.initialiseData();
	
	//sendFacttransdata.setFactTransactionData(transFactArray);
	//sendFacttransdata.initialiseData();
	//sendjournalstatus.setJournaldata(journalStatusArray);
	//sendjournalstatus.initialiseData();
	countBuffers = 0;
	//sendFactAppData sendfactappdata = new sendFactAppData();
	//sendfactappdata.initialiseData();

	}
	
	
	
	
	
	/*
	sendtran.setTransactionData(transArray);
	sendtran.initialiseData();
	journalStatusArray.add(journallookup);
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	*/
	sumValues =0;
	transCnt =0;
	
	//writetodisk.sendCSVtoMart();
	
		
	countBuffers++;
	
	
}



////


public static void parseCashUnStructuredtoFactTbl(String journal,String terminalID,String journalID) {
	
	
	
	writetoDisk writetodisk = new writetoDisk();
	validateJournal evaljrn = new validateJournal();
	
	
	writetodisk.setCsvPath("c:\\home\\charlie\\dataMart.csv");
	

	char p;
	
//	String is = "is";
//	String paragraph = "transaction is a test.";
	String bufferStr="";
	String bufferDigits="";
	String buffer="";
	String buffToDisk="";
	String journalrecordBuffer="";
	int sumValues=0;
	
	String testCash = new String();
	int sumval=0;


	char lblCash[]= {'C','A','S','H',' ',' ',' ','\0'};
	String strCash = "CASH   ";
	int transCnt=0;
	

	String jrn = journal;
	int jrnLength = jrn.length();
	
	
	
	

	
	
//	int paraLength = paragraph.length();
	
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
						bufferDigits+= jrn.charAt(i);
						bufferStr+= jrn.charAt(i);
						i++;
					}
					
					
					transCnt++;
					buffer += bufferStr;
					buffer += " ";
					buffer += "\r\n";
					System.out.println(bufferStr + " " + "Transaction Count" + " "+ transCnt+" Value "+sumval);
					String csvFormat = "Transact ";
					
					
					sumval = Integer.parseInt(bufferDigits);
					
					sumValues+=sumval;
					
					bufferDigits="";
					
					
					
				}else {
					
					
					
					bufferStr = "";
								
				}
				
				
				
				
				
				
				
				
			}else {
				
				bufferStr="";
				
			}
			
			
			
		}
		
		
		i++;
	}
	
	//long uptime =  parseCashUptime(journal,"","");
	 Random generator = new Random();
	 int rpercent =0;
	 if (transCnt < 10) {
		 
		rpercent = generator.nextInt(10);
		 
	 }else if(transCnt < 20) {
		 
		 rpercent = generator.nextInt(20);
		 
	 }else if(transCnt < 30) {
		 
		 rpercent = generator.nextInt(30);
		 
	 }else if(transCnt < 40) {
		 
		 rpercent = generator.nextInt(40);
		 
	 }else if(transCnt < 50 ) {
		 
		 rpercent = generator.nextInt(50);
		 
	 }else if(transCnt < 60 ) {
		 
		 rpercent = generator.nextInt(60);
		 
	 }else if(transCnt < 70) {
		 
		 rpercent = generator.nextInt(70);
		 
	 }else if(transCnt < 80) {
		 
		 rpercent = generator.nextInt(80);
		 
		 
	 }else if( transCnt < 90) {
		 
		 rpercent = generator.nextInt(90);
		 
		 
	 }else if(transCnt < 100) {
		 
		 rpercent = generator.nextInt(95);
		 
		 
	 }else if(transCnt < 500) {
		 
		 
		 rpercent = generator.nextInt(100);
		 
	 }
	 
	 
	 
	 
	
	
	
	
	//buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+","+uptime+"\r\n";
	buffToDisk = terminalID+","+journalID+","+sumValues+","+transCnt+","+rpercent+"\r\n";
	writetodisk.setJournalData(buffToDisk);
	writetodisk.writetoCSV();
	// WE should check the status of the write to file but we cannot verify
	sendJournalStatus sendjournalstatus= new sendJournalStatus();
	journalLookup journallookup = new journalLookup();
	journallookup.setTerminalID(terminalID);
	journallookup.setJournalStatus(journalID);

	
	
/*	sendTransactionData sendtran = new sendTransactionData();
	transactionData transdata = new transactionData();
	transdata.setTerminalID(terminalID);
	transdata.setJournalID(journalID);
	transdata.setAtm_value(sumValues);
	transdata.setAtm_volume(transCnt);
	transdata.setUptime(rpercent);
	
	
	transArray.add(transdata);
	journalStatusArray.add(journallookup);
	
	if(countBuffers > 5000) {
	sendtran.setTransactionData(transArray);
	sendtran.initialiseData();
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	countBuffers = 0;
	}
	//writetodisk.sendCSVtoMart();
*/	
		
	
	
	sendFactTransactionData sendFacttransdata = new sendFactTransactionData();
	FactTransactionData transdata = new FactTransactionData();
	
	
	
	selectAtmInfoSP stratminfo = new  selectAtmInfoSP();
	stratminfo.getjsonStr();
	
	//selectAtmInfo strAtmInfo_ = new  selectAtmInfo();
	//strAtmInfo_.getjsonStr();
	
	
//	String strAtmInfo = selectatminfo.getjsonStr();
	String terminalid ="";
	String custid="";
	String storeid="";
	String bankid ="";
	
	 String jsonstr="";
	 

    	
	 try {
	        
	        JSONObject jsonObject = new JSONObject(stratminfo.getjsonStr());
	        
	        
	    //    JSONArray ja_dataFact = jsonObject.getJSONArray("AtmInfoData");
	        JSONArray ja_dataFact = jsonObject.getJSONArray("AtmInfoData");
	       

	        int sz = ja_dataFact.length();
	        
	    


	        for (int j = 0; j <ja_dataFact.length(); j++) {
	        	
	        	
	        //	System.out.println(" Counter " + countBuffers+ " Current Pointer   " + j);

	            JSONObject rootObj = ja_dataFact.getJSONObject(j);

	            terminalid = rootObj.getString("TerminalID");
	            custid = rootObj.getString("CustID");
	            storeid = rootObj.getString("StoreID");
	            bankid = rootObj.getString("BankID");
	            
	            System.out.println("From SP:  "+terminalid+" , From File:  "+ terminalID);
	            
	           
	            if(terminalid.equals(terminalID)) {
	            	

	            	transdata.setTerminalID(terminalID);
	            	transdata.setJournalID(journalID);
	            	transdata.setAtm_value(sumValues);
	            	transdata.setAtm_volume(transCnt);
	            	transdata.setAtm_upTime(rpercent);
	            	transdata.setCustID(custid);
	            	transdata.setStoreID(storeid);
	            	transdata.setBankID(bankid);
	            	System.out.println("Found UNStructured Devices: " + terminalid);
	            	transFactArray.add(transdata);
	            	
	            }
	            
	            
	                     
	           
	        }  
	             
	             
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
	 
	 
		journallookup.setTerminalID(terminalID);
		journallookup.setJournalStatus(journalID);
		
	//transFactArray.add(transdata);
	journalStatusArray.add(journallookup);
	
	if(transFactArray.size() == 5000) {
	
	
	
	sendFacttransdata.setFactTransactionData(transFactArray);
	sendFacttransdata.initialiseData();
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	countBuffers = 0;
	
	}
	
	System.out.println("Count Transactions " +countBuffers);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	countBuffers++;
}


public void parseTransactionDatatoFactTbl() {
	
	
		selectTransactionData  selectTrans = new selectTransactionData();

		sendFactTransactionData sendFacttransdata = new sendFactTransactionData();
		FactTransactionData transdata = new FactTransactionData();
		
		selectAtmInfoSP stratminfo = new selectAtmInfoSP();
		
		
		String strTrans = selectTrans.getjsonStr();
		String strAtmInfo = stratminfo.getjsonStr();
		String terminalid ="";
		String custid="";
		String storeid="";
		String bankid ="";
		String Terminalid="";
		String Journalid="";
		int Atm_Uptimes=0;
		int Atm_Volume=0;
		int Atm_Value=0;
		
		int counter=0;
		
		 try {
		        
		        JSONObject jsonObjectAtmInfo = new JSONObject(strAtmInfo);
		        JSONObject jsonObjectTrans = new JSONObject(strTrans);
		        
		        JSONArray ja_dataAtmInfo = jsonObjectAtmInfo.getJSONArray("AtmInfoData");
		        JSONArray ja_dataTrans = jsonObjectTrans.getJSONArray("TransactionData");
		        
		        int szAtmInfo = ja_dataAtmInfo.length();
		        int szAtmTrans = ja_dataTrans.length();
		        
		        
		        for (int i = 0; i <ja_dataTrans.length(); i++) {

		            JSONObject rootObjTrans = ja_dataTrans.getJSONObject(i);

		            
		            
		        
		               	for (int j = 0; j <ja_dataAtmInfo.length(); j++) {

		               		JSONObject rootObjAtmInfo = ja_dataAtmInfo.getJSONObject(j);

		               		Terminalid = rootObjTrans.getString("terminalID");
		               		terminalid = rootObjAtmInfo.getString("terminalID");
		               		Journalid = rootObjTrans.getString("journalID");
		               		Atm_Uptimes = rootObjTrans.getInt("uptime");
		               		Atm_Value =  rootObjTrans.getInt("atm_value");
		               		Atm_Volume =  rootObjTrans.getInt("atm_volume");
		               		//   bankid = rootObj.getString("BankID");
		                    custid = rootObjAtmInfo.getString("custid");
		                    storeid = rootObjAtmInfo.getString("storeID");
		                  //  bankid = rootObjAtmInfo.getString("");
		            
		           
		            if(terminalid.equals(Terminalid)) {
		            	
		               	transdata.setTerminalID(terminalid);
		            	transdata.setJournalID(Journalid);
		            	transdata.setAtm_value(Atm_Value);
		            	transdata.setAtm_volume(Atm_Volume);
		            	transdata.setAtm_upTime(Atm_Uptimes);
		            	transdata.setCustID(custid);
		            	transdata.setStoreID(storeid);
		            	transdata.setBankID(bankid);
		            	System.out.println("found unstructure devices");
		            	
		            }
		                  
		               	}    
		               	
		               	
		               	
		            	transFactArray.add(transdata);
//		        		journalStatusArray.add(journallookup);
		        		
		        		if(countBuffers > 5000) {
		        		
		        		
		        		
		        		sendFacttransdata.setFactTransactionData(transFactArray);
		        		sendFacttransdata.initialiseData();
//		        		sendjournalstatus.setJournaldata(journalStatusArray);
//		        		sendjournalstatus.initialiseData();
		        		countBuffers = 0;
		        		}
		        			
		               	
		               	
		               	
		               	
		               	
		               	
		               	
		               	
		               	
		               	
		               	System.out.println(counter);
		               	
		               	countBuffers++;
		               	
		               	
		               	
		               	
		               	
		               	
		               	
		           
		               	}  
		             
		             
		        } catch(Exception ex) {
		        	
		        	ex.printStackTrace();
		        	
		        }
			
	
		
		
		countBuffers++;
	
	
	
	
}

public void parseDatatoDimensionalTbl() {
	
	
	

	String strStoreInfo = selectstoreinfo.getjsonStr();
	String terminalid ="";
	String storeId ="";
	String installDate="";
	String custId="";
	String storeid="";
	String retailId ="";
	String retailName="";
	String retailAddress="";
	String county="";
	String country="";
	int bankId=0;
	String bankName="";
	int costPerTransId=0;
	String city="";
	
		
	 try {
	        
	        JSONObject jsonObjectStoreInfo = new JSONObject(strStoreInfo);
	        JSONArray ja_dataStoreInfo = jsonObjectStoreInfo.getJSONArray("StoreInfoData");
	        int szStoreInfo = ja_dataStoreInfo.length();
	        storeInfoData storeinfo = new storeInfoData();
	        sendDimStoreInfo senddimstoreinfo = new sendDimStoreInfo();
	        
	 //       {"StoreInfoData":[{"country":"Ireland","retailName":"Kub-Fahey","installDate":null,"retailAddress":"749 Scoville Way","custId":"0","county":"Mayo","terminalID":"01356866","storeID":"0","region":null},{"country":"Ireland","retailName":"Kub-Fahey","installDate":null,"retailAddress":"749 Scoville Way","custId":"0","county":"Mayo","terminalID":"01356866","storeID":"0","region":null},{"country":"Ireland","retailName":"Kirlin-Marks","installDate":null,"retailAddress":"5524 Sherman Court","custId":"1","county":"Mayo",
	       
	        
	               	for (int j = 0; j <ja_dataStoreInfo.length(); j++) {

	               		JSONObject rootObjStoreInfo = ja_dataStoreInfo.getJSONObject(j);

	               		storeId = rootObjStoreInfo.getString("storeID");
	               		terminalid = rootObjStoreInfo.getString("terminalID");
	               		installDate = rootObjStoreInfo.getString("installDate");
	               		custId = rootObjStoreInfo.getString("custId");
	               		storeId =  rootObjStoreInfo.getString("storeID");
	               	//	retailId =  rootObjStoreInfo.getString("retailId");
	               	    retailName = rootObjStoreInfo.getString("retailName");
	                    retailAddress = rootObjStoreInfo.getString("retailAddress");
	                    county = rootObjStoreInfo.getString("county");
	                    country = rootObjStoreInfo.getString("country");
	                    city = rootObjStoreInfo.getString("city");
	            
	           
	          
	                    storeinfo.setTerminalID(terminalid);
	                    storeinfo.setInstallDate(installDate);
	                    storeinfo.setCustId(custId);
	                    storeinfo.setStoreID(retailId);
	                    storeinfo.setRetailName(retailName);
	                    storeinfo.setRetailAddress(retailAddress);
	                    storeinfo.setCounty(county);
	                    storeinfo.setCountry(country);
	                    storeinfo.setCity(city);
	            	
	           
	               	
	                    storeDimensionArray.add(storeinfo);
	                }
	               	
	                senddimstoreinfo.setDimStoreInfo(storeDimensionArray);
                    senddimstoreinfo.initialiseData();

	               	
	               	
	               	
	               	
	               	
	        			
	            	String strbankingData = selectbanking.getjsonStr();
	                JSONObject jsonObjectBankingData = new JSONObject(strbankingData);
	    	        JSONArray ja_dataBankingData = jsonObjectBankingData.getJSONArray("BankingData");
	    	        int szBankingData = ja_dataBankingData.length();
	    	        bankingData bankingdata = new bankingData();
	    	        sendDimBankingData senddimbankingdata = new sendDimBankingData();
	    	            
	               	
	               	
	    	      ///  {"BankingData": [{"bankID":1,"bankName":"Bank of Ireland","costPerTransaction":1},{"bankID":1,"bankName":"Bank of Ireland","costPerTransaction":1},
	    	        
	               	for (int j = 0; j <ja_dataBankingData.length(); j++) {

	               		JSONObject rootObjbanking = ja_dataBankingData.getJSONObject(j);

	               		bankId = rootObjbanking.getInt("bankID");
	               		bankName = rootObjbanking.getString("bankID");
	               		costPerTransId = rootObjbanking.getInt("costPerTransaction");
	               		
	           
	          
	               		bankingdata.setBankID(bankId);
	               		bankingdata.setBankName(bankName);
	               		bankingdata.setCostPerTransaction(costPerTransId);
	                   
	            	
	           
	               	
	               		bankingDimensionArray.add(bankingdata);

	        		    

	        		
	        		}
	        	
	               	
	           		
               		senddimbankingdata.setDimBankingData(bankingDimensionArray);
               		senddimbankingdata.initialiseData();
	               	
               		
               		
	               	
	               	
	               	
	               	
	               	
	               	
	               	
	               	
	               	
	               	
	             
	               	
	                     	
	             
	             
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
		
}


public void parseDatatoDimensionalTblSP() {
	
	
	

		
	 try {
	        
		 		sendDimStoreInfo  senddimstoreinfo = new sendDimStoreInfo();
		 		sendDimBankingData senddimbankingdata = new sendDimBankingData();
		 		sendDimDateTime senddimdatetime = new sendDimDateTime();
	             //   senddimstoreinfo.setDimStoreInfo(storeDimensionArray);
                    senddimstoreinfo.initialiseData();
       	          	
	           		
              // 		senddimbankingdata.setDimBankingData(bankingDimensionArray);
              		senddimbankingdata.initialiseData();
	               	
	               	
              		senddimdatetime.initialiseData();
	               	
	               	
	               	
	               	
	               	
	               	
	               	
	               	
	             
	               	
	                     	
	             
	             
	        } catch(Exception ex) {
	        	
	        	ex.printStackTrace();
	        	
	        }
		
}



public static String findError(int index, String journal) {
	
	String bufferStr ="";
	
	int i = index;
	while(journal.charAt(i) != '\n') {
		
		bufferStr+= journal.charAt(i); 
		i++;	
			
		}
			
	
	
	return bufferStr;
	
	
}




	
	

}
