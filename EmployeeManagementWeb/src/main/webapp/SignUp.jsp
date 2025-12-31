<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:cyan">
<h3>Sign Up</h3>
		<form method="post" action="signup">
			<label for="Email">Email:</label> 
			<input type="email" name="Email" placeholder="Enter your email"> <BR><BR>
			<label for="Password">Password:</label>
			<input type="text" name="Password" placeholder="Enter your password"><BR><BR>
			<label for="ConfirmPassword">Confirm Password:</label>
			<input type="password" name="ConfirmPassword" placeholder="Enter your password again"><BR><BR>
			<input type="submit" name="Submit" value="SignUp">
		</form>
<p>Are you a Existing User? <a href="index.html">Back to Login</a>
</body>
</html>