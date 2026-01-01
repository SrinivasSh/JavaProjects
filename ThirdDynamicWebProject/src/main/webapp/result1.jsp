<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Scope</title>
</head>
<body>

<!-- using request scope -->
<%-- <%-- <h1> Username=<%=request.getAttribute("username")%></h1>
<h1> Password=<%=request.getAttribute("password")%></h1> --%>

<%-- <!--  using session scope -->
<h1> Username=<%=session.getAttribute("username")%></h1>
<h1> Password=<%=session.getAttribute("password")%></h1> --%>

<!-- using application scope -->
<h1> Username=<%=application.getAttribute("username")%></h1>
<h1> Password=<%=application.getAttribute("password")%></h1>

</body>
</html>