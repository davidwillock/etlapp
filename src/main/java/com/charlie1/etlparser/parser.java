package com.charlie1.etlparser;


import java.text.ParseException;
import java.text.SimpleDateFormat;

//import org.rosuda.REngine.*;


//import org.rosuda.REngine;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.rosuda.JRI.Rengine;
import com.charlie1.etlwriteto.*;
import com.charlie1.etlvalidatejournal.*;
import com.charlie1.etl.model.journalLookup;
import com.charlie1.etl.model.sendJournalStatus;
import com.charlie1.etl.model.sendTransactionData;
import com.charlie1.etl.model.transactionData;

public class parser {

//	public static void main(String[] args) {
	
	
		// TODO Auto-generated method stubd
	
	static int countBuffers = 0;
	static ArrayList<journalLookup> journalStatusArray = new ArrayList<journalLookup>();
	static ArrayList<transactionData> transArray = new ArrayList<transactionData>();
	
	public void rUtility() {
		
		
		journalLookup jrnlookup = new journalLookup();
		
		System.out.println("rUtility");
		
		
		
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
	
public static void parseCash(String journal,String terminalID,String journalID) {
		
		
		
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
			 
			rpercent = generator.nextInt(10)+1;
			 
		 }else if(transCnt < 20) {
			 
			 rpercent = generator.nextInt(20)+15;
			 
		 }else if(transCnt < 30) {
			 
			 rpercent = generator.nextInt(30)+25;
			 
		 }else if(transCnt < 40) {
			 
			 rpercent = generator.nextInt(40)+35;
			 
		 }else if(transCnt < 50 ) {
			 
			 rpercent = generator.nextInt(50)+45;
			 
		 }else if(transCnt < 60 ) {
			 
			 rpercent = generator.nextInt(60)+55;
			 
		 }else if(transCnt < 70) {
			 
			 rpercent = generator.nextInt(70)+65;
			 
		 }else if(transCnt < 80) {
			 
			 rpercent = generator.nextInt(80)+75;
			 
			 
		 }else if( transCnt < 90) {
			 
			 rpercent = generator.nextInt(90)+94;
			 
			 
		 }else if(transCnt < 100) {
			 
			 rpercent = generator.nextInt(95)+97;
			 
			 
		 }else if(transCnt < 500) {
			 
			 
			 rpercent = generator.nextInt(100)+97;
			 
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
							
							/*
							 Calendar cal = Calendar.getInstance();
							 cal.setTime(d);
							 cal.add(Calendar.MINUTE, 10);
							 transactionStartTime = df.format(cal.getTime());
							 int rsecond = generator.nextInt(60)+10;
							 String rtotalTime = transactionStartTime +":" +rsecond;
							 System.out.println(rtotalTime);
						 	*/
							
						    
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
	*/
	//writetodisk.sendCSVtoMart();
	
		
	
	
	
}


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
		 
		rpercent = generator.nextInt(10)+1;
		 
	 }else if(transCnt < 20) {
		 
		 rpercent = generator.nextInt(20)+10;
		 
	 }else if(transCnt < 30) {
		 
		 rpercent = generator.nextInt(40)+20;
		 
	 }else if(transCnt < 40) {
		 
		 rpercent = generator.nextInt(50)+30;
		 
	 }else if(transCnt < 50 ) {
		 
		 rpercent = generator.nextInt(60)+40;
		 
	 }else if(transCnt < 60 ) {
		 
		 rpercent = generator.nextInt(60)+45;
		 
	 }else if(transCnt < 70) {
		 
		 rpercent = generator.nextInt(70)+55;
		 
	 }else if(transCnt < 80) {
		 
		 rpercent = generator.nextInt(80)+70;
		 
		 
	 }else if( transCnt < 90) {
		 
		 rpercent = generator.nextInt(90)+75;
		 
		 
	 }else if(transCnt < 100) {
		 
		 rpercent = generator.nextInt(95)+80;
		 
		 
	 }else if(transCnt < 500) {
		 
		 
		 rpercent = generator.nextInt(101)+80;
		 
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
	
	if(countBuffers > 5000) {
	sendtran.setTransactionData(transArray);
	sendtran.initialiseData();
	sendjournalstatus.setJournaldata(journalStatusArray);
	sendjournalstatus.initialiseData();
	countBuffers = 0;
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
