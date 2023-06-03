package com.jsp.librarymanagement.librariancontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jsp.librarymanagement.dto.Librarian;
import com.jsp.librarymanagement.dto.Login;
import com.jsp.librarymanagement.service.LibrarianService;
import com.jsp.librarymanagement.service.LoginService;

@WebServlet("/laibrarianlogin")
public class LibrarianPageController extends HttpServlet {
      
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("id");
		String username=req.getParameter("username");
		String pass=req.getParameter("password");
		
		int id =Integer.parseInt(sid);
		
		LibrarianService librarianService=new LibrarianService();
		Librarian l1= librarianService.getLibrarianById(id);
		
	   
	   LoginService loginService=new LoginService();
	   Login l = loginService.getLoginById(username);
	   
		
		if(l1.getLibrarianEmail().equals(username)==true && l.getPassword().equals(pass)==true) {
			RequestDispatcher rd= req.getRequestDispatcher("librarianaccess.jsp");
			  rd.forward(req, resp);
		}else {
			RequestDispatcher rd= req.getRequestDispatcher("invaliddata.jsp");
			  rd.forward(req, resp);
		}
	}
}
