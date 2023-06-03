package com.jsp.librarymanagement.logincotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginopetion")
public class LoginPageController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stulog=req.getParameter("studentlogin");
		String adlog=req.getParameter("adminlogin");
		String lailog=req.getParameter("librarianlogin");
		
		if(stulog!=null) {
			  RequestDispatcher rd= req.getRequestDispatcher("studentlogin.jsp");
			  rd.forward(req, resp); 
		   }else if(adlog!=null) {
			   RequestDispatcher rd= req.getRequestDispatcher("login.jsp");
				  rd.forward(req, resp);
		   }else if(lailog!=null) {
			   RequestDispatcher rd= req.getRequestDispatcher("laibrarianlogin.jsp");
				 rd.forward(req, resp);
		   }
		
	}
	
}
