
package com.charlie1.etl.model;

public class jPerformanceReturns {
	
	
		        private String Return;
		     
		        private double OneMonth;
		     
		        private double ThreeMonth;
		       
		        private double SixMonth;
		       
		        private double YTD; 
		      
		        private double OneYear; 
		      
		        private double ThreeYear;
		       
		        private double FiveYear;
		        
		        private double TenYear;
		        
		        public jPerformanceReturns() {}

		        public String getReturn() {
					return Return;
				}

				public void setReturn(String return1) {
					Return = return1;
				}

				public double getOneMonth() {
					return OneMonth;
				}

				public void setOneMonth(double oneMonth) {
					OneMonth = oneMonth;
				}

				public double getThreeMonth() {
					return ThreeMonth;
				}

				public void setThreeMonth(double threeMonth) {
					ThreeMonth = threeMonth;
				}

				public double getSixMonth() {
					return SixMonth;
				}

				public void setSixMonth(double sixMonth) {
					SixMonth = sixMonth;
				}

				public double getYTD() {
					return YTD;
				}

				public void setYTD(double yTD) {
					YTD = yTD;
				}

				public double getOneYear() {
					return OneYear;
				}

				public void setOneYear(double oneYear) {
					OneYear = oneYear;
				}

				public double getThreeYear() {
					return ThreeYear;
				}

				public void setThreeYear(double threeYear) {
					ThreeYear = threeYear;
				}

				public double getFiveYear() {
					return FiveYear;
				}

				public void setFiveYear(double fiveYear) {
					FiveYear = fiveYear;
				}

				public double getTenYear() {
					return TenYear;
				}

				public void setTenYear(double tenYear) {
					TenYear = tenYear;
				}

				@Override
				public String toString() {
					return "{\"Return\":\"" + Return + "\", \"OneMonth\":\"" + OneMonth + "\", \"ThreeMonth\":\""
							+ ThreeMonth + "\", \"SixMonth\":\"" + SixMonth + "\", \"YTD\":\"" + YTD + "\", \"OneYear\":\"" + OneYear
							+ "\", \"ThreeYear\":\"" + ThreeYear + "\", \"FiveYear\":\"" + FiveYear + "\", \"TenYear\":\"" + TenYear + "\"}";
				}
	
	
	
	
	

}
