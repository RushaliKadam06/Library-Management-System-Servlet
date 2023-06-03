package com.jsp.librarymanagement.admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.librarymanagement.dto.Admin;
import com.jsp.librarymanagement.dto.Login;
import com.jsp.librarymanagement.dto.Student;
import com.jsp.librarymanagement.service.AdminService;
import com.jsp.librarymanagement.service.LoginService;
import com.jsp.librarymanagement.service.StudentService;

@WebServlet("/adminregister")
public class AddAdminController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		Admin admin=new Admin();
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		
		Login login = new Login();
		login.setPassword(pass);
		login.setUsername(email);
		
		AdminService adminService=new AdminService();
		Admin a = adminService.saveAdmin(admin);
		LoginService loginService=new LoginService();
		Login l= loginService.saveLogin(login);
		
		if(a!=null && l!=null) {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("succesfullyadminadded.jsp");
		 		requestDispatcher.forward(req, resp);
		}else {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminregister.jsp");
		 		requestDispatcher.forward(req, resp);
		}
	}

}
