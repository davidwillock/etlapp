
package com.charlie1.etl.model;

import java.util.Date;

public class jHDstats {
	
	

	        private String symbol;
	  
	        private Date epoch;
	 
	        private double open;

	        private double high;
	      
	        private double low;

	        private double close;
	        
	        private double close_adj;
	     
	        private double volume;
	        
	        public jHDstats() {}

			public String getSymbol() {
				return symbol;
			}

			public void setSymbol(String symbol) {
				this.symbol = symbol;
			}

			public Date getEpoch() {
				return epoch;
			}

			public void setEpoch(Date epoch) {
				this.epoch = epoch;
			}

			public double getOpen() {
				return open;
			}

			public void setOpen(double open) {
				this.open = open;
			}

			public double getHigh() {
				return high;
			}

			public void setHigh(double high) {
				this.high = high;
			}

			public double getLow() {
				return low;
			}

			public void setLow(double low) {
				this.low = low;
			}

			public double getClose() {
				return close;
			}

			public void setClose(double close) {
				this.close = close;
			}

			public double getClose_adj() {
				return close_adj;
			}

			public void setClose_adj(double close_adj) {
				this.close_adj = close_adj;
			}

			public double getVolume() {
				return volume;
			}

			public void setVolume(double volume) {
				this.volume = volume;
			}

			@Override
			public String toString() {
				return "{\"symbol\":\"" + symbol + "\", \"epoch\":\"" + epoch + "\", \"open\":\"" + open + ", \"high\":" + high
						+ "\", \"low\":\"" + low + "\", \"close\":\"" + close + "\", \"close_adj\":\"" + close_adj + "\", \"volume\":\"" + volume + "\"}";
			}
	
	
			
	        
	
	
	

}
