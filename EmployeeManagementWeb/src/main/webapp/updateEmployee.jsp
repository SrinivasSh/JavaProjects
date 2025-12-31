<%@ page import="com.dao.*, com.model.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body style="background:cyan">
<h3>Update Employee Details</h3>

<%
  int empId=Integer.parseInt(request.getParameter("id"));
  EmployeeDao employeeDao=new EmployeeDao();
  Employee emp=employeeDao.getEmployee(empId);
%>
<form action='update' method='post'>
EmpId: <input type="text" name="empId" value="<%= emp.getEmpId() %>" readonly><br><br>
Name: <input type='text' name='name' value=<%=emp.getName()%>><BR><BR>
Age: <input type='number' name='age' value=<%=emp.getAge()%>><BR><BR>
Email: <input type='email' name='email' value=<%=emp.getEmail()%>><BR><BR>
Phone Number<input type='number' name='phone Number' value=<%=emp.getNumber()%>><BR><BR>
Salary <input type='number' name='salary' value=<%=emp.getSalary()%>><BR><BR>
<input type='submit' value='Update'>
</form>

</body>
</html>