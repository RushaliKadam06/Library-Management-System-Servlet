package com.jsp.librarymanagement.studentcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.librarymanagement.service.StudentService;
@WebServlet("/bookissue")
public class IdentifyAndBookIssue extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("studentId");
		String bid=req.getParameter("bookId");
		
		int sid1=Integer.parseInt(sid);
		int bid1=Integer.parseInt(bid);
		
		if(sid1>0 && bid1>0) {
			StudentService studentService=new StudentService();
			boolean b = studentService.borrowBook(bid1, sid1);
			if(b==true) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("succesfullybookissue.jsp");
		 		requestDispatcher.forward(req, resp);
			}else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("invaliddata.jsp");
		 		requestDispatcher.forward(req, resp);
			}
		}
		
	}

}
