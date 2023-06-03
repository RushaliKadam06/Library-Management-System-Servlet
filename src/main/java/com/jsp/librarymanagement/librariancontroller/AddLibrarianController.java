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
@WebServlet("/librarianregister")
public class AddLibrarianController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String contactNo=req.getParameter("contactno");
		String pass=req.getParameter("password");
		
		Librarian librarian=new Librarian();
		librarian.setLibrarianName(name);
		librarian.setLibrarianEmail(email);
		librarian.setContactNo(contactNo);
		librarian.setStatus("Unapproved");
		
		Login login = new Login();
		login.setPassword(pass);
		login.setUsername(email);
		
		LibrarianService librarianService=new LibrarianService();
	    Librarian l =	librarianService.saveLibrarian(librarian);
	    
	    LoginService loginService=new LoginService();
		Login l1= loginService.saveLogin(login);
		
		if(l1!=null && l!=null) {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("succesfullylibrarianadded.jsp");
		 		requestDispatcher.forward(req, resp);
		}else {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("librarianregister.jsp");
		 		requestDispatcher.forward(req, resp);
		}
	}

}
