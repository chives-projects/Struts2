<%@ page language="java" import="java.util.*"  import="bean.Comment" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detailedTitle.jsp' starting page</title>
    
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
List userName1List=(List) request.getSession().getAttribute("userName1List");
List commentList=(List) request.getSession().getAttribute("commentList");
String title=(String) request.getSession().getAttribute("title");
String content=(String) request.getSession().getAttribute("content");
%>

<%=title%>
<%=content%>
<br>
Comment

<table border="1">
     <tr>
          <td>userName</td>
		<td>title</td>
      </tr>
       <%for(int i=0;i<userName1List.size();i++)
         {%>
         <tr>
             <td><%=userName1List.get(i) %></td>
			<td><%=commentList.get(i) %><td>

       </tr>
           <%}
      %>
  </table>



<hr>
Publish Comment
<form action="commentForm.do" method="post">
<input type="text" name="comment">
<input type="submit" value="submit">
</form>
  </body>
</html>
