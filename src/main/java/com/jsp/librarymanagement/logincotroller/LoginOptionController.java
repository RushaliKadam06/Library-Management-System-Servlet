package com.jsp.librarymanagement.logincotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/optionform")
public class LoginOptionController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login= req.getParameter("login");
		String register= req.getParameter("register");
		
		if(register!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("registeroptionpage.jsp");
			rd.forward(req, resp);
		}else if(login!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("loginoptionpage.jsp");
			rd.forward(req, resp);
		}
	}
}
