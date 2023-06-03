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

@WebServlet("/studentregister")
public class AddStudentController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String contactNo=req.getParameter("contactno");
		String pass=req.getParameter("password");
		
		Student student=new Student();
		student.setStudentName(name);
		student.setStudentEmail(email);
		student.setContactNo(contactNo);
		
		Login login = new Login();
		login.setPassword(pass);
		login.setUsername(email);
		
		StudentService studentService=new StudentService();
		Student s= studentService.saveStudent(student);
		
		LoginService loginService=new LoginService();
		Login l= loginService.saveLogin(login);
		
		if(s!=null && l!=null) {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("succesfullystudentadded.jsp");
		 		requestDispatcher.forward(req, resp);
		}else {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentregister.jsp");
		 		requestDispatcher.forward(req, resp);
		}
	}

}
