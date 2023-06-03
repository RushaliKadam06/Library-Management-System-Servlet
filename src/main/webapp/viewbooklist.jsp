<%@page import="java.util.List"%>
<%@page import="com.jsp.librarymanagement.service.BookService"%>
<%@page import="com.jsp.librarymanagement.dto.Books"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="borrowbook" method="post">
<h1>List Of Books Available</h1>
<% BookService bookService=new BookService(); 
 List<Books> books = bookService.getAllBooks(); 
%>

<table border="2px" cellpadding=22px>
<tr>
<th>Book Id</th>
<th>Book Name</th>
<th>Book Author</th>
<th>Book Addition</th>
<th>Issue Book</th>
</tr>

<% for(Books b:books) { %>
<tr>
<td><%= b.getBookid() %> </td>
<td><%= b.getBookName() %></td>
<td><%= b.getBookAuthor() %></td>
<td><%= b.getBookAddition() %></td>
<td> <a href ="studentidentification.jsp?id=<%=b.getBookid()%>" name="borrow">Borrow Book</a></td>
</tr>

<% } %>

</table>
</form>
</body>
</html>