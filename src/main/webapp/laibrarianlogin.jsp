<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Login</h1>
<form action="laibrarianlogin" method="post">
<table>
<tr><td>Enter Librarian ID:</td><td><input type="number" name="id"></td></tr>
<tr><td>Enter User name:</td><td><input type="text" name="username"></td></tr>
<tr><td>Enter Password:</td><td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" value=login></td> <td><input type="submit" value=reset></td>
</table>

</form>
</div>
</body>
</html>