<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Enter student ID</h1>
<form action="bookissue" method="post">
 Student Id <input type="number" name ="studentId" > <br> <br>
 Book Id <input type="number" name="bookId" value="<%=request.getParameter("id")%>"><br> <br>
 <input type="submit" value ="Submit"> 



</form>

</body>
</html>