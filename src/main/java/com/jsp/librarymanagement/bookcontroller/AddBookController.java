package com.jsp.librarymanagement.bookcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.librarymanagement.dto.Books;
import com.jsp.librarymanagement.service.BookService;

@WebServlet("/addBook")
public class AddBookController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("bookName");
		String author=req.getParameter("bookAuthor");
		String addition=req.getParameter("bookAddition");
		
		Books books=new Books();
		books.setBookName(name);
		books.setBookAuthor(author);
		books.setBookAddition(addition);
		
		BookService bookService=new BookService();
		Books b= bookService.saveBook(books);
		
		if(b!=null) {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("succesfullybookadded.jsp");
		 		requestDispatcher.forward(req, resp);
		}else {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("addbook.jsp");
		 		requestDispatcher.forward(req, resp);
		}
	}

}
