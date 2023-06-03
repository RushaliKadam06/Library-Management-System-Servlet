package com.jsp.librarymanagement.logincotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registeropetion")
public class RegisterOptionController extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stuRegister=req.getParameter("studentregister");
		String adRegister=req.getParameter("adminregister");
	    String liRegister=req.getParameter("librarianregister");
	    
	    if(stuRegister!=null) {
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentregister.jsp");
	 		requestDispatcher.forward(req, resp);
	    }else if(adRegister!=null) {
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminregister.jsp");
	 		requestDispatcher.forward(req, resp);
	    }else if(liRegister!=null) {
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("librarianregister.jsp");
	 		requestDispatcher.forward(req, resp);
	    }
	}
	
	

}
