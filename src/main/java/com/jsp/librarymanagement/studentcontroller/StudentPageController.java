package com.jsp.librarymanagement.studentcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.librarymanagement.dto.Login;
import com.jsp.librarymanagement.dto.Student;
import com.jsp.librarymanagement.service.LoginService;
import com.jsp.librarymanagement.service.StudentService;


@WebServlet("/studentlogin")
public class StudentPageController extends HttpServlet{
          
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("id");
		String username=req.getParameter("username");
		String pass=req.getParameter("password");
		
		int id =Integer.parseInt(sid);
		
		StudentService studentService=new StudentService();
	   Student student = studentService.getStudentById(id);
	   
	   LoginService loginService=new LoginService();
	   Login l = loginService.getLoginById(username);
	   
		
		if(student.getStudentEmail().equals(username)==true && l.getPassword().equals(pass)==true) {
			RequestDispatcher rd= req.getRequestDispatcher("studentaccess.jsp");
			  rd.forward(req, resp);
		}else {
			RequestDispatcher rd= req.getRequestDispatcher("invaliddata.jsp");
			  rd.forward(req, resp);
		}
	}
}
