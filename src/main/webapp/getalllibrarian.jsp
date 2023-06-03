<%@page import="com.jsp.librarymanagement.service.LibrarianService"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.librarymanagement.dto.Librarian"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="approvedli" method="post">
<h1>List Of Books Available</h1>
<% LibrarianService librarianService=new LibrarianService(); 
 List<Librarian> libr = librarianService.getAllLibrarians(); 
%>

<table border="2px" cellpadding=22px>
<tr>
<th>Librarian Id</th>
<th>Librarian Name</th>
<th>Librarian Email</th>
<th>Librarian Contact No</th>
<th>Librarian Status</th>
<th>Approve Librarian</th>
</tr>

<% for(Librarian b:libr) { %>
<tr>
<td><%= b.getLibrarianId() %> </td>
<td><%= b.getLibrarianName() %></td>
<td><%= b.getLibrarianEmail() %></td>
<td><%= b.getContactNo() %></td>
<td><%= b.getStatus() %></td>
<td> <a href ="successapproved.jsp?id=<%=b.getLibrarianId()%>" name="approved">Approved</a></td>
</tr>

<% } %>

</table>
</form>
</body>
</html>