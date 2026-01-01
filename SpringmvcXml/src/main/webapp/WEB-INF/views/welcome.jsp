<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<h1>Hi ${name} Welcome to Spring MVC</h1>

	<form method="post" action="signUp">

		Email:<input type="text" name="email"> 
		Password:<input type="password" name="password"> 
				<input type="submit" value="Submit">
	</form>

</body>
</html>