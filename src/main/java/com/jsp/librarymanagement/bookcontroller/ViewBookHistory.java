package com.jsp.librarymanagement.bookcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/librarianaccess")
public class ViewBookHistory extends HttpServlet{
        
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewbook=req.getParameter("viewbooklist");
		String checkhistory=req.getParameter("checkhistory");
		String addbook=req.getParameter("addnewbook");
		
		if(viewbook!=null) {
			RequestDispatcher rd= req.getRequestDispatcher("viewbooklist.jsp");
			  rd.forward(req, resp);
		} else if(checkhistory!=null) {
			RequestDispatcher rd= req.getRequestDispatcher("checkhistoryofissuebooks.jsp");
			  rd.forward(req, resp);
		}else if(addbook!=null) {
			RequestDispatcher rd= req.getRequestDispatcher("addbook.jsp");
			  rd.forward(req, resp);
	}}
}
