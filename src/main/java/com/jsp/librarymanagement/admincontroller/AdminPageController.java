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
import com.jsp.librarymanagement.service.AdminService;
import com.jsp.librarymanagement.service.LoginService;
@WebServlet("/login")
public class AdminPageController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("id");
		String username=req.getParameter("username");
		String pass=req.getParameter("password");
		
		int id =Integer.parseInt(sid);
		
		AdminService adminService=new AdminService();
		
		Admin l1 = adminService.getAdminById(id);
	   
	   LoginService loginService=new LoginService();
	   Login l = loginService.getLoginById(username);
	   
		
		if(l1.getAdminEmail().equals(username)==true && l.getPassword().equals(pass)==true) {
			RequestDispatcher rd= req.getRequestDispatcher("adminaccess.jsp");
			  rd.forward(req, resp);
		}else {
			RequestDispatcher rd= req.getRequestDispatcher("invaliddata.jsp");
			  rd.forward(req, resp);
		}
	}
}
