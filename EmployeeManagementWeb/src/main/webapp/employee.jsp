<%@ page import="java.util.*, com.model.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees Data</title>
</head>
<body style="background:cyan">
<marquee>Welcome <%= session.getAttribute("email") %></marquee><hr>
<a href="addEmployee.jsp">Add New Employee</a><hr>
<table border="1">
<tr>
<th>Employee Id</th>
<th>Name</th>
<th>Age</th>
<th>Email</th>
<th>Phone Number</th>
<th>Salary</th>
<th>Update</th>
<th>Delete</th>
</tr>
<% List<Employee> empList=(List<Employee>)request.getAttribute("empList"); 
  for(Employee emp:empList){

%>
<tr>
<td><%=emp.getEmpId()%></td>
<td><%=emp.getName()%></td>
<td><%=emp.getAge()%></td>
<td><%=emp.getEmail()%></td>
<td><%=emp.getNumber()%></td>
<td><%=emp.getSalary()%></td>
<%-- <td><a href="updateEmployee.jsp?id=<%=emp.getEmpId()%>">Update Employee</a></td> --%>
<%-- <td><a href="delete?id=<%=emp.getEmpId()%>">Delete Employee</a></td> --%>
<td><button onclick="location.href='updateEmployee.jsp?id=<%= emp.getEmpId() %>'" style="background:blue;color:white;border:none;padding:5px 10px;cursor:pointer;border-radius:4px;">Update Employee</button></td>
<td><button onclick="location.href='delete?id=<%= emp.getEmpId() %>'" style="background:red;color:white;border:none;padding:5px 10px;cursor:pointer;border-radius:4px;">Delete Employee</button></td>

</tr>
<% } %>
</table><hr>
</body>
</html>