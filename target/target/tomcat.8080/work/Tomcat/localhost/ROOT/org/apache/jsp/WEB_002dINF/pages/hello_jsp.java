/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.11
 * Generated at: 2017-12-04 23:15:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hello_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/home/charlie/Develop/Java/oxygen_workspace/etlApp/target/target/tomcat.8080/webapps/expanded/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153381482000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1502980940000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   </head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<img src=\"https://nfunds.herokuapp.com/cagr\">\r\n");
      out.write("\r\n");
      out.write("<img src=\"https://nfunds.herokuapp.com/chart_cagr\">\r\n");
      out.write("\r\n");
      out.write("<img src=\"https://nfunds.herokuapp.com/chartAssetAlloc\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"getTable\" class=\"BorderCurve\"></div>\r\n");
      out.write("\r\n");
      out.write("<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jsonHoldings}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write("     $(function () {\r\n");
      out.write("         $('.RiskPopup').popupWindow({\r\n");
      out.write("             width: 860,\r\n");
      out.write("             height: 800,\r\n");
      out.write("             centerScreen: 1,\r\n");
      out.write("             scrollbars: 1,\r\n");
      out.write("             resizable: 1\r\n");
      out.write("         });\r\n");
      out.write("     });\r\n");
      out.write("            </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1>1. Test CSS</h1>\r\n");
      out.write("\r\n");
      out.write("<h2>2. Test JS</h2>\r\n");
      out.write("<div id=\"msg\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("   data = {\r\n");
      out.write("  \"tennis\": [{\r\n");
      out.write("    \"ProductName\": \"Babolat Play Pure Drive\",\r\n");
      out.write("    \"Description\": \"Insert description here.\",\r\n");
      out.write("\t\"Price\": 379.99,\r\n");
      out.write("   \r\n");
      out.write("  }, {\r\n");
      out.write("    \"ProductName\": \"Yonex AI 98 Tennis Racquet\",\r\n");
      out.write("    \"Description\": \"Insert description here.\",\r\n");
      out.write("    \"Price\": 199.99,\r\n");
      out.write("   \r\n");
      out.write("  }],\r\n");
      out.write("  \"basketball\": [{\r\n");
      out.write("    \"ProductName\": \"Wilson NCAA Solution Official Game Basketball\",\r\n");
      out.write("    \"Description\": \"Insert description here.\",\r\n");
      out.write("    \"Price\": 64.99,\r\n");
      out.write("   \r\n");
      out.write("  }, {\r\n");
      out.write("\t\"ProductName\": \"Spalding NBA NeverFlat Size 7 Composite Leather Basketball\",\r\n");
      out.write("    \"Description\": \"Insert description here.\",\r\n");
      out.write("    \"Price\": 59.99,\r\n");
      out.write(" \r\n");
      out.write("  },{\r\n");
      out.write("    \"ProductName\": \"Charlie1\",\r\n");
      out.write("    \"Description\": \"Insert description here.\",\r\n");
      out.write("    \"Price\": 59.99,\r\n");
      out.write("   \r\n");
      out.write("  },{\r\n");
      out.write("    \"Description\": \"Insert description here.\",\r\n");
      out.write("    \"Price\": 59.99,\r\n");
      out.write("    \"ProductName\": \"Charlie2\",\r\n");
      out.write("    }],\r\n");
      out.write("  \"film\": [{\r\n");
      out.write("    \"Horror\": \"Jane Doe\",\r\n");
      out.write("    \"SciFi\": \"Matrix\",\r\n");
      out.write("    \"Mystery\": \"Descent\",\r\n");
      out.write("  }]\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("      \r\n");
      out.write("   </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("   \r\n");
      out.write("   function oddOrEven(x) {\r\n");
      out.write("\treturn ( x & 1 ) ? \"odd\" : \"even\";\r\n");
      out.write("\t}\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <script>\r\n");
      out.write("   \r\n");
      out.write("   alert(\"Section\");\r\n");
      out.write("   \r\n");
      out.write("   var table = document.createElement('table');\r\n");
      out.write("   table.setAttribute('class','StdDataGrid');\r\n");
      out.write("   table.setAttribute('id','tablejson');\r\n");
      out.write("   table.setAttribute('style','border-collapse:collapse');\r\n");
      out.write("   table.setAttribute('border','1');\r\n");
      out.write("   var a = document.createElement('a');\r\n");
      out.write(" //  var ahref = document.createElement('a');\r\n");
      out.write("   var r;\r\n");
      out.write("   var c;\r\n");
      out.write("   var rowcnt=0;\r\n");
      out.write("   var colcnt=0;\r\n");
      out.write("   var cnt=0;\r\n");
      out.write("   var h;\r\n");
      out.write("   var hc;\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   function factoryTable(jsonarray,skey,shref) { \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\t\tfor(var key in jsonarray) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tif(key == skey ){\r\n");
      out.write("   \r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("\t\t\t\tfor(var i=0; i < jsonarray[key].length;i++ ){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar cntjson=0;\r\n");
      out.write("\t\t\t\t\tvar rows = jsonarray[key].length;\r\n");
      out.write("\t\t\t\t\tvar cntcols=0;\r\n");
      out.write("\t\t\t\t\tvar bool = true;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\talert(\"Total Records \"+rows);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tfor(var i=0; i < rows; i++){\r\n");
      out.write("     \r\n");
      out.write("\t \r\n");
      out.write("\t                     \tvar col = jsonarray[key][i];\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tif(bool){\r\n");
      out.write("\t\t\t\t\t\t\t\tfor(var calc in col){\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tcntcols++\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tbool = false;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tr = document.createElement('tr');\r\n");
      out.write("                            h =\tdocument.createElement('tr');\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tfor(var j in col){\r\n");
      out.write("\t\t\t\t\t\t\t\tcolcnt++;\r\n");
      out.write("\t\t\t\t\t\t\t    var colval = jsonarray[key][i][j];\r\n");
      out.write("\t\t\t\t\t\t\t\tvar hdr = j;\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\talert(hdr+\" : \" +colval);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tc = document.createElement('td');\r\n");
      out.write("\t\t\t\t\t\t\t\thc = document.createElement('td');\r\n");
      out.write("\t\t\t\t\t\t\t\tc.setAttribute(\"colspan\",\"20\");\r\n");
      out.write("\t\t\t\t\t\t\t\thc.setAttribute(\"colspan\",\"20\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t    var header = document.createElement('th');\r\n");
      out.write("\t\t\t\t\t\t\t\theader.setAttribute(\"class\",\"center\");\r\n");
      out.write("\t\t\t\t\t\t\t\theader.setAttribute(\"scope\",\"col\");\r\n");
      out.write("\t\t\t\t\t\t\t\theader.setAttribute(\"colspan\",\"8\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\theader.width = \"800px\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tvar colname = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tvar txthdr = document.createTextNode(hdr);\r\n");
      out.write("\t\t\t\t\t\t\t\theader.appendChild(txthdr);\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tvar coltext;\r\n");
      out.write("\t\t\t\t\t\t\t\tvar txtref;\r\n");
      out.write("\t\t\t\t\t\t\t\tvar ahref = document.createElement('a');\r\n");
      out.write("\t\t\t\t\t\t\t\tif(colcnt == 1){\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tahref.href = \"https://nfunds.herokuapp.com/spring/rest/findbyfunds.aspx?symid=\"+colval;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\ttxtref = document.createTextNode(colval);\r\n");
      out.write("\t\t\t\t\t\t\t\tahref.appendChild(txtref);\r\n");
      out.write("\t\t\t\t\t\t\t\tahref.title = \"URL\";\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tcoltext = document.createTextNode(colval);\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t  \t}\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t\t\t\t\t\t\tif( cnt < cntcols){ hc.appendChild(header); h.appendChild(hc); alert(\"header \" + hdr);  }\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (colcnt == 1){c.appendChild(ahref);}else{ c.appendChild(coltext);   }\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.appendChild(c);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tcnt++;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif(cnt == (cntcols)){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"create Row\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttable.appendChild(h);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tcolcnt=0;\r\n");
      out.write("\t\t\t\t\t\trowcnt++;\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\talert(\"next record\");\r\n");
      out.write("\t\t\t\t\t\ttable.appendChild(r);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("   \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t }\r\n");
      out.write("   \r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("      \r\n");
      out.write(" //  document.body.appendChild(table);\r\n");
      out.write(" //  document.body.append(a);\r\n");
      out.write(" \r\n");
      out.write(" var _div = document.getElementById(\"getTable\");\r\n");
      out.write(" _div.appendChild(table);\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   var hdatas = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jsonHoldings}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("   factoryTable(hdatas,\"Holdings\",\"ProductName\");\r\n");
      out.write(" //  factoryTable(data,\"basketball\",\"ProductName\");\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("   </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/pages/hello.jsp(8,29) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/resources/css/main.css");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      if (!_jspx_th_c_005furl_005f0_reused) {
        _jspx_th_c_005furl_005f0.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005furl_005f0);
      }
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /WEB-INF/pages/hello.jsp(9,29) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/resources/css/stylesheetperf.css");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      if (!_jspx_th_c_005furl_005f1_reused) {
        _jspx_th_c_005furl_005f1.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005furl_005f1);
      }
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f2_reused = false;
    try {
      _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f2.setParent(null);
      // /WEB-INF/pages/hello.jsp(11,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setValue("/resources/js/jquery.1.10.2.min.js");
      int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
      if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      _jspx_th_c_005furl_005f2_reused = true;
    } finally {
      if (!_jspx_th_c_005furl_005f2_reused) {
        _jspx_th_c_005furl_005f2.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005furl_005f2);
      }
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f3_reused = false;
    try {
      _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f3.setParent(null);
      // /WEB-INF/pages/hello.jsp(12,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f3.setValue("/resources/js/jquery.popupWindow.js");
      int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
      if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      _jspx_th_c_005furl_005f3_reused = true;
    } finally {
      if (!_jspx_th_c_005furl_005f3_reused) {
        _jspx_th_c_005furl_005f3.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005furl_005f3);
      }
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f4_reused = false;
    try {
      _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f4.setParent(null);
      // /WEB-INF/pages/hello.jsp(13,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f4.setValue("/resources/js/main.js");
      int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
      if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      _jspx_th_c_005furl_005f4_reused = true;
    } finally {
      if (!_jspx_th_c_005furl_005f4_reused) {
        _jspx_th_c_005furl_005f4.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005furl_005f4);
      }
    }
    return false;
  }
}
