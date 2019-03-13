<%@ page language="java" import="java.util.*"  pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lookOwnTitles.jsp' starting page</title>
    
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
<%
List contentList=(List) request.getSession().getAttribute("contentList");
List titlesList=(List) request.getSession().getAttribute("titlesList");
 %>
<form action="beforeUpdateForm.do" method="post">
<table border="1">
     <tr>
          <td>title</td>
		<td>content</td>
      </tr>
       <%for(int i=0;i<titlesList.size();i++)
         {%>
         <tr>
             <td><%=titlesList.get(i) %></td>
			<td><%=contentList.get(i) %><td>
			<td><a href="beforeUpdateForm.do?title=<%=titlesList.get(i) %>&content=<%=contentList.get(i) %>">update</a><td>
       </tr>
           <%}
      %>
  </table>
</form>

  </body>
</html>
