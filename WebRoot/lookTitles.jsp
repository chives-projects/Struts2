<%@ page language="java" import="java.util.*"  pageEncoding="ISO-8859-1"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lookTitle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<a href="LookOwnTitles">update own titles</a>
<br>
<% 
List userNameList=(List) request.getSession().getAttribute("userNameList");
List titlesList=(List) request.getSession().getAttribute("titlesList");
 %>
Titles List
<form action="detailedForm.do" method="post">

<table border="1">
     <tr>
          <td>userName</td>
		<td>title</td>
      </tr>
       <%for(int i=0;i<userNameList.size();i++)
         {%>
         <tr>
             <td><%=userNameList.get(i) %></td>
			<td><a href="detailedForm.do?title=<%=titlesList.get(i) %>&userName1=<%=userNameList.get(i) %>"><%=titlesList.get(i) %></a><td>

       </tr>
           <%}
      %>
  </table>


</form>
<a href="publish.jsp">publish</a>

  </body>
</html>
