package com.jsp.librarymanagement.studentcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentaccess")
public class StudentAccessController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookAvail=req.getParameter("viewbooklist");
		String returnb=req.getParameter("checkhistory");
		
		if(bookAvail!=null) {
			RequestDispatcher rd= req.getRequestDispatcher("viewbooklist.jsp");
			  rd.forward(req, resp);
		}else if(returnb!=null) {
			RequestDispatcher rd= req.getRequestDispatcher("studentidentification.jsp");
			  rd.forward(req, resp);
		}
	}

}
