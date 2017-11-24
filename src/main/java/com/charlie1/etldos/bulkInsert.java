package com.charlie1.etldos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import com.charlie1.etlwriteto.*;

public class bulkInsert {
	
	
	
	public bulkInsert() {}
	
	
	
	
	String commands="";




	public String getCommands() {
		return commands;
	}




	public void setCommands(String commands) {
		this.commands = commands;
	}
	
	
	
			
		
		
	
	
	public void bulkinsert() throws IOException {
		
		// ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\\" && dir");
		writetoDisk writetodisk = new writetoDisk();
		String path = writetodisk.getCsvPath();
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "bcp mfunds.dbo.transactions in "+path +" -c -t, -S localhost -U sa -P \"PA-18 Supercub\"");
		        builder.redirectErrorStream(true);
		        Process p = builder.start();
		        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        String line;
		        while (true) {
		            line = r.readLine();
		            if (line == null) { break; }
		            System.out.println(line);
		        }
		
		
		
		
		
		
		
		
	}
	
	
	public void javaBcp() {
		
		
		writetoDisk writetodisk = new writetoDisk();
		
		String path = writetodisk.getCsvPath();
		String bulkcommand ="cmd /c start bcp mfunds.dbo.transactions in "+path +"-c -t, -S localhost -U sa -P \"PA-18 Supercub\"  ";
		
		
		  Runtime runTime = Runtime.getRuntime();
          Process p = null;
          try {
           p = runTime.exec(bulkcommand);
   } catch (IOException e) {
      e.printStackTrace();
      }
          
          
          try {
          InputStream inputStream = p.getInputStream();
          InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
          BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
          String line;
          while ( (line = bufferedReader.readLine()) != null ) {
           System.out.println(line);
           System.out.println(line);
           
          }
          } catch(Exception ex) {
        	  
        	  ex.printStackTrace();
          }
		
		
		
		
	
	
	
	
	
	
	}
	
	
	

}
