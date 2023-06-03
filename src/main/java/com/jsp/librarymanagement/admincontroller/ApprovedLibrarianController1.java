package com.jsp.librarymanagement.admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/approvedli")
public class ApprovedLibrarianController1 extends HttpServlet {
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String approve=req.getParameter("approved");
		
		if(approve!=null) {
			RequestDispatcher rd= req.getRequestDispatcher("successapproved.jsp");
			  rd.forward(req, resp);
		}
	}
}
