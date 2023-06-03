package com.jsp.librarymanagement.historycontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.librarymanagement.service.HistoryOfBookService;
@WebServlet("/historylist")
public class HistoryController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String returnBook=req.getParameter("return");
		
		
		if(returnBook!=null) {
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("returnbook.jsp");
 		requestDispatcher.forward(req, resp);
		}
	}

}
