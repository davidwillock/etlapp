<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>


<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/stylesheetperf.css" />">

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.popupWindow.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>



   </head>
<body>

<img src="https://nfunds.herokuapp.com/cagr">

<img src="https://nfunds.herokuapp.com/chart_cagr">

<img src="https://nfunds.herokuapp.com/chartAssetAlloc">


<div id="getTable" class="BorderCurve"></div>

<div>${jsonHoldings} </div>




 
 <script type="text/javascript">
     $(function () {
         $('.RiskPopup').popupWindow({
             width: 860,
             height: 800,
             centerScreen: 1,
             scrollbars: 1,
             resizable: 1
         });
     });
            </script>




<h1>1. Test CSS</h1>

<h2>2. Test JS</h2>
<div id="msg"></div>


<script>

   data = {
  "tennis": [{
    "ProductName": "Babolat Play Pure Drive",
    "Description": "Insert description here.",
	"Price": 379.99,
   
  }, {
    "ProductName": "Yonex AI 98 Tennis Racquet",
    "Description": "Insert description here.",
    "Price": 199.99,
   
  }],
  "basketball": [{
    "ProductName": "Wilson NCAA Solution Official Game Basketball",
    "Description": "Insert description here.",
    "Price": 64.99,
   
  }, {
	"ProductName": "Spalding NBA NeverFlat Size 7 Composite Leather Basketball",
    "Description": "Insert description here.",
    "Price": 59.99,
 
  },{
    "ProductName": "Charlie1",
    "Description": "Insert description here.",
    "Price": 59.99,
   
  },{
    "Description": "Insert description here.",
    "Price": 59.99,
    "ProductName": "Charlie2",
    }],
  "film": [{
    "Horror": "Jane Doe",
    "SciFi": "Matrix",
    "Mystery": "Descent",
  }]
  
  
  
  
}
      
   </script>


<script>
   
   function oddOrEven(x) {
	return ( x & 1 ) ? "odd" : "even";
	}
   
   
   
   
   </script>










 <script>
   
   alert("Section");
   
   var table = document.createElement('table');
   table.setAttribute('class','StdDataGrid');
   table.setAttribute('id','tablejson');
   table.setAttribute('style','border-collapse:collapse');
   table.setAttribute('border','1');
   var a = document.createElement('a');
 //  var ahref = document.createElement('a');
   var r;
   var c;
   var rowcnt=0;
   var colcnt=0;
   var cnt=0;
   var h;
   var hc;

   
   function factoryTable(jsonarray,skey,shref) { 
   
  
		for(var key in jsonarray) {
		
		
			if(key == skey ){
   
 
  
				for(var i=0; i < jsonarray[key].length;i++ ){
				
				
				
					
					var cntjson=0;
					var rows = jsonarray[key].length;
					var cntcols=0;
					var bool = true;
					
					alert("Total Records "+rows);
					
						for(var i=0; i < rows; i++){
     
	 
	                     	var col = jsonarray[key][i];
								
								
							if(bool){
								for(var calc in col){
								
								cntcols++
								}
								bool = false;
								}
														
							r = document.createElement('tr');
                            h =	document.createElement('tr');						
						
						for(var j in col){
								colcnt++;
							    var colval = jsonarray[key][i][j];
								var hdr = j;
								
								alert(hdr+" : " +colval);
														
								c = document.createElement('td');
								hc = document.createElement('td');
								c.setAttribute("colspan","20");
								hc.setAttribute("colspan","20");
															
							    var header = document.createElement('th');
								header.setAttribute("class","center");
								header.setAttribute("scope","col");
								header.setAttribute("colspan","8");
								
								header.width = "800px";
								
								var colname = "";
															
								var txthdr = document.createTextNode(hdr);
								header.appendChild(txthdr);
								
						
								var coltext;
								var txtref;
								var ahref = document.createElement('a');
								if(colcnt == 1){
								
								ahref.href = "https://nfunds.herokuapp.com/spring/rest/findbyfunds.aspx?symid="+colval;
												
								txtref = document.createTextNode(colval);
								ahref.appendChild(txtref);
								ahref.title = "URL";
						
								 
								}else{
								
								coltext = document.createTextNode(colval);
								
							  	}
		    
								if( cnt < cntcols){ hc.appendChild(header); h.appendChild(hc); alert("header " + hdr);  }
									
									if (colcnt == 1){c.appendChild(ahref);}else{ c.appendChild(coltext);   }
									
								
									r.appendChild(c);
									
										cnt++;
										
										if(cnt == (cntcols)){
										
										alert("create Row");
										
										
										table.appendChild(h);
												
												
										
										
										}
										
										
										
									
						}
					
						colcnt=0;
						rowcnt++;									
						alert("next record");
						table.appendChild(r);
			
				}
   
			}
		
		
		 }
   
   }
   
      
 //  document.body.appendChild(table);
 //  document.body.append(a);
 
 var _div = document.getElementById("getTable");
 _div.appendChild(table);
   
   
   }
   
   var hdatas = ${jsonHoldings};
   factoryTable(hdatas,"Holdings","ProductName");
 //  factoryTable(data,"basketball","ProductName");
    
   
   </script>




























</body>
</html>