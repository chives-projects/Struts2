<%@ page language="java" import="java.util.*"  import="bean.Titles" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  String title=(String) request.getSession().getAttribute("titl");
  String content=(String) request.getSession().getAttribute("content");
  String idString=(String) request.getSession().getAttribute("id");
  System.out.print(idString);
  request.getSession().setAttribute("id", idString);
   %>
  <body>

  <form action="updateForm.do">

    title<input type="text" name="title" value="<%=title %>"/>

  <textarea rows="20" cols="100" name="content"><%=content %></textarea> 
	<input type="submit" value="update">
  </form>
  </body>
</html>
