package com.jsp.librarymanagement.admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adminaccess")
public class ApprovedLibrarianController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String approved=req.getParameter("approvedlai");
		String view=req.getParameter("viewbooklist");
		
		if(approved!=null) {
		
			RequestDispatcher rd= req.getRequestDispatcher("getalllibrarian.jsp");
			  rd.forward(req, resp);
		}else if(view!=null) {
		
			RequestDispatcher rd= req.getRequestDispatcher("viewbooklist.jsp");
			  rd.forward(req, resp);
		}
		
		
		
	}

}
