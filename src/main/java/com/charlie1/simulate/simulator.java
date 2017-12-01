package com.charlie1.simulate;


import com.charlie1.etlwriteto.writetoDisk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class simulator {
	
	
	
	String time="";
	int transCount=0;
	String transactionstr="";
	int dayofmonth=0;
	
	String folder="";
	String terminal="";
	
	String month="";
	String day="";
	int journalcnt=0;
	int transactioncnt=0;
	
	String journalDaySingle="";
	
	String transactionStartTime="";

	
	public simulator() {}
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getTransCount() {
		return transCount;
	}

	public void setTransCount(int transCount) {
		this.transCount = transCount;
	}

	
	

	
	public void setTransactionStr(String transactionstr) {
		this.transactionstr = transactionstr;
	}

	public int getDayofMonth() {
		return dayofmonth;
	}

	public void setDayofMonth(int dayofmonth) {
		this.dayofmonth = dayofmonth;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getJournalDay() {
		return day;
	}

	public void setJournalDay(String day) {
		this.day = day;
	}
	
	
	public String getJournalDaySingle() {
		return journalDaySingle;
	}

	
	
	
	
	
	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public int getJournalcnt() {
		
		return journalcnt;
		
	}

	
	public void setJournalcnt(int journalcnt) {
		
		this.journalcnt = journalcnt;
		
		
	}
	
	
	
	
	
	public int getTransactioncnt() {
		
		return transactioncnt;
		
	}
	
	
	// retrieve journal data 
		public String getTransactionStr() {
			return transactionstr;
		}

		// Transaction Counter
	   public void setTransactioncnt(int transactioncnt) {
		
		this.transactioncnt = transactioncnt;
		
		
	  }
	   
		// Transaction Counter
		public void setTransactionStartTime(String transactionStartTime) {
			
			this.transactionStartTime = transactionStartTime;
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	Random generator = new Random();
	
	
	public void createTransactions() {
		
		int value = 0;
		
		ArrayList<Integer> shufflenumbers=new ArrayList<Integer>();
		shufflenumbers.add(10);
		shufflenumbers.add(20);
		shufflenumbers.add(50);
		shufflenumbers.add(100);

		
			
	
	int i=0;
	while(i<=transactioncnt) {
		
		
	
		 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		 Date d = null;
		try {
			d = df.parse(transactionStartTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.MINUTE, 10);
		 transactionStartTime = df.format(cal.getTime());
		 int rsecond = generator.nextInt(60)+10;
		 String rtotalTime = transactionStartTime +":" +rsecond;
		 System.out.println(rtotalTime);
		
		 
		 
		// int c = random.nextBoolean() ? a : b;

		 Collections.shuffle(shufflenumbers);
		value =	shufflenumbers.get(0);
		 
		 
	
		String transaction=rtotalTime+",Track 2 data:,CASH   "+value+",Cash Taken,No Error \r\n";
		System.out.println(transaction);
		transactionstr += transaction;
		
		
		i++;
		
		
		
		
		
	}
	
	
	}
	
	
	
public void createJournalFilesBatch() {
		
		
		int value = 0;
		Random generator = new Random();
	
				
		
				 SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM");
				 SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
				 Date m = null;
				 Date d = null;
				
						
			
			int i=0;
			while(i<=journalcnt) {
				
				
				
				try {
				//	m = dfm.parse(month);
					d = dfd.parse(day);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				// Calendar calm = Calendar.getInstance();
				// calm.setTime(m);
			    //	 calm.add(Calendar.MONTH, 01);
		        //		 myMonth = dfm.format(calm.getTime());
				 
				Calendar cald = Calendar.getInstance();
				cald.setTime(d);
				 
				 cald.add(Calendar.DAY_OF_MONTH, dayofmonth);
				 day = dfd.format(cald.getTime());
				 
				 String strday = day.replaceAll("-", "");
				 
												
				i++;
				
				
			}
		
		
	}
	
	

public void createJournalFilesSingle() {
	
	
	int value = 0;
	Random generator = new Random();

			
	
			 SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM");
			 SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
			 Date m = null;
			 Date d = null;
			
					
				
			try {
			//	m = dfm.parse(month);
				d = dfd.parse(day);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			// Calendar calm = Calendar.getInstance();
			// calm.setTime(m);
		    //	 calm.add(Calendar.MONTH, 01);
	        //		 myMonth = dfm.format(calm.getTime());
			 
			Calendar cald = Calendar.getInstance();
			cald.setTime(d);
			 
			 cald.add(Calendar.DAY_OF_MONTH, dayofmonth);
			 day = dfd.format(cald.getTime());
			 
			 journalDaySingle = day.replaceAll("-", "");
			 
			 
			 
		
			
			
			
		}



public void createRandomFolders() {
	
			Random generator = new Random();
			int folder = generator.nextInt(9999999)+1000000;
			
			
			
			String defaultPath = "C:\\home\\charlie\\Journaljrn\\";
			String customPath="";
			
			
			int i=0;
			while(i <= 10);
			 customPath += defaultPath;
			 Path path = Paths.get(customPath);
		        //if directory exists?
		        if (!Files.exists(path)) {
		            try {
		                Files.createDirectories(path);
		            } catch (IOException e) {
		                //fail to create directory
		                e.printStackTrace();
		            }
		        }
			
		    i++;
			}


	
	
	
}
