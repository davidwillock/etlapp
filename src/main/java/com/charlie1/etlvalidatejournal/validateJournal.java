package com.charlie1.etlvalidatejournal;

/**
 * 
 */

/**
 * @author admin
 *
 */

import com.charlie1.etl.model.*;
import com.charlie1.etlApp.App;

import org.json.JSONObject;
import org.json.JSONArray;
public class validateJournal {
	
	
	String journalName="";
	String terminalID="";
	
	
	public String getTerminalID() {
		return terminalID;
	}


	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}


	boolean getStatus;
	
	
	
	
	
	
	public void setGetStatus(boolean getStatus) {
		this.getStatus = getStatus;
	}


	public boolean isGetStatus() {
		return getStatus;
	}


	public String getJournalName() {
		return journalName;
	}


	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}


	public validateJournal() { }
	
	
	public void checkJournal() {
		
		
		App app = new App();
		
		//String jrndata = journaldata.getjsonStr();
		String jrndata = app.getJsonStr();
		
		 setGetStatus(false);
		
		try {
		
		
		JSONObject jsonObject = new JSONObject(jrndata);
		
		JSONArray json_datarray = jsonObject.getJSONArray("ETLData");
		
		String strTerminalID = "";
		String strJournalID = "";

		

        for (int i = 0; i < json_datarray.length(); i++) {

            JSONObject rootObj = json_datarray.getJSONObject(i);

            strTerminalID = rootObj.getString("terminalID");
            strJournalID = rootObj.getString("journalID");
            
            if (strTerminalID.equals(getTerminalID()) && strJournalID.equals(getJournalName())){
            	
            	setGetStatus(true);
            	
            	break;
            }
                 
          
            
           
            
            
           
        }  
		
		} catch(Exception ex) {
			
			ex.toString();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
