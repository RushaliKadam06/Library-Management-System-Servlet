<%@page import="com.jsp.librarymanagement.dto.HistoryOfBooks"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.librarymanagement.service.HistoryOfBookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="historylist" method="post">
<h1>List Of Books Available</h1>
<% HistoryOfBookService historyOfBookService=new HistoryOfBookService(); 
 List<HistoryOfBooks> historyOfBooks=historyOfBookService.getAllHistory();
%>

<table border="2px" cellpadding=22px>
<tr>

<th>Sr No</th>
<th>Book Id</th>
<th>Student Id</th>
<th>Librarian Id</th>
<th>Date of Issue</th>
<th>Date of return</th>
</tr>

<% for(HistoryOfBooks b:historyOfBooks) { %>
<tr>
<td><%= b.getHistoryNo() %> </td>
<td><%= b.getBooks().getBookid() %></td>
<td><%= b.getStudent().getStudentId() %></td>
<td><%= b.getDateOfIssue() %></td>
<td><%= b.getDateOfReturn() %></td>
<td> <a href ="returnbook.jsp?id=<%=b.getHistoryNo()%>" name="return">Return Book</a></td>
</tr>

<% } %>

</table>
</form>
</body>
</html>