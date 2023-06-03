package com.jsp.librarymanagement.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.librarymanagement.service.AdminService;

@WebServlet("/approvedfinal")
public class FinalApp extends HttpServlet{
      
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("liId");
		
		int id1=Integer.parseInt(id);
		
		if(id1>0) {
			AdminService adminService=new AdminService();
			adminService.viewAllUnapprovedLibrarian(id1);
		}
	}
}
