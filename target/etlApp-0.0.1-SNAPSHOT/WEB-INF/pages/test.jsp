<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<title></title>


<link rel="stylesheet" href="<c:url value="/resources/css/Widgets.css" />">


</head>


<body>


<script type="text/javascript" src="<c:url value="resources/js/jquery-1.7.2.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="resources/js/jquery.popupWindow.js" />"> </script>

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


<form name="aspnetForm" method="get" action="https://nfunds.herokuapp.com/spring/rest/SelectCatFunds" id="aspnetForm">
<!--
<input type="hidden" name="a" value="1" /> 
<input type="hidden" name="b" value="2" /> 
-->
<script type="text/javascript">

var theForm = document.forms['aspnetForm'];
if (!theForm) {
    theForm = document.aspnetForm;
}
function getJson(){
   
    
   theForm.submit();
   
}
</script>
<table style="width:100%; border-collapse:collapse; border-spacing:0;" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <div class="WidgetNavTab">
                    <ul>
                        <li id="liTop" class="selected">
                            <a id="lnkBtnTop" href="javascript:__doPostBack()">Top</a>
                        </li>
                        <li id="liBottom">
                            <a id="lnkBtnBottom" href="javascript:__doPostBack()">Bottom</a>
                        </li>
                    </ul>
                </div>
            </td>
            <td>
                 <div class="FilterCat">
                    
                        Filter by Category:
                    <select name="risk" onchange="getJson()" id="RiskFundType" class="WidgetDropDown" style="width:250px;">
	<option selected="selected" value="0">All Categories</option>
	<option value="3">High</option>
	<option value="2">Medium</option>
	<option value="1">Low</option>
	

</select>
                </div>
            </td>
        </tr>
    </table>
</form>

<div id="getTable" class="BorderCurve"></div>



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
   
   
 //  data1  ={"Performance": [{'Symid':'PGMIX'},{'Fundname':'JPMorgan Market Expansion Enh Idx I'},{'Symid':'PGMIX'},{'Fundname':'JPMorgan Market Expansion Enh Idx I'},{'Symid':'ARGFX'},{'Fundname':'Ariel Fund Investor'},{'Symid':'PGMIX'},{'Fundname':'JPMorgan Market Expansion Enh Idx I'},{'Symid':'ARGFX'},{'Fundname':'Ariel Fund Investor'},{'Symid':'BTTRX'},{'Fundname':'American Century Zero Coupon 2025 Inv'},{'Symid':'PGMIX'},{'Fundname':'JPMorgan Market Expansion Enh Idx I'},{'Symid':'ARGFX'},{'Fundname':'Ariel Fund Investor'},{'Symid':'BTTRX'},{'Fundname':'American Century Zero Coupon 2025 Inv'},{'Symid':'VBINX'},{'Fundname':'PIMCO Long-Term US Government Admin'},{'Symid':'PGMIX'},{'Fundname':'JPMorgan Market Expansion Enh Idx I'},{'Symid':'ARGFX'},{'Fundname':'Ariel Fund Investor'},{'Symid':'BTTRX'},{'Fundname':'American Century Zero Coupon 2025 Inv'},{'Symid':'VBINX'},{'Fundname':'PIMCO Long-Term US Government Admin'},{'Symid':'VGSTX'},{'Fundname':'Vanguard Balanced Index Inv'},{'Symid':'PGMIX'},{'Fundname':'JPMorgan Market Expansion Enh Idx I'},{'Symid':'ARGFX'},{'Fundname':'Ariel Fund Investor'},{'Symid':'BTTRX'},{'Fundname':'American Century Zero Coupon 2025 Inv'},{'Symid':'VBINX'},{'Fundname':'PIMCO Long-Term US Government Admin'},{'Symid':'VGSTX'},{'Fundname':'Vanguard Balanced Index Inv'},{'Symid':'PLGBX'},{'Fundname':'Vanguard Balanced Index Inv'}]} 
 //var data1 = {"Performance": [{"symID":"VBINX","assets":247.0,"rank":5.0,"mstarRating":2.0,"netAsset":0.0,"yield":6.0,"dividend":2.0,"mstarRisk":2.0,"alpha":0.0,"beta":0.0,"rsquared":0.0,"rrspeligibility":"yes","stdDev":16.0,"volatileRank":7.0,"mer":1.5,"managers":"Christopher E. Wrazen","fees":0.35,"fundName":"PIMCO Long-Term US Government Admin","inceptionDate":"1998-07-15","load":"no load","maxBackEnd":0.0,"maxFrontEnd":0.0,"saleOpen":"open","navPS":30.0}]}
   
   </script>
   
   
   
   
   
   
<script>
   
   alert("Section");
   
   var table = document.createElement('table');
  // table.setAttribute('class','StdDataGrid'); 
   table.setAttribute('class','FundataWidget');
   table.setAttribute('id','tablejson');
   table.setAttribute('style','border-collapse:collapse');
   table.setAttribute('border','1');
   var a = document.createElement('a');
   a.setAttribute("class","RiskPopup");
 //  var ahref = document.createElement('a');
   var r;
   var c;
   var rowcnt=0;
   var colcnt=0;
   var cnt=0;
   var h;
   var hc;

   
   function factoryTable(jsonarray,skey) { 
   
 
		for(var key in jsonarray) {
		
		
			if(key == skey ){
   
  
				for(var i=0; i < jsonarray[key].length;i++ ){
				
				alert("inside datakey");
				
					
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
							var res = oddOrEven(rowcnt);
							if(res == "even"){
							
									r.setAttribute('class','even');
									alert("even");
							}else{
							
							r.setAttribute('class','odd');
									alert("odd");
							
							}
							
						
						for(var j in col){
							
							
								colcnt++;
							    var colval = jsonarray[key][i][j];
								var hdr = j;
								
								alert(hdr+" : " +colval);
														
								c = document.createElement('td');
								hc = document.createElement('td');
								c.setAttribute('class','Name');
								//c.setAttribute("colspan","20");
								
															
							    var header = document.createElement('th');
								header.setAttribute("class","left");
								header.setAttribute("scope","col");
								//header.setAttribute("colspan","8");
							//	header.width = "450px";
								
								var colname = "";
															
								var txthdr = document.createTextNode(hdr);
								header.appendChild(txthdr);
								
						
								var coltext;
								var txtref;
								var ahref = document.createElement('a');
								if(colcnt == 1){
								
							//	ahref.href = "https://nfunds.herokuapp.com/spring/rest/findbyfunds.aspx?symid="+colval;
									
								ahref.href = "https://nfunds.herokuapp.com/spring/rest/SelectFundsByFund/{'Fund':'"+colval+"'}";
								
								txtref = document.createTextNode(colval);
								ahref.appendChild(txtref);
								ahref.title = "URL";
						
								 
								}else{
								
								coltext = document.createTextNode(colval);
								
							  	}
		    
								if( cnt < cntcols){ hc.appendChild(header); h.appendChild(hc); alert("header " + hdr); }
									
									if (colcnt == 1){c.appendChild(ahref);}else{ c.appendChild(coltext);   }
									
								
									r.appendChild(c);
										cnt++;
										if(cnt == (cntcols)){
											
											table.appendChild(h);
											
										}											}
									
						
					
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
   
   
   var sym  = ${symbolList};
   factoryTable(sym,"Performance");
  // factoryTable(data,"tennis");
    
   
   </script>
   
   
   
   
   
   
   
   
   
  </body>
</html>