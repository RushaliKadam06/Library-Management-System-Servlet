package com.jsp.librarymanagement.bookcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrowbook")
public class ViewBooksController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String borrow=req.getParameter("borrow");
		
		if(borrow!=null) {
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentidentification.jsp");
	 		requestDispatcher.forward(req, resp);
		}
	}
	

}
