<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dynamic JSP</title>
</head>
<body>
<h3>Dynamic Data Loading</h3>

<% String username=(String)request.getAttribute("username");
   String password=(String)request.getAttribute("password");%>
   
<h3> Hi <%=username%> you are registered successfully </h3>


</body>
</html>