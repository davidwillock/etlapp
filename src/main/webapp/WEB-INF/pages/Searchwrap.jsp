<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>
	Mutual Fund Search – Mutual Funds 
</title>



<link rel="stylesheet" href="<c:url value="/resources/css/stylesheetsearch.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/Nav.css" />">

        
</head>
<body>
    

        <div class="MAINMENU">
            <div style="margin-left: 520px;">
                <table class="MainMenuHeader" style="width: 380px;">
                    <tr>
                        <td><a href="../default.aspx" id="A48">HOME</a></td>
                        <td><a href="../SignIn.aspx" id="A49">SIGN IN</a></td>
                    
                        <td><a href="https://someurl1" target="_blank">
                            <img src="../images/Icon.png" id="Img13" style="width: 30px;" border="0" /></a></td>
                        <td><a href="http://someurl2" target="_blank">
                            <img src="../images/Icon.png" id="Img14" style="width: 30px;" border="0" /></a></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="Header">
            <div class="MAINMENU">
              <a href="../default.aspx" id="A51">
                            <img src="../images/Logo.png" id="Img1" style="border: none; " /></a>

            </div>
        </div>
        
    
<div style="margin-bottom:10px;">
    <div class="MainMenuHeaderWrapper">
        <div class="MainMenuContents">
            <div class="simplenav fix">
                <ul class="fix">
				
					<li id="MenuPlaceHolder_Nav_liMasterAnalytics" class="here"><a href="Analytics.aspx">Instruments</a>
                        <ul id="MenuPlaceHolder_Nav_ulMasterAnalytics" class="on fix">
                            <li id="MenuPlaceHolder_Nav_liSubMutualFunds" class="SubMenuSelected"><a href="MutualFunds.aspx">Mutual Funds</a></li>
                           
                        </ul>
                    </li>
				
				
				
                    <li id="MenuAbout"><a href="../about.aspx" id="MenuAbout">About</a>
                    </li>
                    
                   <li id="MenuContact"><a href="../Contact.aspx">Contact</a>
                    </li>
                 



                </ul>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".simplenav>ul>li").each(function () {
            initialiseNav(this);
        });

        $(".simplenav>ul>li>a").bind("mouseenter", function () {
            hideAllNav();
            showChildNav(this);
        });

        $(".simplenav").bind("mouseleave", function () {
            hideAllNav();
            showCurrentNav();
        });

    });



    function initialiseNav(navitem) {
        //centre of this button
        var widthone = 0;
        widthone = $(navitem).outerWidth();
        widthone = widthone / 2;

        $(navitem).prevUntil('ul').each(function () {
            widthone = widthone + ($(this).outerWidth());
        });

        //width of subnav
        var widthtwo = 0;
        $(navitem).find("li").each(function () {
            widthtwo = widthtwo + ($(this).outerWidth());
        });
        widthtwo = widthtwo / 2;

        //calculate margin
        var marginvalue = 0;
        marginvalue = widthone - widthtwo;

        if (marginvalue > 0) {
            //set left margin of first subnav item only if it isn't negative
            $(navitem).children("ul").find("li").first().css("margin-left", marginvalue);
        }
    }

    function hideAllNav(menu) {
        $(".simplenav ul ul").removeClass("on fix");
        $(".simplenav ul ul").addClass("off");
    }

    function showChildNav(actOnMe) {
        $(".simplenav li").removeClass("MenuVisible");
        $(actOnMe).parent("li").find("ul").removeClass("off");
        $(actOnMe).parent("li").find("ul").addClass("on fix");
        $(actOnMe).parent("li").not($("li.here")).find("ul").bind("mouseenter", function () {
            $(this).parent("li").addClass("MenuVisible");

        }).bind("mouseleave", function () {
            $(this).parent("li").removeClass("MenuVisible");
        });
    }

    function showCurrentNav() {
        //only do this if it is currently hidden
        if ($(".simplenav li.here ul").hasClass("off")) {
            $(".simplenav li.here ul").removeClass("off");
            $(".simplenav li.here ul").addClass("on fix");
        }
    }
		</script>


        <div class="MainContent">
            <table style="width: 100%;">
                <tr>
                    <td class="left">
                        
    <div id="Search">
	
        <table>
            <tr>
                <td style="padding-right: 20px;">
                    <img src="resources/images/worldsearch.png" id="SearchImg" /></td>
                <td>
                    <div style="font-size: 19px; padding-bottom: 6px;">Search Mutual Funds</div>
                    <input class="SearchTxtBox" type="text" id="TxtSearchTerm" /></td>
                <td style="padding-top: 29px;"><a id="btnSearch" href="#">
                    <img src="resources/images/btnGo.png" id="Button_Img" /></a></td>
            </tr>
        </table>
    
</div>
    <div>
        <br />
    </div>
    <div>
        <div style="clear: both;"></div>
      
        <div>
</div><br />
        <div class="RiskMenu">Mutual Funds By Risk</div>
        <iframe height="700" style="overflow: hidden; border: 0;" scrolling="no" width="632" id="" src="https://nfunds.herokuapp.com/spring/rest/SelectFundsAll" class='autoHeight' frameborder='0' border='0'></iframe>
        <div style="clear: both;"></div>

        
   

                    </td>
                    <td class="right">

                       
                      
                                               
                       
                        <div class="RightSide" >
                            <table>
                                <tr>
                                    <td> <div class="">
                                <a href="../productsservices/ListingServices.aspx" id="A29"><img src="../images/ListingServicesIcon.png" id="Img2" border="0" /></a>
                            </div></td>
                                    <td><div class="RightSideBlock"><a href="../login.aspx" id="A27">Login</a></div>
                            <div class="RightSideBoxText">....</div>
                            <div class="RightSideBoxText">
                                <a href="../info.aspx" id="A11">....</a> 
                            </div></td>
                                </tr>
                            </table>
                           
                            

                        </div>
                        <div class="RightSide">
                              <table>
                                  <tr>
                                      <td><div class="">
                                <a href="../contact.aspx" id="A33"><img src="../images/AcademicIcon.png" id="Img8" border="0" /></a>
                            </div></td>
                                      <td> 
                            <div class="RightSideBlock"><a href="../contact.aspx" id="A32">About </a></div>
                            <div class="RightSideBoxText">....</div>
                            <div class="RightSideBoxText">
                                <a href="../contact.aspx" id="A52">.....</a>  
                            </div></td>
                                  </tr>
                              </table>
                           

                        </div>
                              <div class="RightSide">
                              <table>
                                  <tr>
                                      <td><div class="">
                                <a href="../data.aspx" id="A35"><img src="../images/POSFundFactsIcon.png" id="Img9" border="0" /></a>
                            </div></td>
                                      <td> 
                            <div class="RightSideBlock"><a href="../DataFeed.aspx" id="A34">DataFeed</a></div>
                            <div class="RightSideBoxText">....</div>
                            <div class="RightSideBoxText">
                                <a href="../Datafeed.aspx" id="D1">....</a> 
                            </div></td>
                                  </tr>
                              </table>
                           

                        </div>
                      

                       
       

        </td>
                </tr>
            </table>

        </div>
          <div class="BottomFooter">
            <div class="MainContent">
                
                <table>
                    <tr>
                        
                        <td style="padding-left:16px;">
                            <table class="FooterNav" style="width: 100%;">
                                <tr>
                                    <td>
                            <div class="FooterNav">
                                <ul>
                                    <li><a href="../About.aspx" id="A25">About Us</a></li>
                                    <li><a href="../SignIn.aspx" id="A41">Sign In</a></li>
                                    <li><a href="../Contact.aspx" id="A42">Contact Us</a></li>
                                </ul>
                            </div>
                        </td>
                                    
                                </tr>
                            </table>
                            <div class="FooterNav">
                            </div>
                        </td>
                    </tr>
                </table>


                <div style="font-size: 12px; border-top: 2px solid #ccc; margin-top: 30px;">
                    <table style="width: 100%;">
                        <tr>
                            <td>
                                <br />
                                <br />
                                Website powered by Spring Inc.<br />
                                Mutual Fund Data provided by Charlie1. | <a href="../TermsOfUse.aspx" id="A24">View Terms and Conditions of Use</a>.<br />
                                Financial Market Data powered by <a href="http://charlie1.com" target="_blank">Charlie1.com</a>. All rights reserved. | <a href="http://www.charlie1.com" target="_blank">View Terms of Use</a>.<br />
                                 
                    <br />
                                Charlie1 data is the property of ... Inc. and its licensors. All rights reserved.
                    <br />
                                Charlie1 Indices used with permission.<br />
                                © 2017 Charlie1 Inc. All rights reserved. | <a href="../PrivacyPolicy.aspx" id="A53">View Privacy Policy</a> | <a href="../contact.aspx" id="A54">Contact Us</a>.<br />
                            </td>
                            <td>
                                <img src="../images/FundataLogoFooter.png" /></td>
                        </tr>
                    </table>
                </div>

            </div>

        </div>

       
    </form>
</body>
</html>
