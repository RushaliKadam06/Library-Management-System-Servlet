package com.jsp.librarymanagement.bookcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.librarymanagement.service.HistoryOfBookService;

@WebServlet("/returnbook")
public class ReturnBook extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("bookId");
		String retu=req.getParameter("returnbook");
		
		int id1=Integer.parseInt(id);
		
		HistoryOfBookService historyOfBookService=new HistoryOfBookService();
		boolean b = historyOfBookService.deleteHistory(id1);
		
		if(b==true && retu!=null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookreturndone.jsp");
	 		requestDispatcher.forward(req, resp);
		}
		
	}

}
